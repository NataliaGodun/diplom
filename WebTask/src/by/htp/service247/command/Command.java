package by.htp.service247.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * interface Command
 * 
 * @author Godun Natalia
 * @version 1.0
 */
public interface Command {
	/**
	 * executes the command
	 */
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
