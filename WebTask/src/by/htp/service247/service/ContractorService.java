package by.htp.service247.service;

import java.util.ArrayList;

import by.htp.service247.domain.Client;
import by.htp.service247.domain.Contractor;
import by.htp.service247.service.exception.ServiceException;


public interface ContractorService {

	

	public Contractor authorization(String login, String password) throws ServiceException;
	
	
	public Contractor registration(Contractor contractor) throws ServiceException;
	
	public ArrayList<Contractor> showContractor() throws ServiceException;
	void deleteContractor(int id) throws ServiceException;
}
