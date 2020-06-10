package by.htp.service247.command.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Act;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.ActService;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class CreateAct implements Command {
	
	private static final String DEMAND_ID =  "id";
	private static final String CHANGE_STATUS_JSP = "WEB-INF/jsp/pageServices.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int id_act=0;
		 Date dateNow = new Date();	  
		 SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy '�' hh:mm:ss");
		 final String time = formatForDateNow.format(dateNow);
		 String comment="";
		 int id_contractor=0;
		 String describtion="";
		
		 String idS = request.getParameter(DEMAND_ID);
		int demand_id = Integer. parseInt(idS);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		ActService actService = factory.getActService();

			Act act=new Act(0,time,comment,id_contractor,describtion,demand_id);
			
			try {
				act = actService.addAct(act);
				//request.setAttribute(DEMAND, demand );
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		RequestDispatcher dispatcher = request.getRequestDispatcher(CHANGE_STATUS_JSP);
		dispatcher.forward(request, response);
		
		
	}
	}