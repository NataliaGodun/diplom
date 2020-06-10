package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Department;

public interface DepartmentDAO {
	
	Department showDepartment (Department department)throws DAOException;

}
