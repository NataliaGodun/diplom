package by.htp.service247.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Client;
import by.htp.service247.domain.Contractor;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.exception.ServiceException;

public class ContractorServiceImpl implements ContractorService {

	@Override
	public Contractor authorization(String login, String password) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contractor registration(Contractor contractor) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contractor> showContractor() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContractor(int id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	
}
