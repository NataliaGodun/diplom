package by.htp.service247.service.factory;



import by.htp.service247.service.ClientService;
import by.htp.service247.service.ContractorService;
import by.htp.service247.service.DemandService;


import by.htp.service247.service.impl.ClientServiceImpl;
import by.htp.service247.service.impl.ContractorServiceImpl;
import by.htp.service247.service.impl.DemandServiceImpl;


/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ServiceFactory {
	private final static ServiceFactory instance = new ServiceFactory();
	
	

	private final ClientService clientService = new ClientServiceImpl();
	

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ClientService getClientService() {
		return clientService;
	}

	
}
	
	
	

