package model;

/**
 * <h2>NameException</h2>
 * <i>Excepción para nombre vacío no válido.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */

public class NameException extends Exception {

	private static final long serialVersionUID = 1L;

	public NameException() {
		super("Nombre no puede estar vacío!");
	}

}
