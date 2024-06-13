package model;

/**
 * <h2>WeightException</h2>
 * <i>Excepci�n para altura negativa o 0 no v�lida.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class HeightException extends Exception {

	private static final long serialVersionUID = 1L;

	public HeightException() {
		super("Altura no v�lida!");
	}
}
