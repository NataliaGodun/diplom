package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Client;
import by.htp.service247.service.ClientService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;


public class AutorizationClient implements Command {
	private static final String LOGIN = "login";
	private static final String ID = "id";
	private static final String PASSWORD = "password";
	private static final String CLIENT= "client";
	private static final String MAIN_CLIENT_JSP = "WEB-INF/jsp/mainClient.jsp";
	private static final String MESSAGE_WRONG_INFO = "wrong login or password";
	private static final String ERROR_MESSAGE= "errorMessage";
	private static final String LOGIN_FORM_CLIENT_JSP = "WEB-INF/jsp/loginFormClient.jsp";
	private static final String NAME_CLIENT = "firstName";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		Client client = null;
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
        
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService clientService = factory.getClientService();
		
		try {
			client = clientService.authorization(login, password);
			if (client != null) {
				
				String firstName = client.getFirstName();
				int id = client.getId();
				HttpSession session = request.getSession(true);

				session.setAttribute(NAME_CLIENT, firstName);
				session.setAttribute(ID, id);
			
				request.setAttribute(CLIENT, client);

				RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CLIENT_JSP);

				dispatcher.forward(request, response);

			} else {
				request.setAttribute( ERROR_MESSAGE, MESSAGE_WRONG_INFO);
				RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_FORM_CLIENT_JSP);
				dispatcher.forward(request, response);
			
			}
		} catch (ServiceException e) {
			
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_AUTHORIZATION, e);

			//response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_ERROR);

		}

	}

}
