package main.java.router;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Router {

	private static ArrayList<String> routingTable = new ArrayList<String>();

	public static void main(String[] arg) throws InterruptedException {

		try {
			//starts server sockets for brokers and market
			ServerSocket brokerSocket = new ServerSocket(5000);
			ServerSocket marketSocket = new ServerSocket(5001);
			// waits for market to connect to server on port 5001, accepts connection
			Socket marketClientSocket = null;
			// infinitely listens for connections on port 5000, creating new ServerThread for each connection
			while (true) {
				try {
					if (marketClientSocket == null) {
						System.out.println("Waiting for Market to connect...");
						marketClientSocket = marketSocket.accept();
						new PrintWriter(marketClientSocket.getOutputStream(), true).println("M"+marketClientSocket.getPort());
						System.out.println("The Market is now open for business...");
					}
					Socket broker = brokerSocket.accept();
					String brokerID = generateID(broker);
					routingTable.add(brokerID);
					new ServerThread(broker, marketClientSocket, brokerID).start();
				} catch (IOException e) {
					throw e;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	private static String generateID(Socket broker) {
		return "B" + broker.getPort();
	}

	static boolean validateID(String id) { return routingTable.contains(id); }
}
