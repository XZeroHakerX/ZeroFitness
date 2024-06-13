package model;

/**
 * <h2>WeightException</h2>
 * <i>Excepción para peso negativo o 0 no válido.</i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class WeightException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public WeightException() {
		super("Peso no válido!");
	}

}
