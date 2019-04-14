import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class NewTripWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static void NewTrip() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTripWindow window = new NewTripWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NewTripWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 595, 502);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JComboBox vehicle_combobox = new JComboBox();
		vehicle_combobox.setBackground(Color.WHITE);
		vehicle_combobox.setModel(new DefaultComboBoxModel(new String[] {"", "Limousine", "Bus", "Minibus"}));
		vehicle_combobox.setToolTipText("");
		vehicle_combobox.setBounds(186, 99, 112, 20);
		frame.getContentPane().add(vehicle_combobox);
		
		JLabel lblNewLabel = new JLabel("Vehicle Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(40, 105, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox From_ComboBox = new JComboBox();
		From_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cairo", "Alexandria", "Hurghada", "SharmElsheikh", "Tanta", "Rashid", "MarsaMatrouh", "Luxor", "Dahab", "Libya", "Sudan"}));
		From_ComboBox.setBounds(186, 142, 112, 20);
		frame.getContentPane().add(From_ComboBox);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setBounds(40, 148, 112, 14);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTo.setForeground(Color.WHITE);
		lblTo.setBounds(40, 191, 112, 14);
		frame.getContentPane().add(lblTo);
		
		JComboBox To_ComboBox = new JComboBox();
		To_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cairo", "Alexandria", "Hurghada", "SharmElsheikh", "Tanta", "Rashid", "MarsaMatrouh", "Luxor", "Dahab", "Libya", "Sudan"}));
		To_ComboBox.setBounds(186, 185, 112, 20);
		frame.getContentPane().add(To_ComboBox);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(40, 277, 112, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(40, 366, 56, 17);
		frame.getContentPane().add(lblTime);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(40, 319, 112, 14);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(186, 271, 112, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(186, 313, 112, 20);
		frame.getContentPane().add(dateChooser);
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "6:00PM", "9:00AM"}));
		comboBox.setBounds(186, 366, 112, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox Flavor_ComboBox = new JComboBox();
		Flavor_ComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "NonStop", "One-Stop", "Two-Stops"}));
		Flavor_ComboBox.setBounds(186, 227, 112, 20);
		frame.getContentPane().add(Flavor_ComboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(153, 51, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			String type=	vehicle_combobox.getSelectedItem().toString();
			String from = From_ComboBox.getSelectedItem().toString();
			String to= To_ComboBox.getSelectedItem().toString();
			
			String date=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			String time=comboBox.getSelectedItem().toString();
			date  = date.replaceAll("\\s","");
			String TripType;
			String Flavor=Flavor_ComboBox.getSelectedItem().toString();
			if(type.equals("")||from.equals("")||to.equals("")||textField.getText().isEmpty()||date.isEmpty()||time.isEmpty())
			 JOptionPane.showMessageDialog(null, "Please Enter All Trip Info");
			else if (!isNumeric(textField.getText()))
			 JOptionPane.showMessageDialog(null,"Please enter Valid Price");
			else
			{	if(from=="Libya"||from=="Sudan"||to=="Libya"||to=="Sudan")
					TripType="External";
				else
					TripType="Internal";
			double price= Double.parseDouble(textField.getText());
			Manager manager=new Manager();
			manager.SetNewTrip(type, from, to, price, date, time,TripType, Flavor);
				}
			}
		});
		
		JLabel lblTripFlavor = new JLabel("Stops");
		lblTripFlavor.setForeground(Color.WHITE);
		lblTripFlavor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTripFlavor.setBounds(40, 236, 112, 14);
		frame.getContentPane().add(lblTripFlavor);
		btnNewButton.setBounds(306, 395, 102, 32);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 152, 502);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 204));
		panel_1.setBounds(109, 21, 526, 59);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Add New Trip");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBackground(new Color(153, 51, 255));
		btnClose.setBounds(450, 395, 102, 32);
		frame.getContentPane().add(btnClose);
	}
}
