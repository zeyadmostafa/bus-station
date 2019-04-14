import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewDriverWindow extends JFrame {

	private JPanel MainPanel;
	private JTextField firstnametext;
	private JTextField lastnnametext;
	private JTextField id_textfield;
	private JTextField salarytextfield;

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
	
	public static void NewDriver() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					NewDriverWindow frame = new NewDriverWindow();
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
	public NewDriverWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 301);
		MainPanel = new JPanel();
		MainPanel.setBackground(Color.BLACK);
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 71, 89, 24);
		MainPanel.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 114, 89, 24);
		MainPanel.add(lblLastName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(10, 159, 89, 24);
		MainPanel.add(lblId);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setForeground(new Color(255, 255, 255));
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setBounds(10, 202, 89, 24);
		MainPanel.add(lblSalary);
		
		firstnametext = new JTextField();
		firstnametext.setBounds(115, 75, 109, 20);
		MainPanel.add(firstnametext);
		firstnametext.setColumns(10);
		
		lastnnametext = new JTextField();
		lastnnametext.setColumns(10);
		lastnnametext.setBounds(115, 118, 109, 20);
		MainPanel.add(lastnnametext);
		
		id_textfield = new JTextField();
		id_textfield.setColumns(10);
		id_textfield.setBounds(115, 163, 109, 20);
		MainPanel.add(id_textfield);
		
		salarytextfield = new JTextField();
		salarytextfield.setColumns(10);
		salarytextfield.setBounds(115, 206, 109, 20);
		MainPanel.add(salarytextfield);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first=firstnametext.getText();
				String last=lastnnametext.getText();
			Double salary = null;
			try {
				salary = Double.parseDouble(salarytextfield.getText());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Enter Valid Salary");
				//e1.printStackTrace();
			}
				String ID=id_textfield.getText();
				if(id_textfield.getText().isEmpty()||first.isEmpty()||last.isEmpty()||salarytextfield.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please Enter Valid Inputs");
				else if(!isNumeric(ID))
					JOptionPane.showMessageDialog(null, "Please Enter  A Valid ID");
				else {
				Manager manager=new Manager();
				try {
					manager.addNewDriver(first, last, salary, ID);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
				}
			}
		});
		btnNewButton.setBackground(new Color(102, 0, 204));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(251, 239, 89, 23);
		MainPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(102, 0, 204));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(350, 239, 89, 23);
		MainPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Add New Driver");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(160, 21, 165, 20);
		MainPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(-23, -47, 122, 376);
		MainPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 204));
		panel_1.setBounds(-82, 11, 646, 38);
		MainPanel.add(panel_1);
	}

}
