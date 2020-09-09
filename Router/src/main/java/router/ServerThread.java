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
			/**
			 * TODO:
			 * - create random generated broker id // will this be safe? / /create with brokerSocket.getPort()
			 * - write to output stream: brokerid
			 */
			brokerID = generateId();
			brokerOut.println(brokerID);
			String request, response;
			// TODO: fix nullPointerException when broker dies
			while (true) {
				try {
					request = brokerIn.readLine();
					if (request.equalsIgnoreCase("Exit"))
						break;
					// TODO: validate request + parse messages
					if (messageHandler.validate(request)) {
						marketOut.println(messageHandler.parse(request, brokerID));
						response = marketIn.readLine();
						brokerOut.println(response);
					}
					else
						brokerOut.println("Please format your message properly and try again.");
				} catch (IOException e) {
					throw e;
				}
			}
			brokerSocket.close();
			marketSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String generateId() {
		return "helloyesthisisid";
	}

}
