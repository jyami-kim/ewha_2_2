package Lab13;

import java.net.*;
import java.io.*;
import java.lang.Thread;

public class ChatServer extends Thread{
	
	public Socket connectionSocket;
	public BufferedReader inFromUser;
	public BufferedReader inFromClient;
	public PrintWriter outToClient;
	
	public boolean sender_mode;
	public static boolean operation;
	
	public String inputString, outputString;
	
	public ChatServer(Socket connectionSocket, BufferedReader inFromClient) { //recieve
		this.connectionSocket = connectionSocket;
		this.inFromClient = inFromClient;
		this.sender_mode = false;
		this.operation = true;
	}
	
	public ChatServer(Socket connectionSocket, BufferedReader inFromUser, PrintWriter outToClient) {
		this.connectionSocket = connectionSocket;
		this.inFromUser = inFromUser;
		this.outToClient = outToClient;
		this.sender_mode = true;
		this.operation = true;
	}
	
	public void run() {
		if(sender_mode == true) { //보내기
			try {
				while((outputString=inFromUser.readLine())!=null) {
					if(outputString.length()>0) {
						
						outToClient.println(outputString);
						System.out.println("Server :" + outputString);
						
						if(outputString.equals("Bye")) {
							operation = false;
							connectionSocket.close();
							break;
						}
					}
					if(operation == false) {
						connectionSocket.close();
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else { //받기
			try {
				while((inputString=inFromClient.readLine())!=null) {
					if(inputString.length() >0) {
						
						System.out.println("Client :"+ inputString);
						
						if(inputString.equals("Bye")) {
							operation = false;
							connectionSocket.close();
							break;
						}
					}
					if(operation == false) {
						connectionSocket.close();
						break;
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		if(args.length!=1) {
			System.out.println("Usage java ChatServer <port number>");
			System.exit(1);
		}
		int portNumber = Integer.parseInt(args[0]);
		ServerSocket welcomeSocket = new ServerSocket(portNumber);
		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(),true);
	
		outToClient.println("You are connected to this server \n");
		
		ChatServer sthread = new ChatServer(connectionSocket, inFromUser, outToClient);
		ChatServer rthread = new ChatServer(connectionSocket, inFromClient);
		
		sthread.start();
		rthread.start();
	}
}
