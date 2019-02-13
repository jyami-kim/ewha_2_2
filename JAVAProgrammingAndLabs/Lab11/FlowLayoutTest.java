package Lab11;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest {
	public static void main(String args[]) {
		JFrame frame = new JFrame("FlowLayout Tests");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Button1");
		p1.add(b1);
		JButton b2 = new JButton("Button2");
		p1.add(b2);
		JButton b3 = new JButton("Button3");
		p1.add(b3);
		JButton b4 = new JButton("Button4");
		p1.add(b4);
		
		frame.add(p1);
		
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
	}
}
