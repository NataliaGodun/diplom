package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Client;
import by.htp.service247.domain.Contractor;
import by.htp.service247.service.ClientService;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class RegClient implements Command {

	private static final String EMAIL= "email";
	private static final String FIRST_NAME= "firstName";
	private static final String LAST_NAME= "lastName";
	private static final String PHONE= "phone";
	private static final String ADDRESS= "address";
	private static final String STATUS= "EXIST";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";		
	private static final String SERVSANT= "servSant";
	private static final String SERVELECTR= "servElectr";
	private static final String SERVVENT= "servVent";
	
	private static final String MESSAGE_ADD_CONTRACTOR = "add client";
	private static final String MESSAGE = "messageInfo";
	private static final String MAIN_CONTRACTOR_JSP = "WEB-INF/jsp/mainContractor.jsp";
	
		
	private static final Logger LOGGER = LogManager.getRootLogger();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=0;
		String email = request.getParameter(EMAIL);
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String phone = request.getParameter(PHONE);
		String address = request.getParameter(ADDRESS);
		String status = STATUS;
		String login = request.getParameter(LOGIN );
		String password = request.getParameter(PASSWORD);
		String servSant = request.getParameter(SERVSANT);
		String servElectr = request.getParameter(SERVELECTR);
		String servVent = request.getParameter(SERVVENT);
		Client client=new Client(id,email, firstName, lastName, phone,address,status,login,password,servSant,servElectr, servVent);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService clientService = factory.getClientService();

		String page;
	
		try {
			client = clientService.registration(client);
			if (client != null) {

				request.setAttribute(MESSAGE, MESSAGE_ADD_CONTRACTOR);
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
		
	