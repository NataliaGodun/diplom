package by.htp.service247.service;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Department;


public interface DepertmentService {
	Department showDepertment(Department depertment) throws DAOException;

}
