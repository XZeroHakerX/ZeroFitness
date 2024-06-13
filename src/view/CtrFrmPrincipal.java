package view;

import java.awt.Color;
import java.text.DecimalFormat;
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
			FrmPrincipal.lblIMCMessage.setText("User no selected.");

		} else {

			FrmPrincipal.txtUser.setText(userActive.get().getName());
			FrmPrincipal.txtAge.setText(userActive.get().getAge().toString());
			FrmPrincipal.txtWeight.setText(userActive.get().getWeight().toString());
			FrmPrincipal.txtHeight.setText(userActive.get().getHeight().toString());

			DecimalFormat df = new DecimalFormat("#.00");
			Double auxImc = userActive.get().getIMC();

			FrmPrincipal.txtIMC.setText(df.format(auxImc));

			if (auxImc < 18.5) {
				FrmPrincipal.lblIMCMessage.setText("Underweight than normal.");
				FrmPrincipal.lblIMCMessage.setForeground(new Color(0, 191, 255));
			} else if (auxImc >= 18.5 && auxImc < 24.9) {
				FrmPrincipal.lblIMCMessage.setText("Normal weight.");
				FrmPrincipal.lblIMCMessage.setForeground(new Color(124, 252, 0));
			} else if (auxImc >= 24.9 && auxImc < 29.9) {
				FrmPrincipal.lblIMCMessage.setText("Weight higher than normal.");
				FrmPrincipal.lblIMCMessage.setForeground(new Color(255, 165, 0));
			} else {
				FrmPrincipal.lblIMCMessage.setText("Obesity");
			}

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
