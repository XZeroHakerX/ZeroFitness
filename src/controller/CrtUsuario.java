package controller;

import java.util.List;

import model.Usuario;

/**
 * <h2>Class CrtUsuario</h2> <i>Controlador encargado del CRUD Usuario. </i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class CrtUsuario {

	public void createUsuario(String name, String userName, String password, Integer age, Double weight, Double height)
			throws Exception {

		Usuario u = new Usuario(name, userName, password, age, weight, height);
		// Conexion con base para comprobar que no exista un user igual

	}

	public void deleteUsuario(Usuario usuario) {

	}

	public List<Usuario> listUsuario() {

		return null;
	}

	public void updateUsuario() {

	}
}
