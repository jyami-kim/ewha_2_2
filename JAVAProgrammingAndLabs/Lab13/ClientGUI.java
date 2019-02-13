package Lab13;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends Thread {
	public Socket clientSocket;
	public BufferedReader inFromServer;
	public BufferedReader inFromUser;
	public PrintWriter outToServer;
	
	public boolean sender_mode;
	public static boolean operation;
	public static boolean exist_data_to_send = false;

	public String inputLine, outputLine;
	
	public ClientGUI(Socket clientSocket, BufferedReader inFromServer) {
		this.clientSocket = clientSocket;
		this.inFromServer = inFromServer;
		sender_mode = false;
		operation = true;
		exist_data_to_send = false;
	}
	public ClientGUI(Socket clientSocket, PrintWriter outToServer) {
		this.clientSocket = clientSocket;
		this.outToServer = outToServer;
		sender_mode = true;
		operation = true;
		exist_data_to_send = false;
	}
	
	public void run() {
		if (sender_mode == true) {
			try {
				while (true) {
					outputLine = chatBox.getText();
					if (exist_data_to_send == true && outputLine.length() > 0) {
						chatArea.append("Client: " + outputLine+ '\n');
						outToServer.println(outputLine);
								
						chatBox.setText("");
						exist_data_to_send = false;
						
						if (outputLine.equals("Bye.")) {
							operation = false;
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							break;
						}
					}
					if (operation == false) {
						clientSocket.close();
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				while ((inputLine = inFromServer.readLine()) != null) {
					if (inputLine.length() > 0) {
						chatArea.append("Server: " + inputLine + '\n');
						
						if (inputLine.equals("Bye.")) {
							operation = false;
							clientSocket.close();
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							break;
						}
					}
					
					if (operation == false) {
						clientSocket.close();
						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static JFrame frame;
	public static JTextArea chatArea;
	public static JTextField chatBox;
	
	public static void drawChatWindow() {
		frame = new JFrame();
		JPanel p1 = new JPanel();
	    p1.setLayout(new FlowLayout());

	    chatArea = new JTextArea(10, 30);
	    chatArea.setText("=== Chat ===\n");
	    p1.add(chatArea);
	    
	    JPanel p2 = new JPanel();
	    p2.setLayout(new FlowLayout());
	    
	    chatBox = new JTextField(20);
	    p2.add(chatBox);
	    
	    JButton button1 = new JButton("Enter");
	    button1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
//	    		System.out.println("Button is pushed");
	    		exist_data_to_send = true;
	    	}
	    });
	    p2.add(button1);
	    
	    frame.setLayout(new BorderLayout());
	    frame.add(p1, BorderLayout.CENTER);
	    frame.add(p2, BorderLayout.SOUTH);
	    
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Chat Program: Client");
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("Usage: java ClientGUI <ip address> <port number>");
			System.exit(1);
		}
		
		drawChatWindow();
		
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		
		Socket clientSocket = new Socket(hostName, portNumber);
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
		
		ClientGUI sthread = new ClientGUI(clientSocket, outToServer);
		ClientGUI rthread = new ClientGUI(clientSocket, inFromServer);
		
		sthread.start();
		rthread.start();
	}
}
