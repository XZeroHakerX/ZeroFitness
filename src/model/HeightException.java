package model;

/**
 * <h2>WeightException</h2>
 * <i>Excepción para altura negativa o 0 no válida.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class HeightException extends Exception {

	private static final long serialVersionUID = 1L;

	public HeightException() {
		super("Altura no válida!");
	}
}
