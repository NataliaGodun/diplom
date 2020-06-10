package by.htp.service247.service;

import by.htp.service247.domain.Department;
import by.htp.service247.service.exception.ServiceException;


public interface DepartmentService {

	Department showDepartment(Department department)throws  ServiceException;

}
