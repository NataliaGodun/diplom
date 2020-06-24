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
	private static final String CLIENT_ADD ="INSERT INTO CLIENT (email, firstName, lastName, phone,address,status,login,password,servSant,servElectr, servVent) VALUES(?,?,?,?,?,?,?,?,?,?,?)";		
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
	private static final int ELEVENTH = 11;
	private static final int TVELFTH = 12;
	
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
				 String address=rs.getString(SIXTH);
				 String status=rs.getString(SEVENTH);
				 String loginDB=rs.getString(EIGTTH);
				 String passwordDB=rs.getString(NINETH);
				 String servSant=rs.getString(TENTH);
				 String servElectr=rs.getString(ELEVENTH);
				 String servVent=rs.getString(TVELFTH );

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
		Connection con = null;
		ResultSet rs = null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps =  con.prepareStatement(CLIENT_ADD);
		
				ps.setString(FIRST, client.getEmail());
				ps.setString(SECOND, client.getFirstName());
				ps.setString(THIRD, client.getLastName());
				ps.setString(FOURTH, client.getPhone());
				ps.setString(FIFTH, client.getAddress());
				ps.setString(SIXTH, client.getStatus());
				ps.setString(SEVENTH, client.getLogin());		
				ps.setString(EIGTTH, client.getPassword());
				ps.setString(NINETH, client.getServSant());
				ps.setString(TENTH, client.getServElectr());
				ps.setString(ELEVENTH, client.getServVent());
				ps.executeUpdate();
				
			
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
			//	LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return client;
	}


}
