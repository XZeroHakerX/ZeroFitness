package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_5;

	
	public FrmPrincipal() {
		
		setTitle("ZERO FITNESS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		addComponent();
		
		setVisible(true);
	}

	private void addComponent() {

		pnPadre = new JPanel();
		pnPadre.setLayout(new GridLayout(1, 3, 5, 5));
		setContentPane(pnPadre);
		
		pnLeft = new JPanel();
		pnPadre.add(pnLeft);
		pnLeft.setLayout(new GridLayout(2, 0, 10, 10));
		
		panel = new JPanel();
		pnLeft.add(panel);
		
		panel_1 = new JPanel();
		pnLeft.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 20, 20));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 15, 15));
		
		panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 15, 15));
		
		btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);
		
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
