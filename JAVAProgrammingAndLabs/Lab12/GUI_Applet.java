package Lab12;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI_Applet extends JApplet{

	public void init() {
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,2));
		
		JLabel label1 = new JLabel("# of Producers: ");
		p1.add(label1);
		JTextField field1 = new JTextField(10);
		p1.add(field1);
		
		JLabel label2 = new JLabel("# of Consumers: ");
		p1.add(label2);
		JTextField field2 = new JTextField(10);
		p1.add(field2);
		
		JLabel label3 = new JLabel("Consumption Unit: ");
		p1.add(label3);
		JTextField field3 = new JTextField(10);
		p1.add(field3);
		
		JLabel label4 = new JLabel("Total #: ");
		p1.add(label4);
		JTextField field4 = new JTextField(10);
		p1.add(field4);
		
		JButton button = new JButton("Start");
		
		JTextArea TA = new JTextArea(10,20);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				TA.setText("===output==="
						+ "\n x = "+ field1.getText()
						+ "\n y = "+ field2.getText()
						+ "\n m = "+ field3.getText()
						+ "\n n = "+ field4.getText());
			}
		});
		
		
		add(p1, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(TA, BorderLayout.EAST);
		
		
		

	}

}
