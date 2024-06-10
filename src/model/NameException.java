package model;
/**
 * <h2>ExceptionName</h2>
 * <i>Excepción para identificar nombre inválido.</i>
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
