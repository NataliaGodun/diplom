package by.htp.service247.dao.factory;

import by.htp.service247.dao.ActDAO;
import by.htp.service247.dao.ClientDAO;
import by.htp.service247.dao.ContractorDAO;
import by.htp.service247.dao.DemandDAO;
import by.htp.service247.dao.DepartmentDAO;
import by.htp.service247.dao.PropositionDAO;
import by.htp.service247.dao.impl.SQLActDAO;
import by.htp.service247.dao.impl.SQLClientDAO;
import by.htp.service247.dao.impl.SQLContractorDAO;
import by.htp.service247.dao.impl.SQLDemandDAO;
import by.htp.service247.dao.impl.SQLDepartmentDAO;
import by.htp.service247.dao.impl.SQLPropositionDAO;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	
	private final DemandDAO sqlDemandImpl = new SQLDemandDAO();
	private final ClientDAO sqlClientImpl = new SQLClientDAO();
	private final ContractorDAO sqlContractorImpl = new SQLContractorDAO();
	private final PropositionDAO sqlPropositionImpl = new SQLPropositionDAO();
	private final ActDAO sqlActImpl = new SQLActDAO();
	private final DepartmentDAO sqlDepartmentImpl = new SQLDepartmentDAO();

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

	public PropositionDAO getPropositionDAO() {
		return sqlPropositionImpl;
	}
	public ActDAO getActDAO() {
		return sqlActImpl;
	}
	public DepartmentDAO getDepartmentDAO() {
		return sqlDepartmentImpl;
	}

}
