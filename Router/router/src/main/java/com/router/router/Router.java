package com.router.router;

import java.net.*;
import java.io.*;
import java.util.*;
import com.router.router.ServerThread;

public class Router {

	public static void main(String[] arg) throws InterruptedException {
		boolean listening = true;
		try {
			//starts server sockets for brokers and market
			ServerSocket brokerSocket = new ServerSocket(5000);
			ServerSocket marketSocket = new ServerSocket(5001);
			// waits for market to connect to server on port 5001, accepts connection
			Socket marketClientSocket = marketSocket.accept();
			// infinitely listens for connections on port 5000, creating new ServerThread for each connection
			while (true) {
				try {
					System.out.println("gon do this shit now");
					new ServerThread(brokerSocket.accept()).start();
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
