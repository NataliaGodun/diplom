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
	private static final String USER = "user";
	private static final String MAIN_JSP = "WEB-INF/jsp/main.jsp";
	private static final String ROLE = "role";
	private static final String NAME_USERS = "name";
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
					HttpSession session = request.getSession(true);

					session.setAttribute(NAME_USERS, firstName);
					session.setAttribute(ROLE, role);
					session.setAttribute(LOGIN, login);
					request.setAttribute(USER, contractor);

					RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_JSP);

					dispatcher.forward(request, response);

				} else {

				//	response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_INFO);
				}
			} catch (ServiceException e) {

				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_AUTHORIZATION, e);

				//response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_ERROR);

			}

		}

	}

