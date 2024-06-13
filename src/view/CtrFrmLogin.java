package view;

import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import controller.CtrUser;
import model.User;

public class CtrFrmLogin {

	public static Optional<User> userSelected;


	public void start(JFrame context) {

		userSelected = FrmLogin.users.stream().filter(user -> user.getName().equals(FrmLogin.selectedOption))
				.findFirst();

		context.dispose();

		new FrmPrincipal();

	}

	public void startNoLogin(JFrame context) {

		context.dispose();

		userSelected = null;

		new FrmPrincipal();
	}

	public List<User> loadUsers() {
		CtrUser ctr = new CtrUser();
		List<User> users = ctr.listUser();
		return users;

	}

}
