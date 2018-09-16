/* Kevin Do
 * 
 * This is the main login. There are two textfields for the username and password, a login button, 
 * and an option to login as 'Admin' or 'Professor'. The program will check whether or not 'Admin'
 * or 'Professor' is selected and determine if the username and password is correct before logging
 * in the user. If the username and password are incorrect, a pop up will let them know it's wrong.
 * Logging in as Admin will bring up a menu with two buttons that either brings up the Student 
 * Information UI or the Class Manager UI. While logging in as Professor will bring up the Class
 * Manager UI.
 * 
 * Currently, the username and password 'Admin' is: 
 * username: Gonzaga
 * password: 12345
 * 
 * the username and password 'Professor' is: 
 * username: Bulldogs
 * password: 67890
 * 
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class Main {

    private static String[] selection = {"Admin", "Professor"}; //for combo box. allows user to select if they want to log in as 'Admin' or 'Professor'
    
    //main
    public static void main(String[] args) throws IOException {
		//set UI
    	JFrame frame = new JFrame("Student and Course Manager");
		frame.setSize(661, 433);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(4,30,66));
		
		frame.add(panel);
		
		//places components to UI
		placeComponents(panel);
		

		frame.setVisible(true);
	}

    //places labels, text area, combo box, and login button for UI
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		//username label
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(10, 260, 80, 25);
		userLabel.setForeground(Color.white);
		userLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(userLabel);

		//username text area
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 260, 160, 25);
		panel.add(userText);

		//password label
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 290, 80, 25);
		passwordLabel.setForeground(Color.white);
		passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(passwordLabel);

		//password text area
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 290, 160, 25);
		panel.add(passwordText);

		//login button
		JButton loginButton = new JButton("login");
		loginButton.setBounds(280, 260, 70, 55);
		panel.add(loginButton);
		
		//combo box
		JComboBox<Object> cb=new JComboBox<Object>(selection); 
		cb.setBounds(100, 330, 90,20);
		panel.add(cb);

		//login button action
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) {
				String username = userText.getText(); //gets username from text area
				String password = passwordText.getText(); //gets password from text area
				
				//'Admin' login.
				//opens up Menu.java
				if(username.equals("Gonzaga") && password.equals("12345") && cb.getSelectedItem().equals("Admin")) {

					try {

						Menu.Menu(); 
					} catch (Exception e) {

						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//'Professor' log in.
				//opens to classManager.java
				else if(username.equals("Bulldogs") && password.equals("67890") && cb.getSelectedItem().equals("Professor")) { 
					try {
						ClassManager.ClassManager();  
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 

				//if the username and password is incorrect
				else {
					JOptionPane.showMessageDialog(null,"Wrong Username/Password");
					userText.setText("");
					passwordText.setText("");
					userText.requestFocus();
				}
				
				
				

			}

		});
		
		//login label
		JLabel loginLabel = new JLabel("Login as: ");
		loginLabel.setBounds(10, 325, 80, 25);
		loginLabel.setForeground(Color.white);
		loginLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		panel.add(loginLabel);
		
		 
		
	}

}
