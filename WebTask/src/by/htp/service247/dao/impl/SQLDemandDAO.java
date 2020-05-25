package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.DemandDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;

import by.htp.service247.domain.Demand;

public class SQLDemandDAO implements DemandDAO {

	@Override
	public ArrayList<Demand> showDemand(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Demand addDemand(Demand demand) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDemand(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Demand editDemand(Demand demand) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Demand> showDemand(String department) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
