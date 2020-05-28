package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.service247.dao.PropositionDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Demand;
import by.htp.service247.domain.Proposition;

public class SQLPropositionDAO implements PropositionDAO {
	
	private static final String TAKE_PROPOSITION = "INSERT INTO PROPOSITION (email_user, address, phone_user, name_user, city,km, data, area,trub10,trub25,reber_radiatorov,department,price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
	private static final int TWELFTH = 12;
	private static final int thirteen = 13;
	
	@Override
	public Proposition takeProposition(Proposition proposition) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Demand demand2=null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(TAKE_PROPOSITION );

			ps.setString(FIRST, proposition.getEmail_user());
			ps.setString(SECOND, proposition.getAddress());
			ps.setString(THIRD,proposition.getPhone_user());
			ps.setString(FOURTH, proposition.getName_user());
			ps.setString(FIFTH, proposition.getCity());
			ps.setInt(SIXTH, proposition.getKm());
			ps.setString(SEVENTH, proposition.getData());
			ps.setInt(EIGTTH, proposition.getArea());
			ps.setInt(NINETH, proposition.getTrub10());
			ps.setInt(TENTH , proposition.getTrub25());
			ps.setInt(ELEVENTH, proposition.getReber_radiatorov());
			ps.setString(TWELFTH, proposition.getDepartment());
			ps.setInt(thirteen, proposition.getPrice());

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
		
		return proposition;
	}}