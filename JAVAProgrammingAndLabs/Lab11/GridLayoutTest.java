package Lab11;

import java.awt.*;
import javax.swing.*;

public class GridLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout Test");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,2));
		
		JButton button1 = new JButton("Button 1");
		p.add(button1);
		JButton button2 = new JButton("Button 2");
		p.add(button2);
		JButton button3 = new JButton("Button 3");
		p.add(button3);
		JButton button4 = new JButton("Button 4");
		p.add(button4);
		
		frame.add(p);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
