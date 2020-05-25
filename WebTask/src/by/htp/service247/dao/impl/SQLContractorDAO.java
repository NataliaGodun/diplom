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

	@Override
	public Contractor authorization(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
