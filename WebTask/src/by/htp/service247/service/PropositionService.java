package by.htp.service247.service;

import by.htp.service247.domain.Proposition;
import by.htp.service247.service.exception.ServiceException;

public interface PropositionService {

	Proposition takeProposition(Proposition proposition) throws ServiceException;

}
