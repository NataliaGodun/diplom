package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Client;
import by.htp.service247.domain.Contractor;

public class SQLContractorDAO implements ContractorDAO {
private static final String USER_SELECT_LOGIN_PASSWORD = "SELECT * FROM CONTRACTOR WHERE LOGIN=? AND PASSWORD=? AND STATUS='EXIST'";
	
	private static final String MESSAGE_ERROR_CONNECTION_POOL = "Error at connection pool.";
	private static final String MESSAGE_ERROR_SQL = "Error at sql.";
	private static final String MESSAGE_ERROR_REMOVE_CONNECTION = "Error at remove connection.";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;
	private static final int FOURTH = 4;
	private static final int FIFTH = 5;
	private static final int SIXTH = 6;
	private static final int SEVENTH = 7;
	private static final int EIGHTH = 8;
	private static final int NINTH = 9;
	private static final int TENTH = 10;

	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public Contractor authorization(String login, String password) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Contractor contractor = null;

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
				String firstName = rs.getString(SECOND);
				String lastName = rs.getString(THIRD);
				String phone = rs.getString(FOURTH);
				String dateOfBirth = rs.getString(FIFTH );
				int id_contract_contractor = rs.getInt(SIXTH);
				String loginDB = rs.getString(SEVENTH);
				String passwordDB = rs.getString(EIGHTH);
				String status = rs.getString(NINTH);
				String role = rs.getString(TENTH);
				
				contractor = new Contractor(id, firstName, lastName, phone, dateOfBirth, id_contract_contractor, loginDB,passwordDB,status,role);
		
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
		return contractor;
	}


}
