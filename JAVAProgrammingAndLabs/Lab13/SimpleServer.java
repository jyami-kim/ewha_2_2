package Lab13;

import java.io.*;
import java.net.*;

public class SimpleServer {
	public static void main(String args[]) throws IOException{
		if(args.length!=1) {
			System.out.println("Usage java SimpleServer <port number>");
			System.exit(0);
		}
		
		int portNumber = Integer.parseInt(args[0]);
		ServerSocket welcomeSocket = new ServerSocket(portNumber);
		Socket connectionSocket = welcomeSocket.accept();
		
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		
		PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(),true);

		String inputLine, outputLine;
		
		outputLine = "You are connected to this server \n";
		outToClient.println(outputLine);
		
		while((inputLine=inFromClient.readLine())!=null) {
			if(inputLine.length()>0) {
				System.out.println("Client: "+ inputLine);
				
				if(inputLine.equals("Bye."))
					break;
				outputLine = inputLine.toUpperCase();
				
				System.out.println("Server: "+ outputLine);
				outToClient.println(outputLine);
			}
		}
		//while을 벗어나면 bye를 한것이므로 끝내기
		connectionSocket.close();
	}
}
