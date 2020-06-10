package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.htp.service247.dao.DepartmentDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Department;

public class SQLDepartmentDAO implements DepartmentDAO {
	private static final String VIEW_DEPARTMENT = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME=? ";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;

	@Override
	public Department showDepartment(Department department) throws DAOException  {
		Connection con = null;
		ResultSet rs = null;
		Department department2=null;
		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		 
		try {
			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(VIEW_DEPARTMENT );
			System.out.println("1"+department.getDepartment());
			ps.setString(FIRST, department.getDepartment());
	
			rs = ps.executeQuery();
			while (rs.next()) {
				String departmentDB = rs.getString(FIRST);
				String department_descr = rs.getString(SECOND);
				String services = rs.getString(THIRD);
				
				department2 = new Department(departmentDB, department_descr, services );
			System.out.println("2"+department2.getDepartment());
			System.out.println("3"+department2.getDepartment_descr());
			System.out.println("4"+department2.getServices());
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
		
		return department2;
	}
}
