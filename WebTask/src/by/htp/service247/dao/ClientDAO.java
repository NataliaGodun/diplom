package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Client;


/**
 * @author Godun Natalia
 * @version 1.0
 */

public interface ClientDAO {

	Client authorization (String login, String password) throws DAOException;

	Client registration (Client client) throws DAOException;

}
