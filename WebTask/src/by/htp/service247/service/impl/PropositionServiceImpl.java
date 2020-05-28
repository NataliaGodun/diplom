package by.htp.service247.service.impl;

import by.htp.service247.dao.DemandDAO;
import by.htp.service247.dao.PropositionDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Proposition;
import by.htp.service247.service.PropositionService;
import by.htp.service247.service.exception.ServiceException;

public class PropositionServiceImpl implements PropositionService {

	@Override
	public Proposition takeProposition(Proposition proposition) throws ServiceException {
		int price=0;
		int km=proposition.getKm();
		String data=proposition.getData();
		System.out.println(data);
		if (data.equals("s")) {
			int area=proposition.getArea();
			double x=0.1;
			price=(int) (area*x);
			System.out.println("price="+price);
		}else if(data.equals("rr")) {
			int rr=proposition.getReber_radiatorov();
			double y=0.3;
			price=(int) (rr*y);
		}else if(data.equals("dl")) {
			int trub10=proposition.getTrub10();
			int trub25=proposition.getTrub25();
			double k10=0.15;
			double k25=0.2;
			price=(int) (trub10*k10+trub25*k25);}
		
		if (km==0) {}else {
			price=(int) (price*0.5);}
		
		proposition.setPrice(price);
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		PropositionDAO propositionDAO = daoObjectFactory.getPropositionDAO();
		try {
			return propositionDAO.takeProposition(proposition);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	
	}

}
