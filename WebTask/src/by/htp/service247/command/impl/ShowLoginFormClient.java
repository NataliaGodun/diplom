package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class ShowLoginFormClient implements Command {
	private static final String LOGIN_FORM_CLIENT_JSP = "WEB-INF/jsp/loginFormClient.jsp";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_FORM_CLIENT_JSP);
		dispatcher.forward(request, response);
	}

}
