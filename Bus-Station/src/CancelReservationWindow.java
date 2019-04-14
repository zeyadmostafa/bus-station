import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;

public class CancelReservationWindow {

	private JFrame frame;

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
	
	public static void CancelReservationWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelReservationWindow window = new CancelReservationWindow();
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
	public CancelReservationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 102, 102));
		frame.setBounds(100, 100, 571, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea MobNumBtn = new JTextArea();
		MobNumBtn.setBounds(242, 94, 112, 22);
		frame.getContentPane().add(MobNumBtn);
		
		JTextArea TripNoBtn = new JTextArea();
		TripNoBtn.setBounds(242, 135, 112, 22);
		frame.getContentPane().add(TripNoBtn);
		
		JTextArea TicketsBtn = new JTextArea();
		TicketsBtn.setBounds(242, 174, 112, 22);
		frame.getContentPane().add(TicketsBtn);
		
		JButton SaveBtn = new JButton("Save");
		SaveBtn.setBackground(new Color(204, 204, 255));
		SaveBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String Mobile=MobNumBtn.getText();
			
				if(Mobile.isEmpty()||TripNoBtn.getText().isEmpty()||TicketsBtn.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Please Enter All Info");
				else {	int TripNumber=Integer.parseInt(TripNoBtn.getText());
				int NumberOfTickets=Integer.parseInt(TicketsBtn.getText());
				ReservationProcess Reserve=new ReservationProcess();
				Reserve.CancelReservation(Mobile, TripNumber, NumberOfTickets);}
			}
		});
		SaveBtn.setBounds(216, 328, 138, 40);
		frame.getContentPane().add(SaveBtn);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 221, 476, 96);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton DisplayBtn = new JButton("Display Trips");
		DisplayBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		DisplayBtn.setBackground(new Color(204, 204, 255));
		DisplayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				ReservationProcess reserve=new ReservationProcess();
				reserve.LoadToFile();
				String Mobile=MobNumBtn.getText();
			
				if(Mobile.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter your mobile number and trip number");
				}
				else if(!isNumeric(Mobile))
					JOptionPane.showMessageDialog(null,"Please enter a valid mobile number");
				else
				{	
				for(int i=0;i<reserve.clientsArray.size();i++)
				{	
					if(reserve.clientsArray.get(i).getMobileNumber().equals(Mobile))
						{
						textArea.setText(textArea.getText()+"\n"+"Name: "+reserve.clientsArray.get(i).getFirstName()+" "+reserve.clientsArray.get(i).getLastName()+" Trip Number: "+reserve.clientsArray.get(i).getTripNo()+" Number Of Tickets: "+reserve.clientsArray.get(i).getNumberOfTickets());
				}
				}
				if (textArea.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No trips with this number");
			}
			}
		});
		DisplayBtn.setBounds(60, 329, 138, 40);
		frame.getContentPane().add(DisplayBtn);
		
		JLabel lblNewLabel = new JLabel("Mobile Number:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(120, 94, 112, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTripNumber = new JLabel("Trip Number:");
		lblTripNumber.setForeground(Color.WHITE);
		lblTripNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTripNumber.setBounds(120, 135, 112, 22);
		frame.getContentPane().add(lblTripNumber);
		
		JLabel lblNumberOfTickets = new JLabel("Returned Tickets:");
		lblNumberOfTickets.setForeground(Color.WHITE);
		lblNumberOfTickets.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfTickets.setBounds(110, 173, 122, 22);
		frame.getContentPane().add(lblNumberOfTickets);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, -23, 42, 460);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Cancel Reservation");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(152, 22, 273, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 11, 582, 50);
		frame.getContentPane().add(panel_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClose.setBackground(new Color(204, 204, 255));
		btnClose.setBounds(372, 328, 138, 40);
		frame.getContentPane().add(btnClose);
	}
}
