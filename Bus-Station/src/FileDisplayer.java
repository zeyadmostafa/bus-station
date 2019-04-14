import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JFileChooser;

public class FileDisplayer {

	private JFrame frame;
	private JScrollPane jsp;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void Display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileDisplayer window = new FileDisplayer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public FileDisplayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 204));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 590, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 55, 556, 311);
		frame.getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(51, 0, 102));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(472, 381, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnTrips = new JRadioButton("Trips");
		rdbtnTrips.setBackground(new Color(204, 153, 255));
		rdbtnTrips.setForeground(SystemColor.textHighlight);
		rdbtnTrips.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rdbtnTrips.setBounds(140, 15, 80, 23);
		frame.getContentPane().add(rdbtnTrips);
		
		JRadioButton rdbtnDrivers = new JRadioButton("Drivers");
		rdbtnDrivers.setBackground(new Color(204, 153, 255));
		rdbtnDrivers.setForeground(SystemColor.textHighlight);
		rdbtnDrivers.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rdbtnDrivers.setBounds(221, 15, 80, 23);
		frame.getContentPane().add(rdbtnDrivers);
		
		JRadioButton rdbtnVehicles = new JRadioButton("Vehicles");
		rdbtnVehicles.setBackground(new Color(204, 153, 255));
		rdbtnVehicles.setForeground(SystemColor.textHighlight);
		rdbtnVehicles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rdbtnVehicles.setBounds(303, 15, 89, 23);
		frame.getContentPane().add(rdbtnVehicles);
		
		JRadioButton rdbtnClients = new JRadioButton("Clients");
		rdbtnClients.setBounds(64, 14, 74, 25);
		frame.getContentPane().add(rdbtnClients);
		rdbtnClients.setForeground(SystemColor.textHighlight);
		rdbtnClients.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rdbtnClients.setBackground(new Color(204, 153, 255));
	
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnDrivers);
		buttonGroup.add(rdbtnTrips);
		buttonGroup.add(rdbtnVehicles);
		buttonGroup.add(rdbtnClients);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileReader reader = null;
				String FileName = null;
				if(rdbtnDrivers.isSelected())
					FileName="Drivers.txt";
				else if (rdbtnTrips.isSelected())
					FileName="Trips.txt";
				else if (rdbtnVehicles.isSelected())
					FileName="Vehicles.txt";
				else if(rdbtnClients.isSelected())
					FileName="Clients.txt";
				
				try {
					reader = new FileReader(FileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedReader br=new BufferedReader(reader);
				try {
					textArea.read(br, null);
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textArea.requestFocus();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 0, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(444, 15, 102, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBounds(-38, 11, 628, 33);
		frame.getContentPane().add(panel);
/*
 *
 */
	}
}
