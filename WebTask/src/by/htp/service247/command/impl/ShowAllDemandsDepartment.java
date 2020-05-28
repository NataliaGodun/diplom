package by.htp.service247.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class ShowAllDemandsDepartment implements Command {

	private static final String DEPARTMENT = "department";
	private static final String LIST = "List";
	private static final String ALL_DEMANDS_DEPARTMENT_JSP = "WEB-INF/jsp/allDemandsDepartment.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		HttpSession session = request.getSession(true);
		String department= (String) session.getAttribute(DEPARTMENT);
		System.out.println(department);
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();
		

		try {
			ArrayList<Demand> List = demandService.showDemand(department);
			if (List.size() == 0) {

			//	request.setAttribute(MESSAGE_INFO, MESSAGE_NO_BOOKS);

			} else {
				
				request.setAttribute(DEPARTMENT, department);
				request.setAttribute(LIST, List);

			}
		} catch (ServiceException e) {

			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_VIEW_ALL_BOOKS, e);

			//request.setAttribute(ERROR_MESSAGE, MESSAGE_ABOUT_PROBLEM);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(ALL_DEMANDS_DEPARTMENT_JSP);

		dispatcher.forward(request, response);
}
}