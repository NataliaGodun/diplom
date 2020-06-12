package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class RegClient implements Command {
	private static final String MESSAGE_ADD_CONTRACTOR = "add client";
	private static final String MESSAGE = "messageInfo";
	private static final String MAIN_CONTRACTOR_JSP = "WEB-INF/jsp/mainContractor.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(MESSAGE, MESSAGE_ADD_CONTRACTOR);
		RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CONTRACTOR_JSP);
		dispatcher.forward(request, response);
	}

}
