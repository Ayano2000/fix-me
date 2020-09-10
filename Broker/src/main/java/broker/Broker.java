package main.java.broker;

import java.net.*;
import java.io.*;

public class Broker {

	private static String id;

	public static void main(String[] args) throws InterruptedException {
		try (Socket brokerSocket = new Socket("localhost", 5000);
				PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
				BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				) {

			String fromRouter, fromBroker;
			System.out.println("Your order, please: \nExpected format: <buy/sell> <instrument> <amount>");
			id = input.readLine();
			while (true) {
				try {
					fromBroker = stdIn.readLine();
					if (fromBroker.length() > 0) {
						if (fromBroker.equalsIgnoreCase("exit"))
							break;
						output.println(fromBroker);
					}
					fromRouter = input.readLine();
					if (fromRouter.length() > 0) {
						System.out.println("Router: "+fromRouter);
					}
				} catch (IOException | NullPointerException e) {
					throw e;
				}
			}
		} catch (IOException | NullPointerException e) {
			System.out.println("Oops, something bad happened: "+e);
			System.exit(1);
		}

	}
}
