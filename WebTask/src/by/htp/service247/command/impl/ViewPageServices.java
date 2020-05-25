package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class ViewPageServices implements Command {
	private static final String PAGE_SERVICE_JSP = "WEB-INF/jsp/pageServices.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_SERVICE_JSP);

		dispatcher.forward(request, response);
	}

}



