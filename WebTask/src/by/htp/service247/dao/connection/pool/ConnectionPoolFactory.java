package by.htp.service247.dao.connection.pool;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public final class ConnectionPoolFactory {

	private static final ConnectionPoolFactory instance = new ConnectionPoolFactory();
	private final ConnectionPool pool = new ConnectionPoolimpl();

	private ConnectionPoolFactory() {

	}

	public static ConnectionPoolFactory getInstance() {
		return instance;
	}

	public ConnectionPool getConnectionPool() {
		return pool;
	}
}
