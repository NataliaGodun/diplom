package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.User;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public interface UserDAO {

	/**
	 * check the user from database
	 * 
	 * @param login
	 * @param password
	 */
	User authorization(String login, String password) throws DAOException;

	/**
	 * add the user to database
	 * 
	 * @param name
	 * @param login
	 * @param password
	 */
	User registration(String name, String login, String password) throws DAOException;

	/**
	 * edit a name of the user in a profile
	 * 
	 * @param name
	 * @param login
	 */
	User editProfileName(String name, String login) throws DAOException;

	/**
	 * edit a password of the user in a profile
	 * 
	 * @param password
	 * @param login
	 */
	User editProfilePassword(String password, String login) throws DAOException;
}
