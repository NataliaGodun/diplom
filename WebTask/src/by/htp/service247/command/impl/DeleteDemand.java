package by.htp.service247.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class DeleteDemand implements Command {
	private static final String ID = "id";
	private static final String STATUS_DEMAND = "status";
	private static final String MESSAGE_FAIL_DELETE = "Заявка не удалена!";
	private static final String MESSAGE_SUCCESSFUL_DELETE ="&messageInfo=demand successful delete!";
	private static final String URL_VIEW_ALL_DEMAND = "http://localhost:8080/WebTask/Controller?command=SHOWALLDEMANS";
	private static final String VIEW_JSP = "WEB-INF/jsp/viewDemand.jsp";
	private static final String MESSAGE_ERROR_REMOVE_BOOK = "Error of removal of the book";
	private static final String MAIN_CLIENT_JSP = "WEB-INF/jsp/mainClient.jsp";
	private static final String LIST = "List";
	private static final String TAKE_ALL_DEMANDS_JSP = "WEB-INF/jsp/takeAllDemands.jsp";
	private static final String MESSAGE_WRONG_DELETE = "messageWrongDelete";
	private static final String MESSAGE_WRONG_DELATE_DATE = "Вы можете удалить только заявку со статусом \"Новая заявка\" ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String idBook = request.getParameter(ID);
		int id = Integer.parseInt(idBook);
		
		
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

		String page=null;
			try {
				demandService.deleteDemand(id);
			
				String url = URL_VIEW_ALL_DEMAND;
				String url2 = url + MESSAGE_SUCCESSFUL_DELETE;
				response.sendRedirect(url2);
			
			} catch (ServiceException e) {
				
				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_BOOK, e);

				request.setAttribute(MESSAGE_WRONG_DELETE, MESSAGE_FAIL_DELETE);
				page = VIEW_JSP;
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}
			
		}

}