package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.service247.dao.ActDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Act;
import by.htp.service247.domain.Demand;

public class SQLActDAO implements ActDAO {
	  private static final String SELECT_ALL_DEMAND_CLIENT = "SELECT * FROM DEMAND WHERE ID_CLIENT=?";
		private static final String SELECT_ALL_DEMAND_DEPARTMENT = "SELECT * FROM DEMAND WHERE DEPARTMENT=?";
		private static final String TAKE_DEMAND_FROM_ID = "SELECT * FROM DEMAND WHERE ID=?";
		private static final String ADD_DEMAND = "INSERT INTO DEMAND (id_contractor, id_client, status_demand, department, describtion,photo, time, address ) VALUES(?,?,?,?,?,?,?,?)";
		private static final String DEMAND_SELECT = "SELECT * FROM DEMAND WHERE describtion=? AND time=? ";
		private static final String DEMAND_SELECT_ID = "SELECT * FROM DEMAND WHERE ID=? ";
		private static final String EDIT_DEMAND_CLIENT = "UPDATE DEMAND SET  describtion=?, photo=?, time=?,  address=? WHERE ID=?";
		private static final String EDIT_DEMAND_STATUS = "UPDATE DEMAND SET id_contractor=?, status_demand=? WHERE ID=?";	
		private static final String DELETE_DEMAND_ID = "DELETE FROM DEMAND WHERE ID=?";	
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
	public Act addAct(Act act) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Act act2=null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(ADD_DEMAND);

			ps.setInt(FIRST, act.getId_act());
			ps.setString(SECOND, act.getTime());
		
System.out.println(act.getId_demand());
		//	ps.executeUpdate();
			
		

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
		
		return act;
	}
}
