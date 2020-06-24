package by.htp.service247.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Client;

import by.htp.service247.service.ClientService;

import by.htp.service247.service.exception.ServiceException;
/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ClientServiceImpl implements ClientService {

	@Override
	public Client authorization(String login, String password) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientDAO clientDAO = daoObjectFactory.getClientDAO();
		try {
			return clientDAO.authorization(login, password);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Client registration(Client client) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		ClientDAO clientDAO = daoObjectFactory.getClientDAO();
		try {
			return clientDAO.registration(client);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

}