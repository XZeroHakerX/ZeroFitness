package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.User;

public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame context;

	private static String[] usersNames;

	public static List<User> users;
	public static String selectedOption;
	public static JComboBox comboBoxUser;
	public static JButton btnLogin;
	public static JButton btnCancel;

	private Optional<User> aux = null;
	private JLabel lblPassword;
	private JPasswordField passwordField;

	public FrmLogin() {
		getContentPane().setBackground(new Color(255, 228, 181));

		context = this;

		setResizable(false);
		setTitle("Login (Zero Fitness)");
		setAlwaysOnTop(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/resources/IconApp.png")));

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
		comboBoxUser.setFont(new Font("SimSun", Font.BOLD, 20));
		comboBoxUser.setBounds(246, 94, 234, 51);
		comboBoxUser.setSelectedIndex(-1);
		getContentPane().add(comboBoxUser);

		
		JLabel lblChooseUser = new JLabel("Choose User:");
		lblChooseUser.setForeground(new Color(255, 255, 255));
		lblChooseUser.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		lblChooseUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChooseUser.setBounds(246, 33, 191, 51);
		getContentPane().add(lblChooseUser);

		btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);

		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(43, 151, 191, 51);
		lblPassword.setVisible(false);
		getContentPane().add(lblPassword);

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(341, 290, 139, 30);
		getContentPane().add(btnCancel);

		btnLogin.setBounds(341, 216, 139, 51);
		getContentPane().add(btnLogin);

		JLabel lblFotoLogin = new JLabel("Password");
		lblFotoLogin.setBackground(new Color(255, 255, 255));
		lblFotoLogin.setIcon(new ImageIcon(FrmLogin.class.getResource("/resources/fotoLogin1.png")));
		lblFotoLogin.setBounds(10, 10, 566, 343);
		getContentPane().add(lblFotoLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(246, 155, 234, 50);
		passwordField.setVisible(false);
		getContentPane().add(passwordField);

	}

	private void addListeners() {
		CtrFrmLogin ctr = new CtrFrmLogin();

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (passwordField.isVisible() == true) {
					if (Arrays.equals(aux.get().getPassword().toCharArray(), passwordField.getPassword())) {
						ctr.start(context);
					} else {
						passwordField.setText("");
					}
				} else {
					ctr.start(context);
				}
			}
		});

		btnCancel.addActionListener(e -> ctr.startNoLogin(context));

		comboBoxUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				selectedOption = (String) comboBoxUser.getSelectedItem();

				aux = users.stream().filter(user -> user.getName().equals(selectedOption)).findFirst();

				if (aux.get().getPassword() == null) {
					lblPassword.setVisible(false);
					passwordField.setVisible(false);
					btnLogin.setEnabled(true);
				} else {

					lblPassword.setVisible(true);
					passwordField.setVisible(true);
				}

			}

		});

		passwordField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				toggleLoginButton();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				toggleLoginButton();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				toggleLoginButton();
			}

			public void toggleLoginButton() {
				btnLogin.setEnabled(passwordField.getPassword().length > 0);
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
