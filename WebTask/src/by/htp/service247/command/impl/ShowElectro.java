package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Department;
import by.htp.service247.service.DepartmentService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class ShowElectro implements Command {
	private static final String DEPARTMENT =  "department";
	private static final String VIEW_DEPARTMENT_JSP = "WEB-INF/jsp/viewDepartment.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String departmentS = "Ёлектроснабжение";
		String departmentS = request.getParameter(DEPARTMENT);
		String department_descr="";
		String services="";
		Department department2=new Department(departmentS,department_descr,services);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		DepartmentService departmentService = factory.getDepartmentService();

		
		try {
			Department department = departmentService.showDepartment(department2);
			request.setAttribute(DEPARTMENT, department );
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_DEPARTMENT_JSP);
		dispatcher.forward(request, response);
	}

}
