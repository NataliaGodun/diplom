package by.htp.service247.command.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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



public class EditStatus implements Command {
	private static final String ID_DEMAND =  "id";
	private static final String STATUS =  "status_demand";
	private static final String ALL_DEMANDS_DEPARTMENT_JSP = "WEB-INF/jsp/allDemandsDepartment.jsp";
	private static final String ID_CONTRACTOR = "id_contractor";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		int id_contractor=(int) session.getAttribute(ID_CONTRACTOR);
		String idS = request.getParameter(ID_DEMAND );
		int id = Integer. parseInt(idS);
		
		String status = request.getParameter(STATUS);
		System.out.println("status "+status);
	
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

			
		try {
			Demand demand  = demandService.editDemand(id,id_contractor,status);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(ALL_DEMANDS_DEPARTMENT_JSP);
		dispatcher.forward(request, response);
	}

}

