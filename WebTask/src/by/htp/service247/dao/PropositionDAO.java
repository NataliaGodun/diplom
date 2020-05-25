package by.htp.service247.dao;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Proposition;


/**
 * @author Godun Natalia
 * @version 1.0
 */
public interface PropositionDAO {

	
	Proposition takeProposition(Proposition proposition) throws DAOException;
}
