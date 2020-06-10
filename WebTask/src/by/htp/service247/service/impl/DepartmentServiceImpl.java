package by.htp.service247.service.impl;


import by.htp.service247.dao.DepartmentDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Department;
import by.htp.service247.service.DepartmentService;
import by.htp.service247.service.exception.ServiceException;



public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public Department showDepartment(Department department) throws ServiceException {
		Department department2=null;
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		DepartmentDAO departmentDAO = daoObjectFactory.getDepartmentDAO();
		try {
			department2= departmentDAO.showDepartment(department);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department2;
	}
}
