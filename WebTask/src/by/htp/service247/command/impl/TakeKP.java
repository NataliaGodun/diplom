package by.htp.service247.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.service247.command.Command;
import by.htp.service247.domain.Proposition;
import by.htp.service247.service.ClientService;
import by.htp.service247.service.PropositionService;
import by.htp.service247.service.exception.ServiceException;
import by.htp.service247.service.factory.ServiceFactory;

public class TakeKP implements Command {
	private static final String PAGE_SERVICES_JSP = "WEB-INF/jsp/pageServices.jsp";
	private static final String SEND_KP = "sendKP";
	private static final String GET_KP = "Коммерческое предложение составлено и отправлено Вам на email.";
	private static final String EMAIL = "email";
	private static final String ADDRESS = "address";
	private static final String PHONE = "phone";
	private static final String NAME= "name_user";
	private static final String CITY= "city";
	private static final String KM= "km";
	private static final String DATA= "data";
	private static final String AREA= "area";
	private static final String TRUB10= "trub10";
	private static final String TRUB25= "trub25";
	private static final String RR= "reber_radiatorov";	
	private static com.devcolibri.ssl.Sender sslSender = new com.devcolibri.ssl.Sender("s-247@mail.ru", "ER567ghm");
	private static final String URL_COMMERCIAL = "http://localhost:8080/WebTask/Controller?command=SHOWCOMMERCIALPAGE";
	private static final String MESSAGE ="&Message=data required!";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int km;
		int area;
		int trub10;
		int trub25;
		int rr;
		int price=0;
		String department="Сантехника";
		
		String email = request.getParameter(EMAIL);
		String address = request.getParameter(ADDRESS);
		String phone = request.getParameter(PHONE);
		String name_user = request.getParameter(NAME);
		String city = request.getParameter(CITY);
		String kmS = request.getParameter(KM);
		String data = request.getParameter(DATA);
		String areaS = request.getParameter(AREA);
		String trub10S = request.getParameter(TRUB10);
		String trub25S = request.getParameter(TRUB25);
		String rrS = request.getParameter(RR);
		if (kmS=="") { km=0;}else {
			km=Integer.parseInt(kmS);
			 }
		if (areaS=="") { area=0;}else {
			area=Integer.parseInt(areaS);
			 }
		if (trub10S=="") { trub10=0;}else {
			trub10=Integer.parseInt(trub10S);
			 }
		if (trub25S=="") { trub25=0;}else {
			trub25=Integer.parseInt(trub25S);
			 }
		if (rrS=="") { rr=0;}else {
			rr=Integer.parseInt(rrS);
			 }
		
		if (data==null) {
			String url = URL_COMMERCIAL;
			String url2 = url + MESSAGE ;
			response.sendRedirect(url2);
			
		}else {
		ServiceFactory factory = ServiceFactory.getInstance();
		PropositionService propositionService = factory.getPropositionService();
		Proposition proposition= new Proposition(0,email,address,phone,name_user,city,km,data,area,trub10,trub25,rr,department,price);

		try {
			 proposition = propositionService.takeProposition(proposition);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toEmail=proposition.getEmail_user();
		String text="Компания \"Service247\" готова оказать услуги по опрессовке системы отопления Вашего объекта. Стоимость проведения работ согласно технического задания, предоставленного заказчиком, составляет "+proposition.getPrice()+ " бел.рублей. Для заключения договора свяжитесь с нашим специалистом по номеру +375(29)336-25-26. Рабочее время офиса: пн-пт, 8:30-17:30";
		sslSender.send("Коммерческое предложение", text, "s-247@mail.ru", toEmail);
		    
		request.setAttribute(SEND_KP, GET_KP );
		RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_SERVICES_JSP);
		dispatcher.forward(request, response);
	}
	}
}
