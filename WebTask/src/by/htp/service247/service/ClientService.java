package by.htp.service247.service;

import by.htp.service247.domain.Client;
import by.htp.service247.domain.User;
import by.htp.service247.service.exception.ServiceException;
/**
 * Ñhecks the parameters and passes control to the dao layer
 * 
 * @author Godun Natalia
 * @version 1.0
 */
public interface ClientService {
	Client authorization(String login, String password) throws ServiceException;

}

	