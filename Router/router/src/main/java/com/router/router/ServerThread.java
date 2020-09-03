package com.router.router;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread {
	private Socket brokerSocket = null;
	private Socket marketSocket = null;
	static final ArrayList<String> marketIDs = new ArrayList<String>();
	static final ArrayList<String> brokerIDs = new ArrayList<String>();

	public ServerThread(Socket brokerSocket, Socket marketSocket) {
		super("ServerThread");
		this.brokerSocket = brokerSocket;
		this.marketSocket = marketSocket;
	}

	public void run() {
		try (
				PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
				BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
				) {
				// generate id : have seperate class?
//			String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//			StringBuilder sb = new StringBuilder(6);
//			Random random = new Random();
//			for (int i = 0; i < 6; i++) {
//				int randInt = random.nextInt(allowedChars.length());
//				sb.append(allowedChars.charAt(randInt));
//			}
			/*
			 * .getOrder(): return input.readLine()
			 **/
			String request, response;
			while ((request = input.readLine()) != null) {
				response = "heard that!";
				output.println(response);
				if (request.equalsIgnoreCase("Exit"))
					break;
			}
//			while ((request = broker.getOrder()) != null) {
//				response = market.processOrder(request);
//				output.println(response);
//				if (response.equals("Exit"))
//						break;
//			}
			brokerSocket.close();
			marketSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
