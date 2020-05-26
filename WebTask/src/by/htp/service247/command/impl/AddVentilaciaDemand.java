package by.htp.service247.command.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class AddVentilaciaDemand implements Command {
	private static final String DESCRIBTION = "describtion";
	private static final String DEPARTMENT = "department";
	private static final String ADDRESS= "address";
	private static final String NAME_WRITER = "writer";
	private static final String GENRE = "genre";
	private static final String HOUSE = "house";
	private static final String YEAR = "year";
	private static final String FILE = "file";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String MESSAGE_ABOUT_PROBLEM = "Please, fill a form once again.";
	private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=UTF-8";
	private static final String MESSAGE_SUCCESSFUL_ADDITION = "&message=Book successful addition in library!";
	private static final String URL_VIEW_BOOK = "http://localhost:8080/WebTask/Controller?command=viewBook&id=";
	private static final String ADD_NEW_BOOK_JSP = "WEB-INF/jsp/addNewBook.jsp";
	private static final String PATH_IMAGE = "E:/Natasha/diplomImage/";
	private static final String MESSAGE_ERROR_ADDITION_BOOK = "Error at addition of the book.";
	private static final String MAIN_CLIENT_JSP = "WEB-INF/jsp/mainClient.jsp";
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static final String ID = "id";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE_TEXT_HTML);
		
		HttpSession session = request.getSession(true);
		
		int id_client=(int) session.getAttribute(ID);
		
		Date dateNow = new Date();
	    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd 'в' hh:mm:ss");
	    final String time = formatForDateNow.format(dateNow);
		
		final int contractor = 0;	
		
		final String status = "Новая заявка";
		final String  department=request.getParameter(DEPARTMENT);
		final String describtion = request.getParameter(DESCRIBTION);
		System.out.println("describtion="+describtion);
		final String address = request.getParameter(ADDRESS);
		
		
		final Part filePart = request.getPart(FILE);

		final String fileName = getFileName(filePart);
		String page = null;
		File uploadetFile = null;
		String pathImage;

		pathImage = (PATH_IMAGE + fileName);
		uploadetFile = new File(pathImage);

		//create file
		uploadetFile.createNewFile();

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();

		try {
			out = new FileOutputStream(new File(pathImage));

			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			ServiceFactory factory = ServiceFactory.getInstance();
			DemandService demandService = factory.getDemandService();

			Demand demand = new Demand(0, contractor, id_client, status, department, describtion, pathImage, time,address);
			 System.out.println(demand.getDescribtion());
			demand  = demandService.addDemand(demand);

			//int i = demand.getId();
			//String url = URL_VIEW_BOOK + i;
			//String urlWithMessage = url + MESSAGE_SUCCESSFUL_ADDITION;

			//response.sendRedirect(urlWithMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(MAIN_CLIENT_JSP);

			dispatcher.forward(request, response);

		} catch (ServiceException e) {

			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_ADDITION_BOOK, e);

			//request.setAttribute(ERROR_MESSAGE, MESSAGE_ABOUT_PROBLEM);
			//page = ADD_NEW_BOOK_JSP;

			
			
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "").replace("\\", "")
						.replaceAll(":", "");
			}
		}
		return null;
	}

}
	


