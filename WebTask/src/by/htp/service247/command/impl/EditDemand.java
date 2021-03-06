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

	private static final String ID_DEMAND =  "id";
	private static final String DESCRIBTION =  "describtion";
	private static final String DEPARTMENT =  "department";
	private static final String ADDRESS =  "address";
	private static final String MAIN_CLIENT_JSP = "WEB-INF/jsp/mainClient.jsp";
	private static final String ID_CLIENTA = "id_client";
	private static final String PHOTO = "photo";
	private static final String MESSAGE_SUCCESSFUL_EDIT ="&message=demand successful edit!";
	private static final String URL_VIEW_ALL_DEMAND = "http://localhost:8080/WebTask/Controller?command=SHOWALLDEMANS";
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Date dateNow = new Date();
	    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy '�' hh:mm:ss");
	    final String time = formatForDateNow.format(dateNow);
		
		final int id_contractor = 0;
		
		
		String idS = request.getParameter(ID_DEMAND );
		int id = Integer. parseInt(idS);
		
		String describtion = request.getParameter(DESCRIBTION);
		
		String department = request.getParameter(DEPARTMENT);
		
		String address = request.getParameter(ADDRESS);
		
		String idClientaS = request.getParameter(ID_CLIENTA);
		int id_client = Integer. parseInt(idClientaS);
		
		String photo = request.getParameter(PHOTO);
		
		final String status = "����� ������";
		ServiceFactory factory = ServiceFactory.getInstance();
		DemandService demandService = factory.getDemandService();

		Demand demand = new Demand(id, id_contractor, id_client, status, department, describtion, photo, time,address);
		
		try {
			demand  = demandService.editDemand(demand);
			
			String url = URL_VIEW_ALL_DEMAND;
			String url2 = url + MESSAGE_SUCCESSFUL_EDIT;
			response.sendRedirect(url2);	
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CLIENT_JSP);
			dispatcher.forward(request, response);
		}

	
	}

}
