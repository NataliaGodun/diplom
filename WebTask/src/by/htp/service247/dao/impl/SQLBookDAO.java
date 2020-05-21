
package by.htp.service247.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.service247.dao.BookDAO;
import by.htp.service247.dao.connection.pool.ConnectionPool;
import by.htp.service247.dao.connection.pool.ConnectionPoolException;
import by.htp.service247.dao.connection.pool.ConnectionPoolFactory;
import by.htp.service247.dao.exception.DAOException;
import by.htp.service247.domain.Book;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public class SQLBookDAO implements BookDAO {
	private static final String SELECT_ALL_BOOK = "SELECT * FROM BOOKS WHERE STATUS='EXIST'";
	private static final String ADD_BOOK = "INSERT INTO BOOKS (WRITER,NAMEBOOK,IMAGE,GENRE,PUBLISHINGHOUSE,PUBLISHINGYEAR,STATUS) VALUES(?,?,?,?,?,?,'EXIST')";
	private static final String BOOK_SELECT = "SELECT * FROM BOOKS WHERE WRITER=? AND NAMEBOOK=? AND STATUS='EXIST'";
	private static final String SELECT_BOOK_ID = "SELECT * FROM BOOKS WHERE ID=? AND STATUS='EXIST' ";
	private static final String DELETE_BOOK_ID = "UPDATE BOOKS SET STATUS='DELETE' WHERE ID=?";
	private static final String SELECT_NAME_OF_BOOK = "SELECT * FROM BOOKS WHERE NAMEBOOK=? AND STATUS='EXIST' ";
	private static final String MESSAGE_ERROR_CONNECTION_POOL = "Error at connection pool.";
	private static final String MESSAGE_ERROR_SQL = "Error at sql.";
	private static final String MESSAGE_ERROR_REMOVE_CONNECTION = "Error at remove connection.";
	private static final int FIRST = 1;
	private static final int SECOND = 2;
	private static final int THIRD = 3;
	private static final int FOURTH = 4;
	private static final int FIFTH = 5;
	private static final int SIXTH = 6;
	private static final int SEVENTH = 7;

	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public ArrayList<Book> showBook() throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Book book = null;

		ArrayList<Book> List = new ArrayList<Book>();

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();

		try {

			con = cp.takeConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_BOOK);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				String writer = rs.getString(SECOND);
				String nameBook = rs.getString(THIRD);
				String image = rs.getString(FOURTH);
				String genre = rs.getString(FIFTH);
				String house = rs.getString(SIXTH);
				String year = rs.getString(SEVENTH);

				book = new Book(id, writer, nameBook, image, genre, house, year);
				List.add(book);
			}
		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}

		return List;
	}

	@Override
	public Book addBook(Book book) throws DAOException {

		Connection con = null;
		ResultSet rs = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();

		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(ADD_BOOK);

			ps.setString(FIRST, book.getWriter());
			ps.setString(SECOND, book.getNameBook());
			ps.setString(THIRD, book.getImage());
			ps.setString(FOURTH, book.getGenre());
			ps.setString(FIFTH, book.getHouse());
			ps.setString(SIXTH, book.getYear());

			ps.executeUpdate();

			ps = con.prepareStatement(BOOK_SELECT);
			ps.setString(FIRST, book.getWriter());
			ps.setString(SECOND, book.getNameBook());
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(FIRST);
				String Writer = rs.getString(SECOND);
				String NameBook = rs.getString(THIRD);
				String Image = rs.getString(FOURTH);
				String Genre = rs.getString(FIFTH);
				String House = rs.getString(SIXTH);
				String Year = rs.getString(SEVENTH);

				book = new Book(id, Writer, NameBook, Image, Genre, House, Year);
			}

		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return book;
	}

	@Override
	public Book viewBook(int id) throws DAOException {

		Connection con = null;
		ResultSet rs = null;
		Book book = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {

			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(SELECT_BOOK_ID);

			ps.setInt(FIRST, id);

			rs = ps.executeQuery();
			while (rs.next()) {

				int idDB = rs.getInt(FIRST);
				String writer = rs.getString(SECOND);
				String nameBook = rs.getString(THIRD);
				String image = rs.getString(FOURTH);
				String genre = rs.getString(FIFTH);
				String house = rs.getString(SIXTH);
				String year = rs.getString(SEVENTH);

				book = new Book(idDB, writer, nameBook, image, genre, house, year);
			}

		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return book;
	}

	@Override
	public void deleteBook(int id) throws DAOException {
		Connection con = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {
			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(DELETE_BOOK_ID);
			ps.setInt(FIRST, id);

			ps.executeUpdate();

		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
	}

	@Override
	public Book searchBook(String nameBook) throws DAOException {
		Connection con = null;
		ResultSet rs = null;
		Book book = null;

		ConnectionPoolFactory ObjectCPFactory = ConnectionPoolFactory.getInstance();
		ConnectionPool cp = ObjectCPFactory.getConnectionPool();
		try {

			con = cp.takeConnection();

			PreparedStatement ps = con.prepareStatement(SELECT_NAME_OF_BOOK);

			ps.setString(FIRST, nameBook);

			rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt(FIRST);
				String writer = rs.getString(SECOND);
				String namebook = rs.getString(THIRD);
				String image = rs.getString(FOURTH);
				String genre = rs.getString(FIFTH);
				String house = rs.getString(SIXTH);
				String year = rs.getString(SEVENTH);

				book = new Book(id, writer, namebook, image, genre, house, year);
			}

		} catch (ConnectionPoolException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_CONNECTION_POOL, e);
			throw new DAOException(e);
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, MESSAGE_ERROR_SQL, e);
			throw new DAOException(e);
		} finally {
			try {
				cp.removeConnection();
			} catch (ConnectionPoolException e) {
				LOGGER.log(Level.ERROR, MESSAGE_ERROR_REMOVE_CONNECTION, e);
			}
		}
		return book;
	}

}