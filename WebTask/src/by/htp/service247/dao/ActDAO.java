package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Act;


/**
 * @author Godun Natalia
 * @version 1.0
 */

public interface ActDAO {
	
	 
	Act addAct(Act act) throws DAOException;

	
}