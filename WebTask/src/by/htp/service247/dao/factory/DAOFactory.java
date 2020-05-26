package by.htp.service247.dao.factory;

import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.DemandDAO;

import by.htp.service247.dao.impl.SQLClientDAO;
import by.htp.service247.dao.impl.SQLContractorDAO;
import by.htp.service247.dao.impl.SQLDemandDAO;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	
	private final DemandDAO sqlDemandImpl = new SQLDemandDAO();
	private final ClientDAO sqlClientImpl = new SQLClientDAO();
	private final ContractorDAO sqlContractorImpl = new SQLContractorDAO();


	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	
	public DemandDAO getDemandDAO() {
		return sqlDemandImpl;
	}
	public ClientDAO getClientDAO() {
		return sqlClientImpl;
	}
	public ContractorDAO getContractorDAO() {
		return sqlContractorImpl;
	}

	

}
