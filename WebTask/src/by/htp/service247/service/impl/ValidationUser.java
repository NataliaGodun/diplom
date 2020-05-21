package by.htp.service247.service.impl;

import by.htp.service247.service.exception.ServiceException;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public class ValidationUser {
	private static final String MESSAGE_WRONG_LOGIN = "Incorrect login!";
	private static final String MESSAGE_WRONG_PASSWORD = "Incorrect password!";

	public static void validateUser(String login, String password) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_LOGIN);
		}
		if (password == null || password.isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_PASSWORD);
		}
	}

	public static void validateUser(String login) throws ServiceException {

		if (login == null || login.isEmpty()) {
			throw new ServiceException(MESSAGE_WRONG_LOGIN);
		}

	}

}
