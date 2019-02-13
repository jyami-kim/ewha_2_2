package HW4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HW4 extends JApplet{
public static int numOfPro, numOfCon, unitOfCon, total; //save the input value of TextField in this variable
public static JTextArea textA1;	//to add text at Bakery, make static

	public void init() {
		JPanel p1 = new JPanel(); //input TextField's Panel
		p1.setLayout(new GridLayout(4,2)); //the Panel's format is grid 4X2
		
		JLabel label1 = new JLabel(" # of Producers: "); //information of first TextField
		p1.add(label1); // row 1 col 1
		JTextField field1 = new JTextField(10); // first TextField : number of Producers
		p1.add(field1); // row 1 col 2
		
		JLabel label2 = new JLabel(" # of Consumers: "); //information of first TextField
		p1.add(label2); // row 2 col 1
		JTextField field2 = new JTextField(10);  // second TextField : number of Consumers
		p1.add(field2); // row 2 col 2
		
		JLabel label3 = new JLabel(" Consumption Unit: "); //information of first TextField
		p1.add(label3); // row 3 col 1
		JTextField field3 = new JTextField(10); // Third TextField : Consumption Unit
		p1.add(field3); // row 3 col 2
		
		JLabel label4 = new JLabel(" Total #: "); //information of first TextField
		p1.add(label4); // row 4 col 1
		JTextField field4 = new JTextField(10); // Forth TextField : Total number of bread (the winning condition)
		p1.add(field4); // row 4 col 2
		
		JPanel p2 = new JPanel(); // button Panel
		JButton button = new JButton("Start"); //button init, the button value is Start
		p2.add(button); //the button is in panel
		
		JPanel p3 = new JPanel(); // TextArea Panel
		
		textA1 = new JTextArea(10,30); //set TextArea. size is in the bracket 
		textA1.setText("[HW4 : minjeongkim]"); //setting message in this area, before user typing, 
		JScrollPane scroll = new JScrollPane(textA1);
		p3.add(scroll); //the textArea is in panel
		
		add(p1,BorderLayout.WEST); // set the panel1's location left
		add(p2,BorderLayout.SOUTH); // set the panel2's location right
		add(p3,BorderLayout.EAST); // set the panel3's location bottom
		
		button.addActionListener(new ActionListener(){ //set event listener //if the button click, this event occur
			public void actionPerformed(ActionEvent e) { //when the button click, execute this method
				numOfPro = Integer.parseInt(field1.getText()); //since this value is widely used in other classes, be settled by class variable.
				numOfCon = Integer.parseInt(field2.getText()); //since this value is widely used in other classes, be settled by class variable.
				unitOfCon = Integer.parseInt(field3.getText()); //since this value is widely used in other classes, be settled by class variable.
				total = Integer.parseInt(field4.getText()); //since this value is widely used in other classes, be settled by class variable.
				
				Bakery bObj = new Bakery(); //since the simulation occurred by one bakery, the bakery object is only one.
				for(int i=1; i<=numOfPro; i++) { // generate producer objects by numOfPro value
					Producer pObj = new Producer(bObj,i); //Producer object construct
					pObj.start(); //producer object's thread is started (the tread method run() execute)
				}
				for(int i=1; i<=numOfCon; i++) { // generate consumer objects by numOfCon value
					Consumer cObj = new Consumer(bObj,i); //Consumer object construct
					cObj.start(); //consumer object's thread is started (the tread method run() execute)
				}
			}
		});	
	}
}
