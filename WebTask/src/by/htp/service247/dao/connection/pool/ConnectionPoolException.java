package by.htp.service247.dao.connection.pool;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class ConnectionPoolException extends Exception {

	private static final long serialVersionUID = 5947919913984690445L;

	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}
}
