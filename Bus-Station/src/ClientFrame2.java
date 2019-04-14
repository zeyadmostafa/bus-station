import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame2 {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField mobileNumber;
	private JTextField ticketsNumber;

	/**
	 * Launch the application.
	 */
	public static void Frame2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame2 window = new ClientFrame2();
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
	ReservationProcess clients = new ReservationProcess();
	private JTextField textField;

	public ClientFrame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 479, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ClientFrame2.class.getResource("/images/Document.png")));
		label.setBounds(10, 111, 218, 231);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" Ticket");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(144, 11, 84, 31);
		frame.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(186, 85, 211));
		panel.setBackground(new Color(186, 85, 211));
		panel.setBounds(0, 0, 219, 488);
		frame.getContentPane().add(panel);
		
		JLabel label_2 = new JLabel("Reservation");
		label_2.setForeground(new Color(128, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(228, 13, 134, 26);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(225, 50, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(336, 50, 86, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(225, 78, 73, 14);
		frame.getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(336, 81, 86, 20);
		frame.getContentPane().add(lastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(225, 113, 84, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		mobileNumber = new JTextField();
		mobileNumber.setColumns(10);
		mobileNumber.setBounds(336, 111, 86, 20);
		frame.getContentPane().add(mobileNumber);
		
		JLabel lblNumberOfTickets = new JLabel("Number Of tickets");
		lblNumberOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfTickets.setBounds(225, 143, 111, 14);
		frame.getContentPane().add(lblNumberOfTickets);
		
		ticketsNumber = new JTextField();
		ticketsNumber.setColumns(10);
		ticketsNumber.setBounds(336, 141, 86, 20);
		frame.getContentPane().add(ticketsNumber);
		
		JButton btnNewButton = new JButton("Clear ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName.setText(null);
				lastName.setText(null);
				mobileNumber.setText(null);
				ticketsNumber.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(364, 202, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ClientFrame frame1 = new ClientFrame();
				ReserveATripWindow reserve=new ReserveATripWindow();
				String fName = firstName.getText();
				String lName = lastName.getText();
				String mobNumber = mobileNumber.getText();
				String x = ticketsNumber.getText();
		    	int numTickets =Integer.parseInt(x);
              if (reserve.tripType.equals("Single Trip")) {
				if (clients.isString(fName) && clients.isString(lName) && clients.isNumber(mobNumber) && numTickets<10 && numTickets>0 )
					{
						double tPrices=	clients.AddClientInfo(fName, lName, mobNumber, numTickets,reserve.tripno1); // returns price

						if (tPrices==-1) {
							JOptionPane.showMessageDialog(null, "sorry no availble seats , please choose another trip");
							frame.setVisible(false);
							reserve.ReserveWindow();    // how to open gui frame1
							}
						else {
							JOptionPane.showMessageDialog(null, "your Trip price is " + tPrices);
							frame.setVisible(false);
				}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "please enter valid info");
					firstName.setText(null);
					lastName.setText(null);
					mobileNumber.setText(null);
					ticketsNumber.setText(null);
				}
              }
              else if (reserve.tripType.equals("Round Trip")) {
            	  
            	  if (clients.isString(fName) && clients.isString(lName) && clients.isNumber(mobNumber) && numTickets<10 && numTickets>0) {
            		 double rPrices=	clients.RoundTrip(fName, lName, mobNumber, numTickets, reserve.tripno1,reserve.tripno2); 
      				
      				// returns price
      				if (rPrices==-1 ) {
      					JOptionPane.showMessageDialog(null, "sorry no availble seats , please choose another trip");
      					frame.setVisible(false);
      					reserve.ReserveWindow();
      				}
      				else {
      					JOptionPane.showMessageDialog(null, "your Trip price is " + rPrices);
      					frame.setVisible(false);
      				}
      				}
      				else {
      					JOptionPane.showMessageDialog(null, "please enter valied info");
      					firstName.setText(null);
      					lastName.setText(null);
      					mobileNumber.setText(null);
      					ticketsNumber.setText(null);
            	  
            	  
            	  
              }
				
			}
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
		}});
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBook.setBounds(247, 202, 89, 23);
		frame.getContentPane().add(btnBook);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBackground(new Color(204, 204, 204));
		textField.setEditable(false);
		textField.setBounds(238, 266, 212, 156);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(374, 437, 89, 23);
		frame.getContentPane().add(btnClose);
		
	}
}
