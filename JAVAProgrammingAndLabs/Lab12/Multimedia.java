package Lab12;

import javax.swing.*;

import java.applet.AudioClip;
import java.awt.*;
import java.net.URL;

public class Multimedia extends JApplet{

	
	public void init() {
		JPanel p1 = new JPanel();
		URL imgURL = getClass().getResource("abbado.jpg");
		
		System.out.println(imgURL);
		
		ImageIcon imageIcon = new ImageIcon(imgURL);
		int width = imageIcon.getImage().getWidth(null);
		int height = imageIcon.getImage().getHeight(null);
		double factor = 0.2; 
		
		Image image =imageIcon.getImage().getScaledInstance(
		((int)(width*factor)), ((int)(height*factor)),
		Image.SCALE_SMOOTH);
		
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		p1.add(imageLabel);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		
		URL soundURL = getClass().getResource("alarmSound.au");
		AudioClip audioClip = newAudioClip(soundURL);
		audioClip.play();
	}


}
