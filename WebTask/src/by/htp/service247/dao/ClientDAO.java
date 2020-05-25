package by.htp.service247.dao;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Client;
import by.htp.service247.domain.Demand;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public interface ClientDAO {

	/**
	 * check the user from database
	 * 
	 * @param login
	 * @param password
	 */
	Client authorization (String login, String password) throws DAOException;

	Client registration (Client client) throws DAOException;
	ArrayList<Client> showClient() throws DAOException;
	void deleteClient(int id) throws DAOException;
}
