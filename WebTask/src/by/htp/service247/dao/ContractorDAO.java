package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;

import by.htp.service247.domain.Contractor;

public interface ContractorDAO {
	/**
	 * check the user from database
	 * 
	 * @param login
	 * @param password
	 */
	Contractor authorization(String login, String password) throws DAOException;

	

}
