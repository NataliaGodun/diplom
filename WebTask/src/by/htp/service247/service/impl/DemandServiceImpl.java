package by.htp.service247.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import by.htp.service247.dao.ActDAO;
import by.htp.service247.dao.DemandDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Demand;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.exception.ServiceException;

public class DemandServiceImpl implements DemandService {

	@Override
	public ArrayList<Demand> showDemand(int id) throws ServiceException {
		

			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			DemandDAO demandDAO = daoObjectFactory.getDemandDAO();
			ArrayList<Demand> List = null;
			
			try {
				List = demandDAO.showDemand(id);
			} catch (DAOException e) {
				//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
				throw new ServiceException(e);
			}
			return List;

		}

	@Override
	public Demand addDemand(Demand demand) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		DemandDAO demandDAO = daoObjectFactory.getDemandDAO();
		try {
			return demandDAO.addDemand(demand);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteDemand(int id) throws ServiceException {
		//ValidationBook.validateBook(id);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		DemandDAO demandDAO = daoObjectFactory.getDemandDAO();
		try {
			demandDAO.deleteDemand(id);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Demand editDemand(Demand demand) throws ServiceException {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		DemandDAO demandDAO = daoObjectFactory.getDemandDAO();
		try {
			return demandDAO.editDemand(demand);
		} catch (DAOException e) {
			//LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public ArrayList<Demand> showDemand(String department) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
