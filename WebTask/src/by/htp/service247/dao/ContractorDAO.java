package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Contractor;

public interface ContractorDAO {
	
	Contractor authorization (String login, String password) throws DAOException;

	Contractor registration (Contractor contractor) throws DAOException;

}
