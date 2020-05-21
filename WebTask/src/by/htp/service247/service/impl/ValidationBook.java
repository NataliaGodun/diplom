package by.htp.service247.service.impl;

import by.htp.service247.domain.Book;
import by.htp.service247.service.exception.ServiceException;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ValidationBook {

	private static final String MESSAGE_WRONG_NAME = "Incorrect name of the book";
	private static final String MESSAGE_WRONG_WRITER = "Incorrect writer";
	private static final String MESSAGE_WRONG_HOUSE = "Incorrect published house";
	private static final String MESSAGE_WRONG_YEAR = "Incorrect year published";
	private static final String MESSAGE_WRONG_PATH_IMAGE = "Incorrect path image";
	private static final String MESSAGE_WRONG_ID = "This book is not available";
	private static final String MESSAGE_WRONG_GENRE = "Incorect genre";

	public static void validateBook(Book book) throws ServiceException {

		if (book.getNameBook() == null || book.getNameBook().isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_NAME);
		}
		if (book.getWriter() == null || book.getWriter().isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_WRITER);
		}
		if (book.getGenre() == null || book.getGenre().isEmpty()) {

			throw new ServiceException(MESSAGE_WRONG_GENRE);
		}

		if (book.getHouse() == null || book.getHouse().isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_HOUSE);
		}
		if (book.getYear() == null || book.getYear().isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_YEAR);
		}
		if (book.getImage() == null || book.getImage().isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_PATH_IMAGE);
		}
	}

	public static void validateBook(String nameBook) throws ServiceException {
		if (nameBook == null || nameBook.isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_NAME);
		}
	}

	public static void validateBook(int id) throws ServiceException {
		if (id <= 0) {
			throw new ServiceException(MESSAGE_WRONG_ID);
		}
	}
}