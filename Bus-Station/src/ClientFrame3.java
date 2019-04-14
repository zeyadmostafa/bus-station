import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame3 extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void ShowAvailable() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame3 frame = new ClientFrame3();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	TripsManagement tmanagment = new TripsManagement();
	ReservationProcess rProsses = new ReservationProcess() ;
	ReserveATripWindow frame1 = new ReserveATripWindow();
	public ClientFrame3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("CLOSE");
		button.setBounds(497, 304, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBackground(new Color(51, 0, 102));
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(-157, 0, 968, 36);
		panel.setBackground(new Color(204, 153, 255));
		contentPane.add(panel);
		
		JLabel label = new JLabel("AVAILABLE TRIPS");
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 57, 639, 230);
		contentPane.add(scrollPane);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	
		String from =(String) frame1.f;
		String to = (String) frame1.t;
		
		tmanagment.LoadFromFile();
		
		if (frame1.tripType.equals("Single Trip" )) {
			
		for ( int i = 0 ; i<=tmanagment.TripNumber;i++ ) {
			String destination = tmanagment.Trips[i].getDestination();
			String origin = tmanagment.Trips[i].getOrigin();
			if (from.equals(origin) && to.equals(destination)) {
				textArea.setText(textArea.getText()+"\n" +"TripNo: "+tmanagment.Trips[i].getTripNo()+ " From : "+from+" To : "+to+ " Price is :" +tmanagment.Trips[i].getPrice()+" " + tmanagment.Trips[i].getInternalExternal()+ " Date : "+tmanagment.Trips[i].getDate() + " "+ tmanagment.Trips[i].getTripFlavor()+" "+tmanagment.Trips[i].getTime() + " Driver ID : "+tmanagment.Trips[i].getDriverID());
			}
		}}
		else if (frame1.tripType.equals("Round Trip")) {
			for ( int i = 0 ; i<=tmanagment.TripNumber;i++ ) {
				if ((from.equals(tmanagment.Trips[i].getOrigin()) && to.equals(tmanagment.Trips[i].getDestination()))||(from.equals(tmanagment.Trips[i].getDestination())&&to.equals(tmanagment.Trips[i].getOrigin()))) {
					textArea.setText(textArea.getText()+ "\n" +" TripNo: "+tmanagment.Trips[i].getTripNo()+ "From : "+tmanagment.Trips[i].getOrigin()+" To : "+tmanagment.Trips[i].getDestination()+ " price is :" +tmanagment.Trips[i].getPrice()+" " + tmanagment.Trips[i].getInternalExternal()+ " Date : "+tmanagment.Trips[i].getDate() + " "+ tmanagment.Trips[i].getTripFlavor()+" "+tmanagment.Trips[i].getTime() + " Driver ID :"+tmanagment.Trips[i].getDriverID());// kamel henaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
				}
			}
		}
	}

}
