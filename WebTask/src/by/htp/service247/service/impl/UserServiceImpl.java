package by.htp.service247.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.UserDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.User;
import by.htp.service247.service.UserService;
import by.htp.service247.service.exception.ServiceException;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public class UserServiceImpl implements UserService {

	private static final String MESSAGE_ERROR_LAYER_DAO = "Error from a layer DAO.";

	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public User authorization(String login, String password) throws ServiceException {

		ValidationUser.validateUser(login, password);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		try {
			return userDAO.authorization(login, password);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public User registration(String name, String login, String password) throws ServiceException {

		ValidationUser.validateUser(login, password);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		try {
			return userDAO.registration(name, login, password);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public User editProfileName(String name, String login) throws ServiceException {

		ValidationUser.validateUser(login);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		try {
			return userDAO.editProfileName(name, login);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public User editProfilePassword(String password, String login) throws ServiceException {

		ValidationUser.validateUser(login, password);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		try {
			return userDAO.editProfilePassword(password, login);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

}
