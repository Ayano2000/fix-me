package main.java.router;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread {
	protected Socket brokerSocket = null;
	protected Socket marketSocket = null;
	static final ArrayList<String> marketIDs = new ArrayList<String>();
	static final ArrayList<String> brokerIDs = new ArrayList<String>();

	public ServerThread(Socket brokerSocket, Socket marketSocket) {
//		System.out.println(brokerSocket.getPort());
		this.brokerSocket = brokerSocket;
		this.marketSocket = marketSocket;
	}

	public void run() {
		try {
			PrintWriter output = new PrintWriter(marketSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
			/**
			 * TODO:
			 * - create random generated broker id // will this be safe? / /create with brokerSocket.getPort()
			 * - write to output stream: brokerid
			 */
			output.println("helloyesthisisid");
			String request, response;
			// TODO: fix nullPointerException when broker dies
			while (true) {
				try {
					request = input.readLine();
					if (request.equalsIgnoreCase("Exit"))
						break;
					else
						System.out.println(request);
					// TODO: validate request
					output.println(request);
				} catch (IOException e) {
					throw e;
				}
			}
			brokerSocket.close();
			marketSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	private void generateId() {

	}

}
