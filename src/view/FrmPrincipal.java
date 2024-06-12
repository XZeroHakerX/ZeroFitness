package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Font fontMenu = new Font("Segoe UI", Font.BOLD, 20);
	private final Font fontSubMenu = new Font("Segoe UI", Font.ITALIC, 18);
	private final Font fontFrmLabels = new Font("Rockwell", Font.BOLD | Font.ITALIC, 20);
	private final Font fontFrmTexts = new Font("Rockwell", Font.ITALIC, 20);

	private JPanel pnPadre;
	private JTextField txtUser;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtIMC;
	private JTextField txtWeight;

	public FrmPrincipal() {

		setTitle("ZERO FITNESS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		pnPadre = new JPanel();
		pnPadre.setBackground(new Color(255, 255, 255));
		pnPadre.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(pnPadre);
		pnPadre.setLayout(new GridLayout(0, 3, 15, 15));

		addMenu();
		addComponents();

		setVisible(true);
	}

	private void addComponents() {

		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(255, 255, 255));
		pnLeft.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnPadre.add(pnLeft);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(null);
		pnCenter.setBackground(new Color(255, 255, 255));
		pnPadre.add(pnCenter);

		JPanel pnRight = new JPanel();
		pnRight.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnRight.setBackground(new Color(255, 255, 255));
		pnRight.setLayout(new GridLayout(8, 2, 5, 5));
		pnPadre.add(pnRight);

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
						txtAge.setColumns(10);
		
		JPanel pnWeight = new JPanel();
		pnWeight.setBackground(new Color(255, 228, 181));
		pnWeight.setBackground(Color.WHITE);
		pnRight.add(pnWeight);
		pnWeight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWeight = new JLabel("Weight: ");
		pnWeight.add(lblWeight, BorderLayout.WEST);
		lblWeight.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		
		txtWeight = new JTextField();
		pnWeight.add(txtWeight, BorderLayout.CENTER);
		txtWeight.setFont(new Font("Rockwell", Font.ITALIC, 20));
		txtWeight.setColumns(10);
		
		JPanel pnHeight = new JPanel();
		pnHeight.setBackground(Color.WHITE);
		pnRight.add(pnHeight);
		pnHeight.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHeight = new JLabel("Height:  ");
		pnHeight.add(lblHeight, BorderLayout.WEST);
		lblHeight.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		
		txtHeight = new JTextField();
		pnHeight.add(txtHeight, BorderLayout.CENTER);
		txtHeight.setFont(new Font("Rockwell", Font.ITALIC, 20));
		txtHeight.setColumns(10);
		
		JPanel pnIMC = new JPanel();
		pnIMC.setBackground(new Color(255, 228, 181));
		pnRight.add(pnIMC);
		pnIMC.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIMC = new JLabel("IMC:     ");
		pnIMC.add(lblIMC, BorderLayout.WEST);
		lblIMC.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		
		txtIMC = new JTextField();
		pnIMC.add(txtIMC, BorderLayout.CENTER);
		txtIMC.setFont(new Font("Rockwell", Font.ITALIC, 20));
		txtIMC.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		pnRight.add(lblNewLabel);

	}

	private void addMenu() {

		JMenuBar mnBar;
		JMenu mnUser;
		JMenu mnRoutine;
		JMenu mnExercise;
		JMenuItem mntmAdmin;
		JMenu mnHelp;
		JMenu mnDocumentation;
		JMenuItem mntmManual;
		JMenuItem mntmWeb;
		JMenu mnChangeUser;

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

		mnChangeUser = new JMenu("Change User");
		mnChangeUser.setFont(fontMenu);
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
