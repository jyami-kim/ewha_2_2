package Lab11;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
	public static void main(String args[]) {
		JFrame frame = new JFrame("BorderLayout Test");
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("Button1");
		p.add(b1, BorderLayout.NORTH);
		JButton b2 = new JButton("Button2");
		p.add(b2, BorderLayout.WEST);
		JButton b3 = new JButton("Button3");
		p.add(b3, BorderLayout.EAST);
		JButton b4 = new JButton("Button4");
		p.add(b4, BorderLayout.SOUTH);
		JButton b5 = new JButton("Button5");
		p.add(b5, BorderLayout.CENTER);
		
		frame.add(p);
		
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		
	}
}
