package by.htp.service247.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;

/**
 * handles get and post requests with files
 * 
 * @author Godun Natalia
 * @version 1.0
 */

@MultipartConfig
public class ImageController extends HttpServlet {

	private static final long serialVersionUID = 7764697338154809933L;

	private static final String REQUEST_PARAMETR = "command";
	private static final String ADD_NEW_BOOK = "AddNewBook";
	private static final CommandProvider PROVIDER = new CommandProvider();

	public ImageController() {
		super();

	}

	/**
	 * init HttpServlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}

	/**
	 * handles get requests
	 * 
	 * @param request
	 * @param response
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(REQUEST_PARAMETR);
		Command command = PROVIDER.getCommand(commandName);
		command.execute(request, response);
	}

	/**
	 * handles post requests
	 * 
	 * @param request
	 * @param response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Command command = PROVIDER.getCommand(ADD_NEW_BOOK);
		command.execute(request, response);
	}

	/**
	 * destroy HttpServlet
	 */
	public void destroy() {
		super.destroy();

	}

}
