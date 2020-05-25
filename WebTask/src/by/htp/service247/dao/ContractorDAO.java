package by.htp.service247.dao;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;

import by.htp.service247.domain.Contractor;
import by.htp.service247.domain.Demand;

public interface ContractorDAO {
	/**
	 * check the user from database
	 * 
	 * @param login
	 * @param password
	 */
	
	Contractor authorization (String login, String password) throws DAOException;

	Contractor registration (Contractor contractor) throws DAOException;
	ArrayList<Contractor> showContractor() throws DAOException;

	void deleteContractor(int id) throws DAOException;

	

}
