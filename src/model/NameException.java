package model;
/**
 * <h2>ExceptionName</h2>
 * <i>Excepci�n para identificar nombre inv�lido.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */

public class NameException extends Exception {

	private static final long serialVersionUID = 1L;

	public NameException() {
		super("NameException");
	}

}
