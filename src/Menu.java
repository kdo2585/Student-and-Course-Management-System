/* Kevin Do
 * 
 * This is the menu that appears when the user logs in as an Admin.
 * There are two buttons, Student Information or Class Manager.
 * The buttons will bring up the respective UIs.
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu {
	private static JButton studentInfoButton = new JButton(); //student info button
	private static JButton classManagerButton = new JButton(); //class manager button
	
	public static void Menu() throws Exception {
		
		JFrame frame = new JFrame("Menu");

		//layout
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(200,16,46));
		
		//title of GUI
		createButton();

		//add buttons to panel
		panel.add(studentInfoButton);
		panel.add(classManagerButton);

		
		//set frame
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	private static void createButton() {

		//create button and set location for Student Information
		studentInfoButton.setText("Student Information");
		studentInfoButton.setPreferredSize(new Dimension(200, 40));
		studentInfoButton.setVerticalTextPosition(AbstractButton.CENTER);
		studentInfoButton.addActionListener(new ActionListener() 
		{
			//perform action on click
			public void actionPerformed(ActionEvent ae) {

					try {
						//open studentInformation.java
						studentInformation.studentInformation(); 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		//create button and set location for Manage Classes
		classManagerButton.setText("Manage Classes");
		classManagerButton.setPreferredSize(new Dimension(200, 40));
		classManagerButton.setVerticalTextPosition(AbstractButton.CENTER);
		classManagerButton.addActionListener(new ActionListener() 
		{
			//perform action on click
			public void actionPerformed(ActionEvent ae) {

					try {
						//open classManager.java
						ClassManager.ClassManager(); 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});

	}
}