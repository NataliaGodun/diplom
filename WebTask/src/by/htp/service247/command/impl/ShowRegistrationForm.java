package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ShowRegistrationForm implements Command {

	private static final String REGISTRATION_FORM_JSP = "WEB-INF/jsp/reg.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTRATION_FORM_JSP);
		dispatcher.forward(request, response);

	}

}