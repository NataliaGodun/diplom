package by.htp.service247.service.factory;

import by.htp.service247.service.BookService;
import by.htp.service247.service.ClientService;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.DemandService;
import by.htp.service247.service.UserService;

import by.htp.service247.service.impl.ClientServiceImpl;
import by.htp.service247.service.impl.ContractorServiceImpl;
import by.htp.service247.service.impl.DemandServiceImpl;
import by.htp.service247.service.impl.UserServiceImpl;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ServiceFactory {
	private final static ServiceFactory instance = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final DemandService demandService = new DemandServiceImpl();
	private final ClientService clientService = new ClientServiceImpl();
	private final ContractorService contractorService = new ContractorServiceImpl();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
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
}
