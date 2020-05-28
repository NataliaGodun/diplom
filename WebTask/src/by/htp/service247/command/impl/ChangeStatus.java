package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class ChangeStatus implements Command {
	private static final String ID_DEMAND =  "id";
	private static final String DEMAND =  "demand";
	private static final String CHANGE_STATUS_JSP = "WEB-INF/jsp/changeStatus.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idS = request.getParameter(ID_DEMAND);
		
		int id = Integer. parseInt(idS);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

			Demand demand;
			try {
				demand = demandService.viewDemand(id);
				request.setAttribute(DEMAND, demand );
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		RequestDispatcher dispatcher = request.getRequestDispatcher(CHANGE_STATUS_JSP);
		dispatcher.forward(request, response);
	
	}
}