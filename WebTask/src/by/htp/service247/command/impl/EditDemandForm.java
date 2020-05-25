package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.htp.service247.command.Command;


public class EditDemandForm implements Command {
	private static final String EDIT_FORM_DEMAND_JSP =  "WEB-INF/jsp/editDemand.jsp";
	private static final String ID =  "id";
	private static final String DESCRIBTION =  "describtion";
	private static final String DEPARTMENT =  "department";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter(ID );
		String describtion = request.getParameter(DESCRIBTION);
		String department = request.getParameter(DEPARTMENT);
		
		request.setAttribute(ID , id );
		request.setAttribute(DESCRIBTION, describtion );
		request.setAttribute(DEPARTMENT, department );

		RequestDispatcher dispatcher = request.getRequestDispatcher(EDIT_FORM_DEMAND_JSP);
		dispatcher.forward(request, response);
	}

}
