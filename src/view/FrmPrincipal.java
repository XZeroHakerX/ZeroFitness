package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Font fontMenu = new Font("Segoe UI", Font.BOLD, 20);

	private JPanel pnPadre;
	private JMenuBar mnBar;
	private JMenu mnUser;
	private JMenu mnRoutine;
	private JMenu mnExercise;
	private JMenuItem mntmAdmin;
	private JMenu mnHelp;
	private JMenu mnDocumentation;
	private JMenuItem mntmManual;
	private JMenuItem mntmWeb;
	private JMenu mnChangeUser;
	private JPanel pnRight;
	private JPanel pnLeft;
	private JPanel pnRightUp;
	private JPanel pnRightDown;
	private JLabel lblListRoutine;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblExercises;
	private JScrollPane scrollPane_1;
	private JList list_1;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnBreakTime;
	private JButton btnNextExercise;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField textField;
	private JTextField txtMin;
	private JButton btnFinishRoutine;
	private JPanel panel_7;
	private JPanel panel_8;

	public FrmPrincipal() {

		setTitle("ZERO FITNESS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		addComponent();

		setVisible(true);
	}

	private void addComponent() {

		pnPadre = new JPanel();
		pnPadre.setBackground(new Color(255, 255, 255));
		pnPadre.setBorder(UIManager.getBorder("Button.border"));
		pnPadre.setLayout(new GridLayout(1, 3, 5, 5));
		setContentPane(pnPadre);

		pnLeft = new JPanel();
		pnPadre.add(pnLeft);
		pnLeft.setLayout(new GridLayout(2, 0, 10, 10));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		pnLeft.add(panel);

		panel_1 = new JPanel();
		pnLeft.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 20, 20));

		panel_6 = new JPanel();
		panel_1.add(panel_6);

		btnBreakTime = new JButton("Break Time!");
		btnBreakTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		btnBreakTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(btnBreakTime);

		btnNextExercise = new JButton("Next Exercise!");
		panel_6.add(btnNextExercise);
		btnNextExercise.setFont(new Font("Tahoma", Font.PLAIN, 24));

		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 15, 15));

		panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		panel_5.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		txtMin = new JTextField();
		txtMin.setBackground(new Color(255, 255, 255));
		txtMin.setEditable(false);
		txtMin.setHorizontalAlignment(SwingConstants.LEFT);
		txtMin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtMin.setText("/03:00 min");
		panel_4.add(txtMin, BorderLayout.CENTER);
		txtMin.setColumns(10);

		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 15, 15));

		panel_8 = new JPanel();
		panel_3.add(panel_8);

		panel_7 = new JPanel();
		panel_3.add(panel_7);

		btnFinishRoutine = new JButton("Finish Routine!");
		panel_7.add(btnFinishRoutine);
		btnFinishRoutine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinishRoutine.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinishRoutine.setBackground(new Color(144, 238, 144));
		btnFinishRoutine.setFont(new Font("Tahoma", Font.PLAIN, 24));

		pnRight = new JPanel();
		pnPadre.add(pnRight);
		pnRight.setLayout(new GridLayout(2, 0, 10, 10));

		pnRightUp = new JPanel();
		pnRight.add(pnRightUp);
		pnRightUp.setLayout(new BorderLayout(0, 0));

		lblListRoutine = new JLabel("Active routines: ");
		lblListRoutine.setHorizontalAlignment(SwingConstants.CENTER);
		lblListRoutine.setForeground(SystemColor.textHighlight);
		lblListRoutine.setBackground(SystemColor.activeCaption);
		lblListRoutine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRightUp.add(lblListRoutine, BorderLayout.NORTH);

		scrollPane = new JScrollPane();
		pnRightUp.add(scrollPane, BorderLayout.CENTER);

		list = new JList();
		scrollPane.setViewportView(list);

		pnRightDown = new JPanel();
		pnRight.add(pnRightDown);
		pnRightDown.setLayout(new BorderLayout(0, 0));

		lblExercises = new JLabel("Exercises:");
		lblExercises.setHorizontalAlignment(SwingConstants.CENTER);
		lblExercises.setForeground(new Color(255, 0, 0));
		lblExercises.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRightDown.add(lblExercises, BorderLayout.NORTH);

		scrollPane_1 = new JScrollPane();
		pnRightDown.add(scrollPane_1, BorderLayout.CENTER);

		list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		addMenu();

		mnBar = new JMenuBar();
		setJMenuBar(mnBar);

		mnUser = new JMenu("User");
		mnUser.setFont(fontMenu);
		mnBar.add(mnUser);

		mntmAdmin = new JMenuItem("Admin Users");
		mnUser.add(mntmAdmin);

		mnUser.add(new JSeparator());

		mnChangeUser = new JMenu("Change User");
		mnUser.add(mnChangeUser);

		mnRoutine = new JMenu("Routine");
		mnRoutine.setFont(fontMenu);
		mnBar.add(mnRoutine);

		mnExercise = new JMenu("Exercise");
		mnExercise.setFont(fontMenu);
		mnBar.add(mnExercise);

		mnHelp = new JMenu("Help");
		mnHelp.setFont(fontMenu);
		mnBar.add(mnHelp);

		mnDocumentation = new JMenu("Documentation");
		mnHelp.add(mnDocumentation);

		mntmManual = new JMenuItem("Manual");
		mnDocumentation.add(mntmManual);

		mnDocumentation.add(new JSeparator());

		mntmWeb = new JMenuItem("Web");
		mnDocumentation.add(mntmWeb);

	}

	private void addMenu() {

	}

}
