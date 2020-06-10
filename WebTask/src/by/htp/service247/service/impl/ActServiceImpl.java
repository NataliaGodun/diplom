package by.htp.service247.service.impl;

import by.htp.service247.dao.ActDAO;
import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Act;
import by.htp.service247.service.ActService;
import by.htp.service247.service.exception.ServiceException;

public class ActServiceImpl implements ActService {

	@Override
	public Act addAct(Act act) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ActDAO actDAO = daoObjectFactory.getActDAO();
		try {
			return actDAO.addAct(act);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

}
