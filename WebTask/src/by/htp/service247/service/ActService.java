package by.htp.service247.service;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Act;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.exception.ServiceException;

public interface ActService {
	
	Act addAct(Act act) throws ServiceException;
	
}
