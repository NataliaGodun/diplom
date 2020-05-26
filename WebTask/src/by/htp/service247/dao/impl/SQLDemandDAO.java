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
import by.htp.service247.domain.Client;
import by.htp.service247.domain.Demand;

public class SQLDemandDAO implements DemandDAO {

	private static final String SELECT_ALL_DEMAND_CLIENT = "SELECT * FROM DEMAND WHERE ID_CLIENT=?";
	private static final String TAKE_DEMAND_FROM_ID = "SELECT * FROM DEMAND WHERE ID=?";
	private static final String ADD_DEMAND = "INSERT INTO DEMAND (id_contractor, id_client, status_demand, department, describtion,photo, time, address ) VALUES(?,?,?,?,?,?,?,?)";
	private static final String DEMAND_SELECT = "SELECT * FROM DEMAND WHERE describtion=? AND time=? ";
	private static final String SELECT_BOOK_ID = "SELECT * FROM BOOKS WHERE ID=? AND STATUS='EXIST' ";
	private static final String DELETE_BOOK_ID = "UPDATE BOOKS SET STATUS='DELETE' WHERE ID=?";
	private static final String SELECT_NAME_OF_BOOK = "SELECT * FROM BOOKS WHERE NAMEBOOK=? AND STATUS='EXIST' ";
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
	@Override
	public ArrayList<Demand> showDemand(int id) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Demand demand = null;

		ArrayList<Demand> List = new ArrayList<Demand>();

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();

		try {

			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_DEMAND_CLIENT);
			ps.setInt(FIRST, id);
		
			rs = ps.executeQuery();
			while (rs.next()) {
				int idDB = rs.getInt(FIRST);
				int id_contractor = rs.getInt(SECOND);
				int  id_client = rs.getInt(THIRD);
				String status_demand = rs.getString(FOURTH);
				String department = rs.getString(FIFTH);
				String describtion = rs.getString(SIXTH);
				String photo = rs.getString(SEVENTH);
				String time = rs.getString(EIGTTH);
				String address = rs.getString(NINETH );
				demand = new Demand(idDB, id_contractor, id_client, status_demand, department, describtion, photo,time,address );
			
				List.add(demand);
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

		return List;
	}


	@Override
	public Demand addDemand(Demand demand) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Demand demand2=null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(ADD_DEMAND);

			ps.setInt(FIRST, demand.getId_contractor());
			ps.setInt(SECOND, demand.getId_client());
			ps.setString(THIRD, demand.getStatus_demand());
			ps.setString(FOURTH, demand.getDepartment());
			ps.setString(FIFTH, demand.getDescribtion());
			ps.setString(SIXTH, demand.getPhoto());
			ps.setString(SEVENTH, demand.getTime());
			ps.setString(EIGTTH, demand.getAddress());

			ps.executeUpdate();
			
			ps = con.prepareStatement(DEMAND_SELECT );
			ps.setString(FIRST, demand.getDescribtion());
			ps.setString(SECOND, demand.getTime());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				int id_contractor = rs.getInt(SECOND);
				int  id_client = rs.getInt(THIRD);
				String status_demand = rs.getString(FOURTH);
				String department = rs.getString(FIFTH);
				String describtion = rs.getString(SIXTH);
				String photo = rs.getString(SEVENTH);
				String time = rs.getString(EIGTTH);
				String address = rs.getString(NINETH );
				demand2 = new Demand(id, id_contractor, id_client, status_demand, department, describtion, photo,time,address );
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
		
		return demand2;
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


	@Override
	public Demand viewDemand(int id) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Demand demand=null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(TAKE_DEMAND_FROM_ID );

			ps.setInt(FIRST, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int idDB = rs.getInt(FIRST);
				int id_contractor = rs.getInt(SECOND);
				int  id_client = rs.getInt(THIRD);
				String status_demand = rs.getString(FOURTH);
				String department = rs.getString(FIFTH);
				String describtion = rs.getString(SIXTH);
				String photo = rs.getString(SEVENTH);
				String time = rs.getString(EIGTTH);
				String address = rs.getString(NINETH );
				demand = new Demand(idDB, id_contractor, id_client, status_demand, department, describtion, photo,time,address );
			
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
		
		return demand;
	}
	


}
