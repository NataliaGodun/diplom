package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;

public class ShowAddDemandForm implements Command {
	private static final String SELECT_DEPARTMENT_JSP = "WEB-INF/jsp/selectDepartment.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = request.getRequestDispatcher( SELECT_DEPARTMENT_JSP);
		dispatcher.forward(request, response);


	}

}
