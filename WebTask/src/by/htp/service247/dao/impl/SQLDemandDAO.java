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
import by.htp.service247.domain.Book;
import by.htp.service247.domain.Demand;

public class SQLDemandDAO implements DemandDAO {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static final String ADD_DEMAND = "INSERT INTO DEMAND (id_contractor,id_client,status_demand,department,describtion,photo,time) VALUES(?,?,?,?,?,?,?)";
	private static final String DEMAND_SELECT = "SELECT * FROM DEMAND WHERE id_client=?";
	private static final String SELECT_ALL_DEMAND = "select *from demand";
	private static final String DELETE_DEMAND_ID = "delete from demand where id=?";
	//private static final String SELECT_DEMAND_ID = "select from demand where id=?";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;
	private static final int FOURTH = 4;
	private static final int FIFTH = 5;
	private static final int SIXTH = 6;
	private static final int SEVENTH = 7;
	private static final int EIGTH = 8;

	
	
	@Override
	public ArrayList<Demand> showDemand() throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Demand demand = null;

		ArrayList<Demand> List = new ArrayList<Demand>();

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		
		try {
			
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_DEMAND);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				int id_contractor = rs.getInt(SECOND);
				int id_client = rs.getInt(THIRD);
				String status_demand = rs.getString(FOURTH);
				String department = rs.getString(FIFTH);				
				String describtion = rs.getString(SIXTH);
				String photo = rs.getString(SEVENTH);
				String time = rs.getString(EIGTH);			
				demand = new Demand(id, id_contractor, id_client, status_demand, department, describtion, photo, time);
				List.add(demand );
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
		System.out.println("1");
			Connection con = null;
			ResultSet rs = null;

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
				ps.executeUpdate();

				System.out.println("1");
				

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

	@Override
	public void deleteDemand(int id) throws DAOException {
		Connection con = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(DELETE_DEMAND_ID);
			ps.setInt(FIRST, id);

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
				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
	

		
	}

}
