package controller;

import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 * <h2>Class CrtUsuario</h2> <i>Controlador encargado del CRUD Usuario. </i>
 * 
 * @version v0.1 10/06/2024
 * @author Zero Haker
 * 
 */
public class CtrUser {

	public void createUsuario(Integer dni, String name, String userName, String password, Integer age, Double weight,
			Double height) throws Exception {

		// Conexion con base para comprobar que no exista un user igual

	}

	public void deleteUsuario(User usuario) {

	}

	public List<User> listUser() {

		User a = null;
		List<User> aux = new ArrayList<User>();
		try {

			aux.add(new User(47560414, "Julian", null, null, 32, 68.2, 1.69));
			aux.add(new User(47560001, "Pepe", null, null, 31, 80.0, 1.88));
			aux.add(new User(47560002, "Angela", null, null, 27, 90.0, 1.90));
			aux.add(new User(47850003, "Anyelina", null, null, 40, 40.2, 1.99));

		} catch (Exception e) {
			System.out.println("No puedo");
		}

		return aux;

	}

	public void updateUsuario(String name, Integer age, Double weight, Double height) {

	}

}
