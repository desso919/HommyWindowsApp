package com.hommy.windows.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HommyClient {

	 public static void main(String [] args) {
	      String serverName = "localhost";
	      int port = 6066;
	      try {
	         System.out.println("Connecting to " + serverName + " on port " + port);
	         Socket client = new Socket(serverName, port);
	         
	         System.out.println("Just connected to " + client.getRemoteSocketAddress());
	         receiveMessageFromServer(client);
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	   }

	private static void receiveMessageFromServer(Socket client) throws IOException {
		InputStream inFromServer = client.getInputStream();
		
		 DataInputStream in = new DataInputStream(inFromServer);
		 
		 while (true) {
			 String message = in.readUTF();
			 System.out.println("Server says " + message);
			 
			 PlayMusic.play();
			 
		 }
		 
	}
}
