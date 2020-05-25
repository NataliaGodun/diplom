package by.htp.service247.dao.connection.pool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ñonnect to the database
 * 
 * @author Godun Natalia
 * @version 1.0
 */

public final class ConnectionPoolimpl implements ConnectionPool {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	//private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1/nata?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "ER567ghm";
	private static final String MESSAGE_SQL_EXCEPTION_CONNECTION_POOL = "SQLException in ConnectionPool";
	private static final String MESSAGE_ERROR_CLOSING_CONNECTION = "Error closing the connection.";
	private static final String MESSAGE_ERROR_FIND_DATABASE_DRIVER = "Can't find database driver class";
	private static final String MESSAGE_ERROR_CONNECTION_DATA_SOURCE = "Error connecting to the data source.";
	private static final String MESSAGE_CONNECTION_NOT_RETURN_POOL = "Connection isn't return to the pool.";
	private static final String MESSAGE_RESULTSET_IS_NOT_CLOSED = "ResultSet isn't closed.";
	private static final String MESSAGE_STATEMENT_IS_NOT_CLOSED = "Statement isn't closed.";
	private static final String MESSAGE_ERROR_REMOVE_DATA_SOURCE = "Error remove to the data source.";
	private static final String MESSAGE_ATTEMPTING_CLOSE_CLOSED_CONNECTION = "Attempting to close closed connection.";
	private static final String MESSAGE_ERROR_DELETING_CONNECTION = "Error deleting connection from the given away connections pool.";
	private static final String MESSAGE_ERROR_ALLOCATING_CONNECTION = "Error allocating connection in the pool.";

	private static final Logger LOGGER = LogManager.getRootLogger();
	private BlockingQueue<Connection> connectionQueue;
	private BlockingQueue<Connection> givenAwayConQueue;
	private String driverName;
	private String url;
	private String user;
	private String password;
	private int poolSize;

	ConnectionPoolimpl() {
		this.driverName = DRIVER_NAME;
		this.url = URL;
		this.user = USER;
		this.password = PASSWORD;
		this.poolSize = 2;

	}

