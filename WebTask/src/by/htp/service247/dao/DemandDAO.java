package by.htp.service247.dao;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;

import by.htp.service247.domain.Demand;

public interface DemandDAO {
	
	ArrayList<Demand> showDemand() throws DAOException;

	
	Demand addDemand(Demand demand) throws DAOException;


	void deleteDemand(int id) throws DAOException;

	

	

}
