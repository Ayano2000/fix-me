package com.broker.broker;

import java.net.*;
import java.io.*;

public class Broker {

	public static void main(String[] args) throws InterruptedException {
		try {
			Socket brokerSocket = new Socket("localhost", 5000);
			PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromRouter, fromBroker;

			System.out.println("Your order, please: ");
			fromBroker = "";
//			System.out.println("you said: "+ fromBroker);
//			output.println(fromBroker);
			while (!fromBroker.equalsIgnoreCase("exit")) {
//				fromRouter = input.readLine();
				fromBroker = stdIn.readLine();
				System.out.println("Broker: "+fromBroker);
//				if (fromBroker.equals("Exit"))
//					break;
				if (fromBroker.length() > 0) {
					System.out.println("printing to output stream");
					output.println(fromBroker);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}

	}
}
