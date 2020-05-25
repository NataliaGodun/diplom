package by.htp.service247.dao.factory;

import by.htp.service247.dao.ActDAO;
import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.DemandDAO;
import by.htp.service247.dao.DepartmentDAO;
import by.htp.service247.dao.PropositionDAO;
import by.htp.service247.dao.impl.SQLPropositionDAO;
import by.htp.service247.dao.impl.SQLClientDAO;
import by.htp.service247.dao.impl.SQLContractorDAO;
import by.htp.service247.dao.impl.SQLDemandDAO;
import by.htp.service247.dao.impl.SQLDepartmentDAO;
import by.htp.service247.dao.impl.SQLActDAO;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	
	private final DemandDAO sqlDemandImpl = new SQLDemandDAO();
	private final ClientDAO sqlClientImpl = new SQLClientDAO();
	private final ActDAO sqlActImpl = new SQLActDAO();
	private final ContractorDAO sqlContractorImpl = new SQLContractorDAO();
	private final PropositionDAO sqlPropositionImpl = new SQLPropositionDAO();
	private final DepartmentDAO sqlDepartmentImpl = new SQLDepartmentDAO();


	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public DepartmentDAO getDepartmentDAO() {
		return sqlDepartmentImpl;
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

	public ActDAO getActDAO() {
		return sqlActImpl;
	}

	public PropositionDAO getPropositionDAO() {
		return sqlPropositionImpl;
	}

}
