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
	 
		private static final String ADD_ACT = "INSERT INTO ACT (time, comment, id_contractor, describtion, id_demand ) VALUES(?,?,?,?,?)";
		private static final String MESSAGE_ERROR_CONNECTION_POOL = "Error at connection pool.";
		private static final String MESSAGE_ERROR_SQL = "Error at sql.";
		private static final String MESSAGE_ERROR_REMOVE_CONNECTION = "Error at remove connection.";
		private static final int FIRST = 1;
		private static final int SECOND = 2;
		private static final int THIRD = 3;
		private static final int FOURTH = 4;
		private static final int FIFTH = 5;
		
	
	@Override
	public Act addAct(Act act) throws DAOException {
		Connection con = null;
		
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(ADD_ACT);

			ps.setString(FIRST, act.getTime());
			ps.setString(SECOND, act.getComment());
			ps.setInt(THIRD, act.getId_contractor());
			ps.setString(FOURTH, act.getDescribtion());
			ps.setInt(FIFTH, act.getId_demand());
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
		
		return act;
	}
}
