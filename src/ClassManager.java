/* Kevin Do
 * 
 * This program appears when the Admin clicks on the 'Class Manager' button in the menu UI,
 * or when the Professor logs in. The text area display information from a file of some Computer
 * Science courses offered at GU. The user can edit this file and save it.
 * 
 */



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.* ;


public class ClassManager
{
	private static JFrame frame = new JFrame("Manage Classes"); //main frame
	private static String storeAllString=""; //string in text area
	private static JButton saveCloseBtn = new JButton("Save and Exit"); //save and quit button
    private static JButton closeButton = new JButton("Exit Without Saving"); //quit without saving button
	private static JTextArea txt = new JTextArea(); //text area
	
	public static void ClassManager()
    {
    	
		fileRead(); //reads file
		frame.setSize(1000, 700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);   
        createButtons(); //add buttons to UI
        createTextArea(); //add text area to UI
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
    }

    //read the txt file to place the text from file to text area.
    private static void fileRead(){
        try{    
          FileReader read = new FileReader("Courses.txt");
          Scanner scan = new Scanner(read);
             while(scan.hasNextLine()){
              String temp=scan.nextLine()+"\n";
              storeAllString = storeAllString+temp;
             }
             //set text to text area
             txt.setText(storeAllString);
      }
        catch (Exception exception)
         {
         exception.printStackTrace();
         }
    }  
    
    //creates the text area on the UI.
    private static void createTextArea() {
    	txt.setLineWrap(true);
    	txt.setSelectionStart(0);
    	txt.setSelectionEnd(0); 
        txt.setWrapStyleWord(true);
        JScrollPane scrollBarForTextArea = new JScrollPane(txt);
        scrollBarForTextArea.setBounds(25, 15, 925, 550);
        scrollBarForTextArea.getVerticalScrollBar().setValue(0);
        frame.add(scrollBarForTextArea);
    	
    }
    
    //creates two buttons on the UI.
    private static void createButtons() {
    	//Save and Close button will run saveAndQuit(), which will save the contents in the text area to Courses.txt and close the window
    	saveCloseBtn.setBounds(600, 600, 150, 40 );
        frame.add(saveCloseBtn);        
        saveCloseBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		saveAndQuit();
                frame.dispose();

            }
        });
        //Close button will not save changes made to text area, and simply closes the window.
        closeButton.setBounds(800, 600, 150, 40 );
        frame.add(closeButton);        
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

            }
        });
    }
    
    //save and quit option
    //rewrites whatever is in the text area to the file Courses.txt
    private static void saveAndQuit(){
        BufferedWriter out=null;
        String text = txt.getText();

        try {
        	out = new BufferedWriter(new FileWriter("Courses.txt"));
            
            out.write(text);
            out.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
  
}


    

