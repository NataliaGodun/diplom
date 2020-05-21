package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class ShowCommercialPage implements Command {
	private static final String COMMERCIAL_JSP = "WEB-INF/jsp/commercial.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(COMMERCIAL_JSP);

		dispatcher.forward(request, response);
	}

}
