package by.htp.service247.dao;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;

import by.htp.service247.domain.Demand;

public interface DemandDAO {
	
	ArrayList<Demand> showDemand(int id) throws DAOException;
	ArrayList<Demand> showDemand(String department) throws DAOException;

	
	Demand addDemand(Demand demand) throws DAOException;


	void deleteDemand(int id) throws DAOException;


	Demand editDemand(Demand demand)throws DAOException;
	Demand viewDemand(int id) throws DAOException;

	

	

}
