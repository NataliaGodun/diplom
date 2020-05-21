package by.htp.service247.service;

import by.htp.service247.domain.Contractor;
import by.htp.service247.service.exception.ServiceException;


public interface ContractorService {

	Contractor authorization(String login, String password) throws ServiceException;

}
