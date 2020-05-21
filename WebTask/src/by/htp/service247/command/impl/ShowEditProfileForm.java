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
public class ShowEditProfileForm implements Command {
	
	private static final String EDIT_PROFILE_JSP = "WEB-INF/jsp/EditProfile.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(EDIT_PROFILE_JSP);

		dispatcher.forward(request, response);
	}

}
