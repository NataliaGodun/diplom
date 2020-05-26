package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.service247.command.Command;

public class SelectDepartmentForm implements Command {
	private static final String ADD_DEMAND = "WEB-INF/jsp/addDemand.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(ADD_DEMAND);
		dispatcher.forward(request, response);


	}

}
