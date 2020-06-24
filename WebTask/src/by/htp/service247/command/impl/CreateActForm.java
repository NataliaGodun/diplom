package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

public class CreateActForm implements Command {
	private static final String ACT_FORM_JSP = "WEB-INF/jsp/actForm.jsp";
	private static final String ID_DEMAND =  "id";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter(ID_DEMAND);
		
		//int id = Integer. parseInt(idS);
		
		request.setAttribute("demand_id", idS);
		RequestDispatcher dispatcher = request.getRequestDispatcher(ACT_FORM_JSP);
		dispatcher.forward(request, response);

	}

}
