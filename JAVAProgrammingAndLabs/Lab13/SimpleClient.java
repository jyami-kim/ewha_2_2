package Lab13;

import java.net.*;
import java.io.*;

public class SimpleClient {
	public static void main(String args[]) throws IOException {
		if(args.length!=2) {
			System.out.println("Usage: java SimpleCilent <ip address> <port number>");
			System.exit(1);
		}
		
		String hostname = args[0];
		int portNumber = Integer.parseInt(args[1]);
		
		Socket clientSocket = new Socket(hostname, portNumber);
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(),true);
		
		String inputLine, outputLine;
		
		while((inputLine=inFromServer.readLine())!=null) {
			if(inputLine.length()>0) {
				System.out.println("Server : "+inputLine);
				if(inputLine.equals("Bye."))
					break;
				
				outputLine = inFromUser.readLine();
				System.out.println("Client:" + outputLine);
				outToServer.println(outputLine);
			}
		}
		clientSocket.close();
	}
}
