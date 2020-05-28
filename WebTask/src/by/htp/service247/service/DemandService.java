package by.htp.service247.service;

import java.util.ArrayList;


import by.htp.service247.domain.Demand;
import by.htp.service247.service.exception.ServiceException;

public interface DemandService {
	ArrayList<Demand> showDemand(int id) throws ServiceException;
	ArrayList<Demand> showDemand(String department) throws ServiceException;

	Demand addDemand(Demand demand) throws ServiceException;

	void deleteDemand(int id) throws ServiceException;

	Demand editDemand(Demand demand)throws ServiceException;
	Demand viewDemand(int id) throws ServiceException;
	Demand editDemand(int id, int id_contractor, String status)throws ServiceException;

}
