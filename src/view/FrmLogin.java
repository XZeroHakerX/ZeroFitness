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
import java.awt.Color;
import javax.swing.ImageIcon;

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

		btnCancel = new JButton("Cancel");

		btnCancel.setBounds(341, 280, 139, 51);
		getContentPane().add(btnCancel);

		btnLogin.setBounds(341, 216, 139, 51);
		getContentPane().add(btnLogin);
		
		JLabel lblFotoLogin = new JLabel("");
		lblFotoLogin.setIcon(new ImageIcon(FrmLogin.class.getResource("/resources/fotoLogin1.png")));
		lblFotoLogin.setBounds(10, 10, 566, 343);
		getContentPane().add(lblFotoLogin);

	}

	private void addListeners() {
		CtrFrmLogin ctr = new CtrFrmLogin();

		btnLogin.addActionListener(e -> ctr.start(context));

		btnCancel.addActionListener(e -> ctr.startNoLogin(context));

		comboBoxUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedOption = (String) comboBoxUser.getSelectedItem();
				btnLogin.setEnabled(true);
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
