/* Kevin Do
 * 
 * This program appears when the Admin clicks on the 'Student Information' button in the menu UI.
 * This allows the Admin to add a student to the student database. However, it does not save the
 * student in the database. There is already a set list of students in the loadStudents.java file.
 * The UI takes in the students first name, middle initial, last name, date of birth, student ID 
 * number, field of study (department), and GPA. There are buttons to add the student to the table,
 * clear the text field, save the table to a text file, or load the pre existing list of students.
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class studentInformation {
	
	private static JTextField firstNameText; //student's first name
	private static JTextField middleInitialText; //student's middle initial
	private static JTextField lastNameText; //student's last name
	private static JFormattedTextField dateofBirthText; //student's date of birth
	private static JFormattedTextField studentIDText; //student ID
	private static JTextField departmentText; //student's major
	private static JTextField cumulativeGPAText; //student's GPA

	public static void studentInformation() throws Exception {

		JFrame frame = new JFrame("Student Information");
	    DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    JPanel panel = new JPanel();
	    
	    //add table to UI
	    frame.add(new JScrollPane(table),BorderLayout.EAST);

		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(26, 220, 242));
		
		//adds text area to UI
		placeComponents(panel,table,model);
		//adds buttons to UI
		addButtons(panel,table,model);

		//set frame
		frame.add(panel);

		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	//this function places the student information components to UI
	private static void placeComponents(JPanel panel,JTable table,DefaultTableModel model) throws Exception {
		panel.setLayout(null);

		//add table rows with labels
	    model.addColumn("First Name");
	    model.addColumn("Middle Initial");
	    model.addColumn("Last Name");
	    model.addColumn("Date of Birth");
	    model.addColumn("Student ID");
	    model.addColumn("Department");
	    model.addColumn("GPA");
    
	    //makes sure that the user types valid date, student ID, and gpa
		MaskFormatter dateMask = new MaskFormatter("##/##/####");
		MaskFormatter studentIDmask = new MaskFormatter("########");
		MaskFormatter GPAMask = new MaskFormatter("#.##");
		
		//student information title
		JLabel title = new JLabel("Student Information:");
		title.setBounds(10, 20, 150, 25);
		panel.add(title);

		//first name label
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(10, 70, 100, 25);
		panel.add(firstName);

		//first name text area
		firstNameText = new JTextField(20);
		firstNameText.setBounds(120, 70, 160, 25);
		panel.add(firstNameText);

		//middle initial label
		JLabel middleInitial = new JLabel("Middle Initial");
		middleInitial.setBounds(10, 105, 100, 25);
		panel.add(middleInitial);

		//middle initial text area
		middleInitialText = new JTextField(20);
		middleInitialText.setBounds(120, 105, 160, 25);
		panel.add(middleInitialText);

		//last name label
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(10, 140, 100, 25);
		panel.add(lastName);

		//last name text area
		lastNameText = new JTextField(20);
		lastNameText.setBounds(120, 140, 160, 25);
		panel.add(lastNameText);

		//date of birth label
		JLabel dateofBirth = new JLabel("Date Of Birth");
		dateofBirth.setBounds(10, 175, 100, 25);
		panel.add(dateofBirth);

		//date of birth text area
		dateofBirthText = new JFormattedTextField(dateMask);
		dateofBirthText.setBounds(120, 175, 160, 25);
		panel.add(dateofBirthText);

		//student ID label
		JLabel studentID = new JLabel("Student ID");
		studentID.setBounds(10, 210, 100, 25);
		panel.add(studentID);

		//student ID text area
		studentIDText = new JFormattedTextField(studentIDmask);
		studentIDText.setBounds(120, 210, 160, 25);
		panel.add(studentIDText);

		//department label
		JLabel department = new JLabel("Department");
		department.setBounds(10, 245, 100, 25);
		panel.add(department);

		//department text area
		departmentText = new JTextField(20);
		departmentText.setBounds(120, 245, 160, 25);
		panel.add(departmentText);

		//GPA label
		JLabel cumulativeGPA = new JLabel("Cumulative GPA");
		cumulativeGPA.setBounds(10, 280, 100, 25);
		panel.add(cumulativeGPA);

		//GPA text area
		cumulativeGPAText = new JFormattedTextField(GPAMask);
		cumulativeGPAText.setBounds(120, 280, 160, 25);
		panel.add(cumulativeGPAText);		
	}
	
	//this function add buttons to the UI (add, save, load, clear buttons)
	private static void addButtons(JPanel panel,JTable table,DefaultTableModel model) throws Exception {
	
		//adds student info to the table.
		//if a text area is empty, a prompt will ask the user to fill all information.
		//if all information was inputed, it will add it to the table, and clear the text field for the next student to be added.		
		JButton addButton = new JButton("Add Student");
		addButton.setBounds(10, 335, 125, 25);
		panel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                //if any of the text area is empty, prompt the user to input the student's information again.
				if((firstNameText.getText().trim().length() == 0) || (middleInitialText.getText().trim().length() == 0) ||  
                		(lastNameText.getText().trim().length() == 0) ||  (dateofBirthText.getText().trim().length() == 0) ||  
                		(studentIDText.getText().trim().length() == 0) || (departmentText.getText().trim().length() == 0) ||  
                		(cumulativeGPAText.getText().trim().length() == 0))
                {
                	JOptionPane.showMessageDialog(null,"Please fill in all information");
                	firstNameText.setText("");
                	middleInitialText.setText("");
                	lastNameText.setText("");
                	dateofBirthText.setText("");
                	studentIDText.setText("");
                	departmentText.setText("");
                	cumulativeGPAText.setText("");
                }
				//adds student information to the table, and clears the text area.
                else if (JOptionPane.showConfirmDialog(null, "Would you like to add these field to table?", "Request", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                {
                	model.addRow(new Object[] {firstNameText.getText(), middleInitialText.getText(), 
                			lastNameText.getText(), dateofBirthText.getText(), studentIDText.getText(), 
                			departmentText.getText(), cumulativeGPAText.getText()});
                	firstNameText.setText("");
                	middleInitialText.setText("");
                	lastNameText.setText("");
                	dateofBirthText.setText("");
                	studentIDText.setText("");
                	departmentText.setText("");
                	cumulativeGPAText.setText("");
                	}
                }
			});
		
		//save the student information table to a file
		//a save file UI will pop up for the user to save the txt file in any location.
		JButton saveButton = new JButton("Save Table");
		saveButton.setBounds(10, 375, 125, 25);
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                 
                JFileChooser filesave = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT File", ".txt", "text");
                filesave.setFileFilter(filter);
                int returnVal = filesave.showSaveDialog(panel);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                	try {  
                		File file = filesave.getSelectedFile();
                		PrintWriter os = new PrintWriter(file +".txt");
                		for (int row = 0; row < table.getRowCount(); row++) {
                			for (int col = 0; col < table.getColumnCount(); col++) {
                				os.println(table.getValueAt(row, col));                                
                            }
                			os.println("");
                        }
                		os.close();
                	} catch (IOException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	}
                }
            }
        });
		
		//clears the text area
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(150, 335, 125, 25);
		panel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 //asks the user if they want to clear the field.
				 if (JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the field?", "Request", 
	                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
	             {

					 firstNameText.setText("");
	                 middleInitialText.setText("");
	                 lastNameText.setText("");
	                 dateofBirthText.setText("");
	                 studentIDText.setText("");
	                 departmentText.setText("");
	                 cumulativeGPAText.setText("");
	                 
	             }
			 }
		});

		//load the pre existing students from loadstudents.java
		JButton loadButton = new JButton("Load Table");
		loadButton.setBounds(150, 375, 125, 25);
		panel.add(loadButton);
		loadButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
                 loadStudents.authenticate(model);		 	 
			 }
		});
		
	}
	
}