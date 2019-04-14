import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewVehicleWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void AddNewVehicle() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewVehicleWindow frame = new NewVehicleWindow();
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
	public NewVehicleWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 245);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Vehicle Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 78, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLiscenceNumber = new JLabel("Liscence Number");
		lblLiscenceNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLiscenceNumber.setForeground(Color.WHITE);
		lblLiscenceNumber.setBounds(10, 121, 120, 14);
		contentPane.add(lblLiscenceNumber);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Bus", "Minibus", "Limousine"}));
		comboBox.setBounds(158, 77, 138, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(159, 120, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=comboBox.getSelectedItem().toString();
				String Liscence=textField.getText();
				if(type.equals("")||Liscence.isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter all info to proceed");
				else {
				Manager manager=new Manager();
				manager.SetNewVehicle(type, Liscence);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(153, 0, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(269, 183, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBackground(new Color(153, 0, 255));
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(385, 183, 89, 23);
		contentPane.add(btnClose);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, -38, 148, 359);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 204));
		panel_1.setBounds(34, 11, 600, 40);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Add New Vehicle");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	}

}
