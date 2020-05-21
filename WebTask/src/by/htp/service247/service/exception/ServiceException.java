package by.htp.service247.service.exception;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 4794680371890581356L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
