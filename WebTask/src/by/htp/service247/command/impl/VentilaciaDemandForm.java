package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;

public class VentilaciaDemandForm implements Command {
	private static final String ADD_VENTILACIA_DEMAND_JSP = "WEB-INF/jsp/addVentilacieDemand.jsp";
	private static final String DEPARTMENT =  "department";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String department = request.getParameter("department");
	
		request.setAttribute(DEPARTMENT, department );
		RequestDispatcher dispatcher = request.getRequestDispatcher(ADD_VENTILACIA_DEMAND_JSP);
		dispatcher.forward(request, response);
	}

}
