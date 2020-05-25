package by.htp.service247.service.factory;

import by.htp.service247.service.ActService;

import by.htp.service247.service.ClientService;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.DepertmentService;
import by.htp.service247.service.PropositionService;

import by.htp.service247.service.impl.ActServiceImpl;
import by.htp.service247.service.impl.ClientServiceImpl;
import by.htp.service247.service.impl.ContractorServiceImpl;
import by.htp.service247.service.impl.DemandServiceImpl;
import by.htp.service247.service.impl.DepertmentServiceImpl;
import by.htp.service247.service.impl.PropositionServiceImpl;


/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ServiceFactory {
	private final static ServiceFactory instance = new ServiceFactory();

	private final DepertmentService depertmentService = new DepertmentServiceImpl();
	private final DemandService demandService = new DemandServiceImpl();
	private final ClientService clientService = new ClientServiceImpl();
	private final ContractorService contractorService = new ContractorServiceImpl();
	private final ActService actService = new ActServiceImpl();
	private final PropositionService propositionService = new PropositionServiceImpl();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public DepertmentService getDepertmentService() {
		return depertmentService;
	}

	public DemandService getDemandService() {
		return demandService;
	}

	public ClientService getClientService() {
		return clientService;
	}
	public ContractorService getContractorService() {
		return contractorService;
	}
	public ActService getActService() {
		return actService;
	}
	public PropositionService getPropositionService() {
		return propositionService;
	}
}
