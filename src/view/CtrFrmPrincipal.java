package view;

import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.User;

public class CtrFrmPrincipal {

	public static Boolean isEdit = false;
	public static Optional<User> userActive = null;

	public void changeUser(JFrame context) {

		context.dispose();
		userActive = null;
		new FrmLogin();

	}

	public void loadDataUser() {

		userActive = CtrFrmLogin.userSelected;

		if (userActive == null) {
			FrmPrincipal.txtUser.setText("User no selected.");
			FrmPrincipal.txtAge.setText("0");
			FrmPrincipal.txtWeight.setText("0");
			FrmPrincipal.txtHeight.setText("0");

		} else {
			FrmPrincipal.txtUser.setText(userActive.get().getName());
			FrmPrincipal.txtAge.setText(userActive.get().getAge().toString());
			FrmPrincipal.txtWeight.setText(userActive.get().getWeight().toString());
			FrmPrincipal.txtHeight.setText(userActive.get().getHeight().toString());
			FrmPrincipal.txtIMC.setText(userActive.get().getIMC().toString());
			
		}
	}

	public void editUser() {

		if (isEdit == true || userActive == null) {
			isEdit = false;
			setEditInactive();
		} else {
			isEdit = true;
			setEditActive();
		}

	}

	private void setEditActive() {

		FrmPrincipal.txtUser.setEditable(true);
		FrmPrincipal.txtAge.setEditable(true);
		FrmPrincipal.txtWeight.setEditable(true);
		FrmPrincipal.txtHeight.setEditable(true);
		FrmPrincipal.btnCancel.setEnabled(true);
		FrmPrincipal.btnSave.setEnabled(true);

	}

	private void setEditInactive() {

		FrmPrincipal.txtUser.setEditable(false);
		FrmPrincipal.txtAge.setEditable(false);
		FrmPrincipal.txtWeight.setEditable(false);
		FrmPrincipal.txtHeight.setEditable(false);

		FrmPrincipal.btnCancel.setEnabled(false);
		FrmPrincipal.btnSave.setEnabled(false);

	}

	public void cancelEdit() {

		isEdit = false;
		setEditInactive();
	}

	public void startRoutine() {

	}

	public void openAdminUser() {

	}

	public void openManual() {

	}

	public void exit(JFrame context) {

		String question = "Are you sure?";
		int answer = JOptionPane.showConfirmDialog(context, question, "EXIT", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (answer == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

}
