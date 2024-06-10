package model;

/**
 * <h2>NameException</h2>
 * <i>Excepci�n para nombre vac�o no v�lido.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */

public class NameException extends Exception {

	private static final long serialVersionUID = 1L;

	public NameException() {
		super("Nombre no puede estar vac�o!");
	}

}
