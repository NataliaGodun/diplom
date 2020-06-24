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
	private static final String ID_CONTRACTOR = "id_contractor";
	private static final String URL_VIEW_ALL_DEMAND_DEPARTMENT = " http://localhost:8080/WebTask/Controller?command=ShowAllDemandsDepartment";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		int id_contractor=(int) session.getAttribute(ID_CONTRACTOR);
		String idS = request.getParameter(ID_DEMAND );
		int id = Integer. parseInt(idS);
		
		String status = request.getParameter(STATUS);
	
	
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

			
		try {
			Demand demand  = demandService.editDemand(id,id_contractor,status);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = URL_VIEW_ALL_DEMAND_DEPARTMENT;
		
		response.sendRedirect(url);	
	
	}

}