	public void initPoolData() throws ConnectionPoolException {
		try {
			Class.forName(driverName);
			givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				PooledConnection pooledConnection = new PooledConnection(connection);
				connectionQueue.add(pooledConnection);
			}
		} catch (SQLException e) {
			
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CLOSING_CONNECTION, e);
			throw new ConnectionPoolException(MESSAGE_SQL_EXCEPTION_CONNECTION_POOL, e);
			
		} catch (ClassNotFoundException e) {
			
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CLOSING_CONNECTION, e);
			throw new ConnectionPoolException(MESSAGE_ERROR_FIND_DATABASE_DRIVER, e);
		}
	}

	public void dispose() {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() {
		try {
			closeConnectionsQueue(givenAwayConQueue);
			closeConnectionsQueue(connectionQueue);
		} catch (SQLException e) {

			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CLOSING_CONNECTION, e);
		}
	}

	public Connection takeConnection() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConQueue.add(connection);
		} catch (InterruptedException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_DATA_SOURCE, e);
			throw new ConnectionPoolException(MESSAGE_ERROR_CONNECTION_DATA_SOURCE, e);
		}
		return connection;
	}

	public void removeConnection() throws ConnectionPoolException {
		Connection connection;
		try {
			connection = givenAwayConQueue.take();
			connectionQueue.add(connection);
		} catch (InterruptedException e) {

			LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_DATA_SOURCE, e);
		}
	}

	public void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			con.close();
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_CONNECTION_NOT_RETURN_POOL);
		}
		try {
			rs.close();
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_RESULTSET_IS_NOT_CLOSED);
		}
		try {
			st.close();
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_STATEMENT_IS_NOT_CLOSED);
		}
	}

	public void closeConnection(Connection con, Statement st) {
		try {
			con.close();
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_CONNECTION_NOT_RETURN_POOL);
		}
		try {
			st.close();
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_STATEMENT_IS_NOT_CLOSED);
		}
	}

	private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
		Connection connection;
		while ((connection = queue.poll()) != null) {
			if (!connection.getAutoCommit()) {
				connection.commit();
			}
			((PooledConnection) connection).reallyClose();
		}
	}

	private class PooledConnection implements Connection {
		private Connection connection;

		public PooledConnection(Connection c) throws SQLException {
			this.connection = c;
			this.connection.setAutoCommit(true);
		}

		public void reallyClose() throws SQLException {
			connection.close();
		}

		@Override
		public void clearWarnings() throws SQLException {
			connection.clearWarnings();
		}

		@Override
		public void close() throws SQLException {
			if (connection.isClosed()) {
				throw new SQLException(MESSAGE_ATTEMPTING_CLOSE_CLOSED_CONNECTION);
			}

			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}
			if (!givenAwayConQueue.remove(this)) {
				throw new SQLException(MESSAGE_ERROR_DELETING_CONNECTION);
			}
			if (!connectionQueue.offer(this)) {
				throw new SQLException(MESSAGE_ERROR_ALLOCATING_CONNECTION);
			}
		}

		@Override
		public void commit() throws SQLException {
			connection.commit();
		}

		@Override
		public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
			return connection.createArrayOf(typeName, elements);
		}

		@Override
		public Blob createBlob() throws SQLException {
			return connection.createBlob();
		}

		@Override
		public Clob createClob() throws SQLException {
			return connection.createClob();
		}

		@Override
		public NClob createNClob() throws SQLException {
			return connection.createNClob();
		}

		@Override
		public SQLXML createSQLXML() throws SQLException {
			return connection.createSQLXML();
		}

		@Override
		public Statement createStatement() throws SQLException {
			return connection.createStatement();
		}

		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
			return connection.createStatement(resultSetType, resultSetConcurrency);
		}

		@Override
		public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
			return connection.createStruct(typeName, attributes);
		}

		@Override
		public boolean getAutoCommit() throws SQLException {
			return connection.getAutoCommit();
		}

		@Override
		public String getCatalog() throws SQLException {
			return connection.getCatalog();
		}

		@Override
		public Properties getClientInfo() throws SQLException {
			return connection.getClientInfo();
		}

		@Override
		public String getClientInfo(String name) throws SQLException {
			return connection.getClientInfo(name);
		}

		@Override
		public int getHoldability() throws SQLException {
			return connection.getHoldability();
		}

		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			return connection.getMetaData();

		}

		@Override
		public int getTransactionIsolation() throws SQLException {
			return connection.getTransactionIsolation();
		}

		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return connection.getTypeMap();
		}

		@Override
		public SQLWarning getWarnings() throws SQLException {
			return connection.getWarnings();
		}

		@Override
		public boolean isClosed() throws SQLException {
			return connection.isClosed();
		}

		@Override
		public boolean isReadOnly() throws SQLException {
			return connection.isReadOnly();
		}

		@Override
		public boolean isValid(int timeout) throws SQLException {
			return connection.isValid(timeout);
		}

		@Override
		public String nativeSQL(String sql) throws SQLException {
			return connection.nativeSQL(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			return connection.prepareCall(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public PreparedStatement prepareStatement(String sql) throws SQLException {
			return connection.prepareStatement(sql);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
			return connection.prepareStatement(sql, autoGeneratedKeys);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
			return connection.prepareStatement(sql, columnIndexes);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
			return connection.prepareStatement(sql, columnNames);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
		}

		@Override
		public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public void rollback() throws SQLException {
			connection.rollback();
		}

		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			connection.setAutoCommit(autoCommit);
		}

		@Override
		public void setCatalog(String catalog) throws SQLException {
			connection.setCatalog(catalog);
		}

		@Override
		public void setClientInfo(String name, String value) throws SQLClientInfoException {
			connection.setClientInfo(name, value);
		}

		@Override
		public void setHoldability(int holdability) throws SQLException {

			connection.setHoldability(holdability);
		}

		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			connection.setReadOnly(readOnly);
		}

		@Override
		public Savepoint setSavepoint() throws SQLException {
			return connection.setSavepoint();
		}

		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			return connection.setSavepoint(name);
		}

		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			connection.setTransactionIsolation(level);
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return connection.isWrapperFor(iface);
		}

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			return connection.unwrap(iface);
		}

		@Override
		public void abort(Executor arg0) throws SQLException {
			connection.abort(arg0);
		}

		@Override
		public int getNetworkTimeout() throws SQLException {
			return connection.getNetworkTimeout();
		}

		@Override
		public String getSchema() throws SQLException {
			return connection.getSchema();
		}

		@Override
		public void releaseSavepoint(Savepoint arg0) throws SQLException {
			connection.releaseSavepoint(arg0);
		}

		@Override
		public void rollback(Savepoint arg0) throws SQLException {
			connection.rollback(arg0);
		}

		@Override
		public void setClientInfo(Properties arg0) throws SQLClientInfoException {
			connection.setClientInfo(arg0);
		}

		@Override
		public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
			connection.setNetworkTimeout(arg0, arg1);
		}

		@Override
		public void setSchema(String arg0) throws SQLException {
			connection.setSchema(arg0);
		}

		@Override
		public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
			connection.setTypeMap(arg0);
		}
	}
}
