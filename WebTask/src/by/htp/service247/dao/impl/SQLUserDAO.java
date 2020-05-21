
package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.UserDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.User;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class SQLUserDAO implements UserDAO {
	private static final String USER_SELECT_LOGIN_PASSWORD = "SELECT * FROM USERS WHERE LOGIN=? AND PASSWORD=? AND STATUS='EXIST'";
	private static final String USER_SELECT_LOGIN = "SELECT * FROM USERS WHERE LOGIN=? AND STATUS='EXIST'";
	private static final String USER_ADD = "INSERT INTO USERS (NAME,LOGIN,PASSWORD,ROLE,STATUS) VALUES (?,?,?,?,?)";
	private static final String EDIT_PROFILE_NAME = "UPDATE USERS SET NAME=? WHERE LOGIN=? AND STATUS='EXIST'";
	private static final String EDIT_PROFILE_PASSWORD = "UPDATE USERS SET PASSWORD=? WHERE LOGIN=? AND STATUS='EXIST'";
	private static final String GUEST = "guest";
	private static final String EXIST = "exist";
	private static final String MESSAGE_ERROR_CONNECTION_POOL = "Error at connection pool.";
	private static final String MESSAGE_ERROR_SQL = "Error at sql.";
	private static final String MESSAGE_ERROR_REMOVE_CONNECTION = "Error at remove connection.";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;
	private static final int FOURTH = 4;
	private static final int FIFTH = 5;

	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public User authorization(String login, String password) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		User user = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(USER_SELECT_LOGIN_PASSWORD);
			ps.setString(FIRST, login);
			ps.setString(SECOND, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				String name = rs.getString(SECOND);
				String loginBD = rs.getString(THIRD);
				String passwordBD = rs.getString(FOURTH);
				String role = rs.getString(FIFTH);
				user = new User(id, name, loginBD, passwordBD, role);
			}

		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return user;
	}

	@Override
	public User registration(String name, String login, String password) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		User user = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(USER_SELECT_LOGIN);
			ps.setString(FIRST, login);
			rs = ps.executeQuery();

			int i = 0;
			while (rs.next()) {
				i = rs.getInt("id");
			}
			if (i == 0) {
				ps = con.prepareStatement(USER_ADD);

				ps.setString(FIRST, name);
				ps.setString(SECOND, login);
				ps.setString(THIRD, password);
				ps.setString(FOURTH, GUEST);
				ps.setString(FIFTH, EXIST);
				ps.executeUpdate();

				ps = con.prepareStatement(USER_SELECT_LOGIN_PASSWORD);
				ps.setString(FIRST, login);
				ps.setString(SECOND, password);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(FIRST);
					String nameBD = rs.getString(SECOND);
					String loginBD = rs.getString(THIRD);
					String passwordBD = rs.getString(FOURTH);
					String role = rs.getString(FIFTH);
					user = new User(id, nameBD, loginBD, passwordBD, role);
				}
			}
		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return user;
	}

	@Override
	public User editProfileName(String name, String login) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		User user = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(EDIT_PROFILE_NAME);
			ps.setString(FIRST, name);
			ps.setString(SECOND, login);
			ps.executeUpdate();

			ps = con.prepareStatement(USER_SELECT_LOGIN);
			ps.setString(FIRST, login);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				String nameBD = rs.getString(SECOND);
				String loginBD = rs.getString(THIRD);
				String passwordBD = rs.getString(FOURTH);
				String role = rs.getString(FIFTH);
				user = new User(id, nameBD, loginBD, passwordBD, role);
			}
		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return user;
	}

	@Override
	public User editProfilePassword(String password, String login) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		User user = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(EDIT_PROFILE_PASSWORD);
			ps.setString(FIRST, password);
			ps.setString(SECOND, login);
			ps.executeUpdate();

			ps = con.prepareStatement(USER_SELECT_LOGIN);
			ps.setString(FIRST, login);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				String nameBD = rs.getString(SECOND);
				String loginBD = rs.getString(THIRD);
				String passwordBD = rs.getString(FOURTH);
				String role = rs.getString(FIFTH);
				user = new User(id, nameBD, loginBD, passwordBD, role);
			}
		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return user;
	}

}