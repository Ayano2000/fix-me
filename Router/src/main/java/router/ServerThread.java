package main.java.router;

import main.java.router.models.MessageHandler;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	protected Socket brokerSocket;
	protected Socket marketSocket;
	protected MessageHandler messageHandler = new MessageHandler();
	private String brokerID;

	public ServerThread(Socket brokerSocket, Socket marketSocket) {
//		System.out.println(brokerSocket.getPort());
		this.brokerSocket = brokerSocket;
		this.marketSocket = marketSocket;
	}

	public void run() {
		try {
			PrintWriter brokerOut = new PrintWriter(brokerSocket.getOutputStream(), true);
			PrintWriter marketOut = new PrintWriter(marketSocket.getOutputStream(), true);
			BufferedReader brokerIn = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
			BufferedReader marketIn = new BufferedReader(new InputStreamReader(marketSocket.getInputStream()));
			brokerID = generateId();
			brokerOut.println(brokerID);
			String request, response;
			while (true) {
				request = brokerIn.readLine();
//				request = request.replaceFirst("buy", "sell"); // when want to test checksum validation
				if (request.equalsIgnoreCase("Exit"))
					break;
				if (messageHandler.validateChecksum(request)) {
					marketOut.println(request);
					response = marketIn.readLine();
					brokerOut.println(response);
				} else
					brokerOut.println("Something went wrong while processing your order...");
			}
			brokerSocket.close();
			this.interrupt();
		} catch (IOException | NullPointerException e) {
			System.out.println("Broker "+brokerID+" logged off");
			this.interrupt();
		}
	}

	private String generateId() {
		return "B" + brokerSocket.getPort();
	}

}
