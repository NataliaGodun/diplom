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

public class EditDemand implements Command {

	private static final String EDIT_FORM_DEMAND_JSP =  "WEB-INF/jsp/editDemand.jsp";
	private static final String ID =  "id";
	private static final String DESCRIBTION =  "describtion";
	private static final String DEPARTMENT =  "department";
	private static final String MAIN_CLIENT_JSP = "WEB-INF/jsp/mainClient.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idS = request.getParameter(ID );
		int id = Integer. parseInt(idS);
		String describtion = request.getParameter(DESCRIBTION);
		String department = request.getParameter(DEPARTMENT);
		final int contractor = 0;	
		final int id_client = 1;
		final String status = "Новая заявка";
		final String photo = "";
		Date dateNow = new Date();
	    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd 'в' hh:mm:ss");
	    final String time = formatForDateNow.format(dateNow);

		
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

		Demand demand = new Demand(id, contractor, id_client, status, department, describtion, photo, time);

		try {
			demand  = demandService.editDemand(demand);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CLIENT_JSP);
		dispatcher.forward(request, response);
	}

}
