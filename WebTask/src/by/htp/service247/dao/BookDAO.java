package by.htp.service247.dao;

import java.util.ArrayList;

import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Book;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public interface BookDAO {
	/**
	 * @return return all books
	 * @throws DAOException
	 *             exception at unsuccessful viewing of all books
	 */
	ArrayList<Book> showBook() throws DAOException;

	/**
	 * add the book to database
	 * 
	 * @return returns the book added to library
	 * @param book
	 *            the book which should be added to database
	 * @throws DAOException
	 *             exception at unsuccessful addition of the book
	 */
	Book addBook(Book book) throws DAOException;

	/**
	 * check the book from database
	 * 
	 * @return returns the chosen book
	 * @param id
	 *            id of the book which we want to see
	 * @throws DAOException
	 *             exception at unsuccessful viewing of the book
	 */
	Book viewBook(int id) throws DAOException;

	/**
	 * delete the book from database
	 * 
	 * @param id
	 *            id of the book which we want to delete
	 * @throws DAOException
	 *             exception at unsuccessful deleting the book
	 */
	void deleteBook(int id) throws DAOException;

	/**
	 * check the book from database
	 * 
	 * @return returns the chosen book
	 * @param nameBook
	 *            book title
	 * @throws DAOException
	 *             exception by unsuccessful search of the book
	 */
	Book searchBook(String nameBook) throws DAOException;

}