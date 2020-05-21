package by.htp.service247.service;

import java.util.ArrayList;

import by.htp.service247.domain.Book;
import by.htp.service247.service.exception.ServiceException;

/**
 * Ñhecks the parameters and passes control to the dao layer
 * 
 * @author Godun Natalia
 * @version 1.0
 */
public interface BookService {
	ArrayList<Book> showBooks() throws ServiceException;

	Book addBook(Book book) throws ServiceException;

	Book viewBook(int id) throws ServiceException;

	void deleteBook(int id) throws ServiceException;

	Book searchBook(String nameBook) throws ServiceException;

}
