package by.htp.service247.command.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class ViewDemand implements Command {
	private static final String ID_DEMAND =  "id";
	private static final String DEMAND =  "demand";
	private static final String MESSAGE_NEW_DEMAND =  "messageNewDemand";
	private static final String VIEW_DEMAND_JSP = "WEB-INF/jsp/viewDemand.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter(ID_DEMAND );
		int id = Integer. parseInt(idS);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

		
		try {
			Demand demand  = demandService.viewDemand(id);
			request.setAttribute(DEMAND, demand );
			String status=demand.getStatus_demand();
			if (status.equals("Новая заявка")) {
				request.setAttribute(MESSAGE_NEW_DEMAND, status);
			}
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_DEMAND_JSP);
		dispatcher.forward(request, response);
	}

}
