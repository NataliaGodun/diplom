package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Contractor;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class RegContractor implements Command {

	private static final String LOGIN = "login";
		private static final String PASSWORD = "password";
		private static final String FIRST_NAME= "firstName";
		private static final String LAST_NAME= "lastName";
		private static final String PHONE= "phone";
		private static final String DATE_BIRTH= "dateOfBirth";
		private static final String PASSPORT= "passport";
		private static final String STATUS= "EXIST";
		private static final String ROLE= "simple";
		private static final String DEPARTMENT= "department";
		private static final String MAIN_CONTRACTOR_JSP = "WEB-INF/jsp/mainContractor.jsp";
		
		private static final Logger LOGGER = LogManager.getRootLogger();

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 System.out.println("Reg impl1");
			int id=0;
			String firstName = request.getParameter(FIRST_NAME);
			String lastName = request.getParameter(LAST_NAME);
			String phone = request.getParameter(PHONE);
			String dateOfBirth = request.getParameter(DATE_BIRTH);
			String passport = request.getParameter(PASSPORT);
			String login = request.getParameter(LOGIN );
			String password = request.getParameter(PASSWORD);
			String status = request.getParameter(STATUS);
			String role = request.getParameter(ROLE);
			String department = request.getParameter(DEPARTMENT);
			Contractor contractor=new Contractor(id,firstName, lastName, phone, dateOfBirth,passport,login,password,status,role,department);
			 System.out.println("Reg impl2");

			ServiceFactory factory = ServiceFactory.getInstance();
			ContractorService contractorService = factory.getContractorService();

			String page;
		
			try {
				contractor = contractorService.registration(contractor);
				if (contractor != null) {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CONTRACTOR_JSP);
					dispatcher.forward(request, response);

				} else {
					//response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_INFO);
				}
			} catch (ServiceException e) {

				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_REGISTRATION, e);

				//response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_ERROR);
			}

		}

	}