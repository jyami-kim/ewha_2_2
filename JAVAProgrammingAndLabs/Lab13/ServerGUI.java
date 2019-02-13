package Lab13;

import java.net.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ServerGUI extends Thread {
	public Socket connectionSocket;
	public BufferedReader inFromClient;
	public BufferedReader inFromUser;
	public PrintWriter outToClient;
	
	public boolean sender_mode;
	public static boolean operation;
	public static boolean exist_data_to_send = false;
	
	public String inputLine, outputLine;
	
	public ServerGUI(Socket connectionSocket, BufferedReader inFromClient) {
		this.connectionSocket = connectionSocket;
		this.inFromClient = inFromClient;
		sender_mode = false;
		operation = true;
		exist_data_to_send = false;
	}
	public ServerGUI(Socket connectionSocket, PrintWriter outToClient) {
		this.connectionSocket = connectionSocket;
		this.outToClient = outToClient;
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
						chatArea.append("Server: " + outputLine+ '\n');
						outToClient.println(outputLine);
						
						chatBox.setText("");
						exist_data_to_send = false;
						
						if (outputLine.equals("Bye.")) {
							operation = false;
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							break;
						}
					}
					if (operation == false) {
						connectionSocket.close();
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
				while ((inputLine = inFromClient.readLine()) != null) {
					if (inputLine.length() > 0) {
						chatArea.append("Client: " + inputLine + '\n');
						
						if (inputLine.equals("Bye.")) {
							operation = false;
							connectionSocket.close();
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							break;
						}
					}
					
					if (operation == false) {
						connectionSocket.close();
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
	    frame.setTitle("Chat Program: Server");
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err.println("Usage: java ChatServer <port number>");
			System.exit(1);
		}
		
		drawChatWindow(); //infromUser가 없어졌다!
		
		int portNumber = Integer.parseInt(args[0]);
		
		ServerSocket welcomeSocket = new ServerSocket(portNumber);
		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
		
		outToClient.println("You are connected to this server\n");

		ServerGUI sthread = new ServerGUI(connectionSocket, outToClient);
		ServerGUI rthread = new ServerGUI(connectionSocket, inFromClient);
		
		sthread.start();
		rthread.start();
	}

}
