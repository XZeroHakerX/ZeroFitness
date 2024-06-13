package model;

/**
 * <h2>AgeException</h2> 
 * <i>Excepción para edad negativa o 0 no válida.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class AgeException extends Exception {

	private static final long serialVersionUID = 1L;

	public AgeException() {
		super("Edad no válida!");
	}

}
