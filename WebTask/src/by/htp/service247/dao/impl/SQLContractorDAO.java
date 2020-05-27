package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	private static final String CONTRACTOR_SELECT_LOGIN_PASSWORD = "SELECT * FROM CONTRACTOR WHERE LOGIN=? AND PASSWORD=? AND STATUS='EXIST'";
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
	private static final int EIGTTH = 8;
	private static final int NINETH = 9;
	private static final int TENTH = 10;
	@Override
	public Contractor authorization(String login, String password) throws DAOException {
		System.out.println(login);
		System.out.println(password);
		Connection con = null;
		ResultSet rs = null;
		Contractor contractor = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(CONTRACTOR_SELECT_LOGIN_PASSWORD);
			ps.setString(FIRST, login);
			ps.setString(SECOND, password);
			rs = ps.executeQuery();
			while (rs.next()) {

				 int id =rs.getInt(FIRST);
			     String firstName=rs.getString(SECOND);
				 String lastName=rs.getString(THIRD);
				 String phone=rs.getString(FOURTH);
				 String dateOfBirth=rs.getString(FIFTH);
				 String loginDB=rs.getString(SIXTH );
				 String passwordDB=rs.getString(SEVENTH);
				 String status=rs.getString(EIGTTH);
				 String role=rs.getString(NINETH);
				 String department=rs.getString(TENTH);
				 

				 contractor= new Contractor(id,firstName, lastName, phone, dateOfBirth,loginDB,passwordDB,status,role,department);
				 System.out.println(contractor.getId());
			}

		} catch (ConnectionPoolException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return contractor;
	}


	@Override
	public Contractor registration(Contractor contractor) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contractor> showContractor() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContractor(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}



}
