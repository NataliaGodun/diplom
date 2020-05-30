package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class ShowRegFormContractor implements Command {
	private static final String REG_CONTRACTOR_JSP = "WEB-INF/jsp/regContractor.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(REG_CONTRACTOR_JSP);
		dispatcher.forward(request, response);


	}

}
