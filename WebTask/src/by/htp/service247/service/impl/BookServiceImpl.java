package by.htp.service247.service.impl;

import java.util.ArrayList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.BookDAO;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.dao.factory.DAOFactory;
import by.htp.service247.domain.Book;
import by.htp.service247.service.BookService;
import by.htp.service247.service.exception.ServiceException;

/**
 * @author Godun Natalia
 * @version 1.0
 */
/*public class BookServiceImpl implements BookService {

	private static final String MESSAGE_ERROR_LAYER_DAO = "Error from a layer DAO.";

	private static final Logger LOGGER = LogManager.getRootLogger();

	public ArrayList<Book> showBooks() throws ServiceException {

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		ArrayList<Book> List = null;
		try {
			List = bookDAO.showBook();
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
		return List;

	}

	@Override
	public Book addBook(Book book) throws ServiceException {

		ValidationBook.validateBook(book);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			return bookDAO.addBook(book);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Book viewBook(int id) throws ServiceException {

		ValidationBook.validateBook(id);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			return bookDAO.viewBook(id);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteBook(int id) throws ServiceException {

		ValidationBook.validateBook(id);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			bookDAO.deleteBook(id);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Book searchBook(String nameBook) throws ServiceException {

		ValidationBook.validateBook(nameBook);

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();
		try {
			return bookDAO.searchBook(nameBook);
		} catch (DAOException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_LAYER_DAO, e);
			throw new ServiceException(e);
		}
	}
}*/
