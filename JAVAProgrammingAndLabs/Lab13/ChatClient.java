package Lab13;

import java.net.*;
import java.io.*;
import java.lang.Thread;

public class ChatClient extends Thread{
	
	public Socket clientSocket;
	public BufferedReader inFromUser;
	public BufferedReader inFromServer;
	public PrintWriter outToServer;
	
	public boolean sender_mode;
	public static boolean operation;
	
	public String inputString, outputString;
	
	public ChatClient(Socket clientSocket, BufferedReader inFromServer) { //recieve
		this.clientSocket = clientSocket;
		this.inFromServer = inFromServer;
		this.sender_mode = false;
		this.operation = true;
	}
	
	public ChatClient(Socket clientSocket, BufferedReader inFromUser, PrintWriter outToServer) {
		this.clientSocket = clientSocket;
		this.inFromUser = inFromUser;
		this.outToServer = outToServer;
		this.sender_mode = true;
		this.operation = true;
	}
	
	public void run() {
		if(sender_mode == true) { //보내기
			try {
				while((outputString=inFromUser.readLine())!=null) {
					if(outputString.length()>0) {
						
						outToServer.println(outputString);
						System.out.println("Client :" + outputString);
						
						if(outputString.equals("Bye")) {
							operation = false;
							clientSocket.close();
							break;
						}
					}
					if(operation == false) {
						clientSocket.close();
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else { //받기
			try {
				while((inputString=inFromServer.readLine())!=null) {
					if(inputString.length() >0) {
						
						System.out.println("Server :"+ inputString);
						
						if(inputString.equals("Bye")) {
							operation = false;
							clientSocket.close();
							break;
						}
					}
					if(operation == false) {
						clientSocket.close();
						break;
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		if(args.length!=2) {
			System.out.println("Usage java ChatServer <ip address> <port number>");
			System.exit(1);
		}
		String address = args[0];
		int portNumber = Integer.parseInt(args[1]);

		Socket clientSocket = new Socket(address, portNumber);
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(),true);
	
		ChatClient sthread = new ChatClient(clientSocket, inFromUser, outToServer);
		ChatClient rthread = new ChatClient(clientSocket, inFromServer);

		sthread.start();
		rthread.start();
	}
}
