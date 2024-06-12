package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Font fontMenu = new Font("Segoe UI", Font.BOLD, 20);
	private final Font fontSubMenu = new Font("Segoe UI", Font.ITALIC, 18);
	private final Font fontFrmLabels = new Font("Rockwell", Font.BOLD | Font.ITALIC, 20);
	private final Font fontFrmTexts = new Font("Rockwell", Font.ITALIC, 20);
	private final Font fontBttn = new Font("Sylfaen", Font.BOLD, 20);

	public static JMenuItem mntmAdmin, mntmManual, mntmWeb, mntmChangeUser;

	public static JTextField txtUser;
	public static JTextField txtAge;
	public static JTextField txtHeight;
	public static JTextField txtIMC;
	public static JTextField txtWeight;
	public static JButton btnCancel;
	public static JButton btnSave;
	public static JButton btnCopiarRutina;
	public static JButton btnStartRoutine;
	private static JButton btnEdit;

	private static JFrame context;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/view/IconApp.png")));

		context = this;

		setTitle("ZERO FITNESS");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addMenu();
		addComponents();
		addListeners();
		loadData();

		setVisible(true);

	}

	private void addListeners() {
		CtrFrmPrincipal ctr = new CtrFrmPrincipal();

		btnEdit.addActionListener(e -> ctr.editUser());
		btnCancel.addActionListener(e -> ctr.cancelEdit());
		mntmChangeUser.addActionListener(e -> ctr.changeUser(context));

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ctr.exit(context);
			}
		});

	}

	private void loadData() {
		CtrFrmPrincipal ctr = new CtrFrmPrincipal();
		ctr.loadDataUser();

	}

	private void addComponents() {

		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new GridLayout(0, 3, 15, 15));

		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(255, 255, 255));
		pnLeft.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(pnLeft);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(null);
		pnCenter.setBackground(new Color(255, 228, 181));
		getContentPane().add(pnCenter);
		pnCenter.setLayout(new BorderLayout(0, 0));

		JLabel lblRoutines = new JLabel("Routines: ");
		lblRoutines.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pnCenter.add(lblRoutines, BorderLayout.NORTH);

		JPanel pnButtonRoutines = new JPanel();
		pnButtonRoutines.setBackground(new Color(255, 228, 181));
		pnCenter.add(pnButtonRoutines, BorderLayout.SOUTH);
		pnButtonRoutines.setLayout(new GridLayout(0, 2, 40, 5));

		btnCopiarRutina = new JButton("Copy and Start");
		btnCopiarRutina.setEnabled(false);
		pnButtonRoutines.add(btnCopiarRutina);

		btnStartRoutine = new JButton("Start New Routine");
		pnButtonRoutines.add(btnStartRoutine);

		JScrollPane scrollPane = new JScrollPane();
		pnCenter.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JPanel pnRight = new JPanel();
		pnRight.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnRight.setBackground(new Color(255, 255, 255));
		pnRight.setLayout(new GridLayout(8, 2, 5, 5));
		getContentPane().add(pnRight);

		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(255, 228, 181));
		pnRight.add(pnUser);
		pnUser.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblUser = new JLabel("User:");
		lblUser.setBackground(new Color(255, 255, 255));
		pnUser.add(lblUser);
		lblUser.setFont(fontFrmLabels);

		txtUser = new JTextField();
		pnUser.add(txtUser);
		txtUser.setEditable(false);
		txtUser.setColumns(10);

		JPanel pnAge = new JPanel();
		pnAge.setBackground(new Color(255, 255, 255));
		pnRight.add(pnAge);
		pnAge.setLayout(new BorderLayout(0, 0));

		JLabel lblAge = new JLabel("Age:       ");
		pnAge.add(lblAge, BorderLayout.WEST);
		lblAge.setFont(fontFrmLabels);

		txtAge = new JTextField();
		pnAge.add(txtAge, BorderLayout.CENTER);
		txtAge.setFont(fontFrmTexts);
		txtAge.setEditable(false);
		txtAge.setColumns(10);

		JPanel pnWeight = new JPanel();
		pnWeight.setBackground(new Color(255, 228, 181));
		pnWeight.setBackground(Color.WHITE);
		pnRight.add(pnWeight);
		pnWeight.setLayout(new BorderLayout(0, 0));

		JLabel lblWeight = new JLabel("Weight: ");
		pnWeight.add(lblWeight, BorderLayout.WEST);
		lblWeight.setFont(fontFrmLabels);

		txtWeight = new JTextField();
		pnWeight.add(txtWeight, BorderLayout.CENTER);
		txtWeight.setFont(fontFrmTexts);
		txtWeight.setEditable(false);
		txtWeight.setColumns(10);

		JPanel pnHeight = new JPanel();
		pnHeight.setBackground(Color.WHITE);
		pnRight.add(pnHeight);
		pnHeight.setLayout(new BorderLayout(0, 0));

		JLabel lblHeight = new JLabel("Height:  ");
		pnHeight.add(lblHeight, BorderLayout.WEST);
		lblHeight.setFont(fontFrmLabels);

		txtHeight = new JTextField();
		pnHeight.add(txtHeight, BorderLayout.CENTER);
		txtHeight.setFont(fontFrmTexts);
		txtHeight.setEditable(false);
		txtHeight.setColumns(10);

		JPanel pnIMC = new JPanel();
		pnIMC.setBackground(new Color(255, 228, 181));
		pnRight.add(pnIMC);
		pnIMC.setLayout(new BorderLayout(0, 0));

		JLabel lblIMC = new JLabel("IMC:      ");
		pnIMC.add(lblIMC, BorderLayout.WEST);
		lblIMC.setFont(fontFrmLabels);

		txtIMC = new JTextField();
		pnIMC.add(txtIMC, BorderLayout.CENTER);
		txtIMC.setFont(fontFrmTexts);
		txtIMC.setEditable(false);
		txtIMC.setColumns(10);

		JLabel lblIMCMessage = new JLabel("");
		lblIMCMessage.setFont(fontFrmLabels);
		pnRight.add(lblIMCMessage);

		JPanel pnGuardar = new JPanel();
		pnRight.add(pnGuardar);
		pnGuardar.setLayout(new GridLayout(0, 2, 40, 5));

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(fontBttn);
		pnGuardar.add(btnCancel);
		btnCancel.setEnabled(false);

		btnSave = new JButton("SAVE!");
		btnSave.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/view/IconSave.png")));
		btnSave.setFont(fontBttn);
		pnGuardar.add(btnSave);
		btnSave.setEnabled(false);

		JPanel pnEdit = new JPanel();
		pnEdit.setBackground(new Color(255, 255, 255));
		pnRight.add(pnEdit);
		pnEdit.setLayout(new GridLayout(0, 2, 30, 30));

		JLabel lblActiveEdit = new JLabel("Active edit User! --->");
		lblActiveEdit.setBackground(new Color(240, 128, 128));
		lblActiveEdit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pnEdit.add(lblActiveEdit);

		btnEdit = new JButton("EDIT");
		btnEdit.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/view/IconEdit.png")));

		btnEdit.setFont(fontBttn);
		btnEdit.setMnemonic('E');
		pnEdit.add(btnEdit);

	}

	private void addMenu() {

		JMenuBar mnBar;
		JMenu mnUser;
		JMenu mnRoutine;
		JMenu mnExercise;
		JMenu mnHelp;
		JMenu mnDocumentation;

		mnBar = new JMenuBar();
		mnBar.setBackground(new Color(255, 228, 181));
		setJMenuBar(mnBar);

		mnUser = new JMenu("User");
		mnUser.setFont(fontMenu);
		mnBar.add(mnUser);

		mntmAdmin = new JMenuItem("Admin Users");
		mntmAdmin.setFont(fontSubMenu);
		mnUser.add(mntmAdmin);

		mnUser.add(new JSeparator());

		mntmChangeUser = new JMenuItem("Change User");
		mntmChangeUser.setFont(fontMenu);
		mnUser.add(mntmChangeUser);

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
		mnDocumentation.setFont(fontMenu);
		mnHelp.add(mnDocumentation);

		mntmManual = new JMenuItem("Manual");
		mntmManual.setFont(fontSubMenu);
		mnDocumentation.add(mntmManual);

		mnDocumentation.add(new JSeparator());

		mntmWeb = new JMenuItem("Web");
		mntmWeb.setFont(fontSubMenu);
		mnDocumentation.add(mntmWeb);
	}

}
