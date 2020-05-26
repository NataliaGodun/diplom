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

public class ShowAllDemands implements Command {
	private static final String ID_CLIENTA = "id";
	private static final String LIST = "List";
	private static final String MESSAGE_NO_BOOKS = " There are no available books";
	private static final String MESSAGE_ABOUT_PROBLEM = "Sorry,technical problem";
	private static final String TAKE_ALL_DEMANDS_JSP = "WEB-INF/jsp/takeAllDemands.jsp";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String MESSAGE_INFO = "messageInfo";
	private static final String MESSAGE = "message";
	private static final String MESSAGE_ERROR_VIEW_ALL_BOOKS = "Error at ViewAllBooks";

	//private static final Logger LOGGER = LogManager.getRootLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession(true);
		
			int id_client=(int) session.getAttribute(ID_CLIENTA);
		
		
			ServiceFactory factory = ServiceFactory.getInstance();
			DemandService demandService = factory.getDemandService();
			

			try {
				ArrayList<Demand> List = demandService.showDemand(id_client);
				if (List.size() == 0) {

					request.setAttribute(MESSAGE_INFO, MESSAGE_NO_BOOKS);

				} else {
					String messageInfo = request.getParameter(MESSAGE_INFO);// Book
																			// successful
																			// delete
																			// or no
																			// such
																			// book
					request.setAttribute(MESSAGE_INFO, messageInfo);

					String messageWrongAuthorization = request.getParameter(MESSAGE);
					request.setAttribute(MESSAGE, messageWrongAuthorization);

					String messageErrorAuthorization = request.getParameter(ERROR_MESSAGE);
					request.setAttribute(ERROR_MESSAGE, messageErrorAuthorization);

					request.setAttribute(LIST, List);

				}
			} catch (ServiceException e) {

				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_VIEW_ALL_BOOKS, e);

				request.setAttribute(ERROR_MESSAGE, MESSAGE_ABOUT_PROBLEM);

			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(TAKE_ALL_DEMANDS_JSP);

			dispatcher.forward(request, response);
	}
}
