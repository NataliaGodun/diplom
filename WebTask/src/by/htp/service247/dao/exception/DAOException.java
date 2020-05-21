package by.htp.service247.dao.exception;

/**
 * @author Godun Natalia
 * @version 1.0
 */

public class DAOException extends Exception {

	private static final long serialVersionUID = 8797956540255244445L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
