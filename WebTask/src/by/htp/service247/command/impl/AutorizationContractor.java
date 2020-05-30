package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;

import by.htp.service247.domain.Contractor;

import by.htp.service247.service.ContractorService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class AutorizationContractor implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String CONTRACTOR = "contractor";
	private static final String MAIN_JSP = "WEB-INF/jsp/main.jsp";
	private static final String MAIN_CONTRACTOR_JSP = "WEB-INF/jsp/mainContractor.jsp";
	private static final String ROLE = "role";
	private static final String NAME_CONTRACTOR = "firstName";
	private static final String URL_VIEW_ALL_DEMAND_DEPARTMENT = " http://localhost:8080/WebTask/Controller?command=ShowAllDemandsDepartment";
	private static final String DEPARTMENT = "department";
	private static final String ID_CONTRACTOR = "id_contractor";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			Contractor contractor = null;
			String login = request.getParameter(LOGIN);
			String password = request.getParameter(PASSWORD);

			ServiceFactory factory = ServiceFactory.getInstance();
			ContractorService contractorService = factory.getContractorService();
			  

			try {
				contractor = contractorService.authorization(login, password);
				
				if (contractor != null) {
					String role = contractor.getRole();
					String firstName = contractor.getFirstName();
					String department = contractor.getDepartment();
					int id_contractor = contractor.getId();
					
					HttpSession session = request.getSession(true);
					session.setAttribute(NAME_CONTRACTOR, firstName);
					session.setAttribute(ID_CONTRACTOR, id_contractor);
					session.setAttribute(DEPARTMENT, department);
					
					request.setAttribute(CONTRACTOR, contractor);
					if (role.equals("admin")) {
						RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CONTRACTOR_JSP);
						dispatcher.forward(request, response);
				
					}else {
						
						
						response.sendRedirect(URL_VIEW_ALL_DEMAND_DEPARTMENT);
						//RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CONTRACTOR_JSP);
						//dispatcher.forward(request, response);

					}

				} else {
					System.out.println("7");
				//	response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_INFO);
				}
			} catch (ServiceException e) {

				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_AUTHORIZATION, e);

				//response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_ERROR);

			}

		}

	}

