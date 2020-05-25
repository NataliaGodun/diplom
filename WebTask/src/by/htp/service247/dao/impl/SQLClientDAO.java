package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Client;


public class SQLClientDAO implements ClientDAO {
	private static final String CLIENT_SELECT_LOGIN_PASSWORD = "SELECT * FROM CLIENT WHERE LOGIN=? AND PASSWORD=? AND STATUS='EXIST'";
	private static final String MESSAGE_ERROR_CONNECTION_POOL = "Error at connection pool.";
	private static final String MESSAGE_ERROR_SQL = "Error at sql.";
	private static final String MESSAGE_ERROR_REMOVE_CONNECTION = "Error at remove connection.";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;
	private static final int FOURTH = 4;
	private static final int FIFTH = 5;
	
	@Override
	public Client authorization(String login, String password) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Client client = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(CLIENT_SELECT_LOGIN_PASSWORD);
			ps.setString(FIRST, login);
			ps.setString(SECOND, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				 int id =rs.getInt(FIRST);
			     String email=rs.getString(SECOND);
				 String firstName=rs.getString(THIRD);
				 String lastName=rs.getString(FOURTH);
				 String phone=rs.getString(FIFTH);
				 String address=rs.getString(FIFTH);
				 String status=rs.getString(FIFTH);
				 String loginDB=rs.getString(FIFTH);
				 String passwordDB=rs.getString(FIFTH);
				 String servSant=rs.getString(FIFTH);
				 String servElectr=rs.getString(FIFTH);
				 String servVent=rs.getString(FIFTH);

				client= new Client(id,email, firstName, lastName, phone, address,status,loginDB,passwordDB, servSant,servElectr,servVent);
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
		return client;
	}

	@Override
	public Client registration(Client client) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> showClient() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
