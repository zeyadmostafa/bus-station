import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Savepoint;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JButton;

public class ManagerLoginWindow {

	private JFrame frmMyBusStation;
	Manager manager=new Manager();
	TripsManagement tripsmanagement=new TripsManagement();
	/**
	 * Launch the application.
	 */
	public static void LoginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLoginWindow window = new ManagerLoginWindow();
					window.frmMyBusStation.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerLoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyBusStation = new JFrame();
		frmMyBusStation.setTitle(" Bus Station");
		frmMyBusStation.setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerLoginWindow.class.getResource("/images/2000px-BUS-Logo-BVG.svg.png")));
		frmMyBusStation.getContentPane().setBackground(Color.WHITE);
		frmMyBusStation.getContentPane().setLayout(null);
		  final JFileChooser fileChooser = new JFileChooser();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		panel.setBounds(0, 0, 299, 756);
		frmMyBusStation.getContentPane().add(panel);
		panel.setLayout(null);
		frmMyBusStation.setBackground(Color.WHITE);
		frmMyBusStation.setBounds(100, 100, 734, 697);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(41, 121, 218, 315);
		lblNewLabel.setIcon(new ImageIcon(ManagerLoginWindow.class.getResource("/images/Document.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUS");
		lblNewLabel_1.setFont(new Font("Elephant", Font.BOLD, 55));
		lblNewLabel_1.setForeground(new Color(153, 51, 153));
		lblNewLabel_1.setBounds(67, 423, 186, 85);
		panel.add(lblNewLabel_1);
		
		JLabel lblStation = new JLabel("STATION");
		lblStation.setForeground(new Color(153, 51, 153));
		lblStation.setFont(new Font("Elephant", Font.BOLD, 40));
		lblStation.setBounds(41, 488, 243, 104);
		panel.add(lblStation);
		
		JComboBox<Integer> comboRemove = new JComboBox<Integer>();
		comboRemove.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboRemove.setVisible(false);
		comboRemove.setBounds(572, 184, 61, 25);
		frmMyBusStation.getContentPane().add(comboRemove);
		
		
		Button button = new Button("Add Trip");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	NewTripWindow newtrip=new NewTripWindow();
				NewTripWindow.NewTrip();
			}
		});
		button.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(51, 0, 102));
		button.setBounds(325, 126, 225, 37);
		frmMyBusStation.getContentPane().add(button);
		
		Button SaveBtn = new Button("Save");
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 String deleteIndex= comboRemove.getSelectedItem().toString();
			 manager.DeleteTrip(Integer.parseInt(deleteIndex));
			 JOptionPane.showMessageDialog(null, "Trip Successefully deleted");
			 comboRemove.setVisible(false);
			 SaveBtn.setVisible(false);
			}
		});
		SaveBtn.setForeground(Color.WHITE);
		SaveBtn.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 17));
		SaveBtn.setBackground(new Color(51, 0, 102));
		SaveBtn.setBounds(638, 184, 70, 25);
		frmMyBusStation.getContentPane().add(SaveBtn);
		SaveBtn.setVisible(false);
		
	
		Button button_1 = new Button("Remove Trip");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            tripsmanagement.LoadFromFile();
				for(int i=1;i<=tripsmanagement.TripNumber+1;i++)
				{comboRemove.addItem((i));
			
				}
				comboRemove.setVisible(true);
				SaveBtn.setVisible(true);
				//manager.DeleteTrip(TripNo);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_1.setBackground(new Color(51, 0, 102));
		button_1.setBounds(325, 179, 225, 37);
		frmMyBusStation.getContentPane().add(button_1);
		
		Button button_2 = new Button("Display");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDisplayer.Display();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_2.setBackground(new Color(51, 0, 102));
		button_2.setBounds(325, 477, 225, 37);
		frmMyBusStation.getContentPane().add(button_2);
		
		Button button_3 = new Button("Add Vehicle");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewVehicleWindow window =new NewVehicleWindow();
				window.AddNewVehicle();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_3.setBackground(new Color(51, 0, 102));
		button_3.setBounds(325, 236, 225, 37);
		frmMyBusStation.getContentPane().add(button_3);
		
		JComboBox comboRemoveVeh = new JComboBox();
		comboRemoveVeh.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboRemoveVeh.setBounds(572, 311, 61, 25);
		frmMyBusStation.getContentPane().add(comboRemoveVeh);
		 comboRemoveVeh.setVisible(false);
			
		Button SaveVehi = new Button("Save");
		SaveVehi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String deleteVeh= comboRemoveVeh.getSelectedItem().toString();
				 manager.DeleteVehicle(deleteVeh);
				 JOptionPane.showMessageDialog(null, "Vehicle Successefully deleted");
				 comboRemoveVeh.setVisible(false);
				 SaveVehi.setVisible(false);	
			}
		});
		
		SaveVehi.setForeground(Color.WHITE);
		SaveVehi.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 17));
		SaveVehi.setBackground(new Color(51, 0, 102));
		SaveVehi.setBounds(638, 311, 70, 25);
		frmMyBusStation.getContentPane().add(SaveVehi);
		SaveVehi.setVisible(false);
		
		Button button_4 = new Button("Remove Vehicle");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					tripsmanagement.LoadVehicles();;
					for(int i=1;i<=tripsmanagement.getNumberOfVehicles();i++)
					{comboRemoveVeh.addItem(tripsmanagement.Vehicles[i].getLiscenceNumber());
					comboRemoveVeh.setVisible(true);
					SaveVehi.setVisible(true);
					}
			}
		});
		
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_4.setBackground(new Color(51, 0, 102));
		button_4.setBounds(329, 299, 218, 37);
		frmMyBusStation.getContentPane().add(button_4);
		
		Button button_6 = new Button("Add Driver");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewDriverWindow newdriver =new NewDriverWindow();
				newdriver.NewDriver();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_6.setBackground(new Color(51, 0, 102));
		button_6.setBounds(329, 358, 218, 37);
		frmMyBusStation.getContentPane().add(button_6);
		
		JComboBox comboRemoveDriver = new JComboBox();
		comboRemoveDriver.setBounds(572, 428, 61, 25);
		frmMyBusStation.getContentPane().add(comboRemoveDriver);
		
		Button SaveDriv = new Button("Save");
		SaveDriv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteDriv= comboRemoveDriver.getSelectedItem().toString();
				 manager.DeleteDriver(deleteDriv);
				 JOptionPane.showMessageDialog(null, "Driver Successefully deleted");
				 comboRemoveDriver.setVisible(false);
				 SaveDriv.setVisible(false);	
				
			}
		});
		SaveDriv.setForeground(Color.WHITE);
		SaveDriv.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 17));
		SaveDriv.setBackground(new Color(51, 0, 102));
		SaveDriv.setBounds(638, 428, 70, 25);
		frmMyBusStation.getContentPane().add(SaveDriv);
		SaveDriv.setVisible(false);
		comboRemoveDriver.setVisible(false);
		
		Button button_7 = new Button("Remove Driver");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tripsmanagement.LoadDrivers();;
				for(int i=1;i<=tripsmanagement.getDriverNumber();i++)
				{comboRemoveDriver.addItem(tripsmanagement.drivers[i].getIdNumber());
				comboRemoveDriver.setVisible(true);
				SaveDriv.setVisible(true);
				}
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Ebrima", Font.PLAIN, 17));
		button_7.setBackground(new Color(51, 0, 102));
		button_7.setBounds(329, 416, 218, 37);
		frmMyBusStation.getContentPane().add(button_7);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBackground(Color.WHITE);
		lblAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAdministrator.setForeground(new Color(153, 51, 153));
		lblAdministrator.setBounds(343, 39, 207, 37);
		frmMyBusStation.getContentPane().add(lblAdministrator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 26, 507, 68);
		frmMyBusStation.getContentPane().add(panel_1);
		

		

		

		
	
		frmMyBusStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
