import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ReserveATripWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ReserveWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveATripWindow window = new ReserveATripWindow();
					window.frame.setUndecorated(true);
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
	public static String t ;
	public static String f;
	public static String tripType;
	public static int tripno1;
	public static int tripno2;
	private JTextField textField;
	private JTextField textField_1;
	
	public ReserveATripWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 540, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBackground(Color.BLACK);
		lblFrom.setBounds(156, 81, 46, 14);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBackground(Color.BLACK);
		lblTo.setBounds(156, 113, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JComboBox fromCombo = new JComboBox();
		fromCombo.setModel(new DefaultComboBoxModel(new String[] {"", "Cairo", "Alexandria", "Hurghada", "SharmElsheikh", "Tanta", "Rashid", "MarsaMatrouh", "Luxor", "Dahab", "Libya", "Sudan"}));
		fromCombo.setBounds(238, 79, 107, 20);
		frame.getContentPane().add(fromCombo);
		
		JComboBox toCombo = new JComboBox();
		toCombo.setModel(new DefaultComboBoxModel(new String[] {"", "Cairo", "Alexandria", "Hurghada", "SharmElsheikh", "Tanta", "Rashid", "MarsaMatrouh", "Luxor", "Dahab", "Libya", "Sudan"}));
		toCombo.setBounds(238, 111, 107, 20);
		frame.getContentPane().add(toCombo);
		
		JLabel lblTripType = new JLabel("Trip Type:");
		lblTripType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTripType.setBackground(Color.BLACK);
		lblTripType.setBounds(134, 144, 68, 14);
		frame.getContentPane().add(lblTripType);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Single Trip", "Round Trip"}));
		comboBox_2.setBounds(238, 142, 107, 20);
		frame.getContentPane().add(comboBox_2);
		
	
		JLabel lblTripno = new JLabel("Trip No 1:");
		lblTripno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTripno.setBackground(Color.BLACK);
		lblTripno.setBounds(143, 220, 59, 14);
		frame.getContentPane().add(lblTripno);
		lblTripno.setVisible(false);
		
		JLabel lblTripNo = new JLabel("Trip No 2:");
		lblTripNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTripNo.setBackground(Color.BLACK);
		lblTripNo.setBounds(143, 254, 59, 14);
		frame.getContentPane().add(lblTripNo);
		lblTripNo.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(259, 218, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 252, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setVisible(false);
		
		JButton btnProceedYourBooking = new JButton("Proceed Your Booking");
		btnProceedYourBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(tripType.equals("Single Trip")) {
					if(textField.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Please enter TripNo");
					else {
					tripno1=Integer.parseInt(textField.getText());
					ClientFrame2 frame2=new ClientFrame2();
					frame2.Frame2();
					}
				}
				else if(tripType.equals("Round Trip"))
				{ if(textField.getText().isEmpty()||textField_1.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter trip number");
				else {
					tripno1=Integer.parseInt(textField.getText());
					tripno2=Integer.parseInt(textField_1.getText());	
					ClientFrame2 frame2=new ClientFrame2();
					frame2.Frame2();
				}
				}
			
			}
		});
		btnProceedYourBooking.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProceedYourBooking.setBackground(new Color(204, 204, 255));
		btnProceedYourBooking.setBounds(144, 300, 225, 23);
		btnProceedYourBooking.setVisible(false);
		frame.getContentPane().add(btnProceedYourBooking);
		
		
		JButton btnNewButton = new JButton("View Available Trips");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 t =  toCombo.getSelectedItem().toString();
				 f = fromCombo.getSelectedItem().toString();
				 tripType=comboBox_2.getSelectedItem().toString();
				 if(t.equals("")||f.equals("")||tripType.equals(""))
					 JOptionPane.showMessageDialog(null, "Please enter all info first");
				 else {
					 if(tripType.equals("Single Trip"))
					 {
					 lblTripno.setVisible(true);
					 textField.setVisible(true);
					 btnProceedYourBooking.setVisible(true);
					 }
					 else if (tripType.equals("Round Trip"))
					 {
					 lblTripno.setVisible(true);
					 lblTripNo.setVisible(true);
					 textField_1.setVisible(true);
					 textField.setVisible(true);
					 btnProceedYourBooking.setVisible(true);
					 }
						ClientFrame3 view = new ClientFrame3();
						view.ShowAvailable();
				 		}
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setBounds(144, 178, 225, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Search For Trip");
		lblNewLabel.setBounds(167, 25, 137, 22);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(-19, 11, 555, 49);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(425, 301, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	
	}
}
