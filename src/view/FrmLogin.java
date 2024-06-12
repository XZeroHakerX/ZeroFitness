package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.User;
import javax.swing.JButton;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame context;

	private static String[] usersNames;

	public static List<User> users;
	public static String selectedOption;
	public static JComboBox comboBoxUser;
	public static JButton btnLogin;
	public static JButton btnCancel;

	public FrmLogin() {

		context = this;

		setResizable(false);
		setTitle("Login (Zero Fitness)");
		setAlwaysOnTop(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/view/IconApp.png")));

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		loadUsers();
		addComponents();
		addListeners();

		setVisible(true);

	}

	private void addComponents() {
		comboBoxUser = new JComboBox<>(usersNames);
		comboBoxUser.setBounds(246, 94, 234, 51);
		getContentPane().add(comboBoxUser);

		JLabel lblNewLabel = new JLabel("Choose User:");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(45, 94, 191, 51);
		getContentPane().add(lblNewLabel);

		btnLogin = new JButton("Login");

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(341, 280, 139, 51);
		getContentPane().add(btnCancel);

		btnLogin.setBounds(341, 216, 139, 51);
		getContentPane().add(btnLogin);

	}

	private void addListeners() {
		CtrFrmLogin ctr = new CtrFrmLogin();

		btnLogin.addActionListener(e -> ctr.start(context));

		btnCancel.addActionListener(e -> ctr.startNoLogin(context));

		comboBoxUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedOption = (String) comboBoxUser.getSelectedItem();
			}

		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ctr.startNoLogin(context);
			}
		});
	}

	private String[] loadUsers() {

		CtrFrmLogin ctr = new CtrFrmLogin();
		users = ctr.loadUsers();
		usersNames = users.stream().map(User::getName).toArray(String[]::new);

		return usersNames;

	}
}
