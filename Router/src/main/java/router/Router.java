package main.java.router;

import java.net.*;
import java.io.*;

public class Router {

	public static void main(String[] arg) throws InterruptedException {
		boolean listening = true;
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
					}
					System.out.println("gon do this shit now");
					new ServerThread(brokerSocket.accept(), marketClientSocket).start();
				} catch (IOException e) {
					throw e;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
