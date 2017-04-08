package mainpack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

class AuthForm extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthForm frame = new AuthForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AuthForm(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextField loginField = GenerateItems.CreateTField(contentPane, "",101, 74, 118, 20);
		JTextField passwordField = GenerateItems.CreateTField(contentPane, "",101, 105, 118, 20);
		JLabel labelMessages = GenerateItems.CreateLabel(contentPane, "", 31, 55, 188, 14);
		JLabel labelAuth = GenerateItems.CreateLabel(contentPane, "Auth", 31, 30, 188, 14);
		JLabel labelLogin = GenerateItems.CreateLabel(contentPane, "Login", 31, 77, 60, 14);
		JLabel labelPassword = GenerateItems.CreateLabel(contentPane, "Password", 31, 108, 60, 14);
		ActionListener ExitButListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener,contentPane, "Exit", 130, 136, 89, 23);
		ActionListener AuthButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (loginField.getText().equals("1") && passwordField.getText().equals("1")) 
				{ 
				FirstForm fr1 = new FirstForm(1);
				fr1.setVisible(true); 
				}
			else if (loginField.getText().equals("2") && passwordField.getText().equals("2")) 
				{ 
				FirstForm fr1 = new FirstForm(2);
				fr1.setVisible(true); 
				}
			else
				{
				labelMessages.setText("Invalid data.");
				}
			dispose();
			}
		};
		JButton buttonAuth = GenerateItems.CreateButton(AuthButListener, contentPane, "Auth", 31, 136, 89, 23);
	}
}