package com.router.router;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread {
	protected Socket brokerSocket = null;
	static final ArrayList<String> marketIDs = new ArrayList<String>();
	static final ArrayList<String> brokerIDs = new ArrayList<String>();

	public ServerThread(Socket brokerSocket) {
		System.out.println("port" + brokerSocket.getPort());
		this.brokerSocket = brokerSocket;
	}

	public void run() {
		try {
			PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
			String request, response;
			while (true) {
				try {
					request = input.readLine();
					if (request.equalsIgnoreCase("Exit"))
						break;
					else
						System.out.println(request);
					output.println(request);
				} catch (IOException e) {
					throw e;
				}
			}
			brokerSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
