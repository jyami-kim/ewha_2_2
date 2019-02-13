package Lab11;

import javax.swing.*;
import java.awt.*;

public class MixedLayoutExample {
	public static void main(String args[]) {
		JFrame frame = new JFrame("MixedLayout Test");
		frame.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		
		JButton b1 = new JButton("Button1");
		p1.add(b1);
		JButton b2 = new JButton("Button2");
		p1.add(b2);
		
		JPanel p2 =new JPanel();
		p2.setLayout(new FlowLayout());
		
		JButton b3 = new JButton("Button3");
		p2.add(b3);
		JButton b4 = new JButton("Button4");
		p2.add(b4);
		
		frame.add(p1, BorderLayout.NORTH);
		frame.add(p2, BorderLayout.CENTER);
		
		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
