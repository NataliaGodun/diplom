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

	@Override
	public Client authorization(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
