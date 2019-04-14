import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.nio.channels.NetworkChannel;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class WelcomePage {

	private JFrame frmBusStation;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frmBusStation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		 frmBusStation = new JFrame();
		 frmBusStation.setTitle("Bus Station");
		 frmBusStation.setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomePage.class.getResource("/images/2000px-BUS-Logo-BVG.svg.png")));
		 frmBusStation.getContentPane().setBackground(Color.BLACK);
		frmBusStation.setResizable(false);
		frmBusStation.setBounds(100, 100, 711, 421);
		frmBusStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusStation.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" The Bus Station");
		lblNewLabel.setForeground(new Color(51, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setBounds(285, 11, 410, 48);
		frmBusStation.getContentPane().add(lblNewLabel);
		
		JButton btnCancelReservation = new JButton("Cancel Reservation");
		btnCancelReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelReservationWindow cancel=new CancelReservationWindow();
				cancel.CancelReservationWindow();
			}
		});
		btnCancelReservation.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelReservation.setBackground(new Color(204, 204, 255));
		btnCancelReservation.setBounds(444, 203, 234, 30);
		frmBusStation.getContentPane().add(btnCancelReservation);
		
		JButton btnNewButton = new JButton("Reserve Trip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ClientFrame clientframe=new ClientFrame();
				//clientframe.ReserveTripFrame();
				ReserveATripWindow reserve=new ReserveATripWindow();
				reserve.ReserveWindow();
			}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(444, 151, 234, 30);
		frmBusStation.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeAboard = new JLabel("welcome Aboard");
		lblWelcomeAboard.setForeground(new Color(102, 51, 153));
		lblWelcomeAboard.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblWelcomeAboard.setBounds(364, 59, 331, 58);
		frmBusStation.getContentPane().add(lblWelcomeAboard);
		
		JLabel lblNewLabel_1 = new JLabel("Adminstration ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(459, 305, 149, 30);
		frmBusStation.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password ");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(459, 346, 71, 14);
		frmBusStation.getContentPane().add(lblNewLabel_2);
		
		JButton passbottom = new JButton("GO");
		passbottom.setForeground(new Color(255, 255, 255));
		passbottom.setBackground(new Color(102, 0, 204));
		passbottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (passwordField.getText().equals("1234")) {
					ManagerLoginWindow manager=new ManagerLoginWindow();
					manager.LoginPage();
					frmBusStation.setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "INVALID PASSWORD");
				}
				
			}
		});
		passbottom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		passbottom.setBounds(638, 338, 57, 30);
		frmBusStation.getContentPane().add(passbottom);
		
		passwordField = new JPasswordField(1234);
	
		passwordField.setBounds(532, 345, 96, 20);
		frmBusStation.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WelcomePage.class.getResource("/images/photo-booth-bus-rental-utah-background-767x407.jpg")));
		label.setBackground(Color.BLACK);
	//	label.setIcon(new ImageIcon(FirstFrame.class.getResource("/images/aa.PNG")));
		label.setBounds(-44, -77, 810, 530);
		frmBusStation.getContentPane().add(label);
	}
}
