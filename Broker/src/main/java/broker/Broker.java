package main.java.broker;

import java.net.*;
import java.io.*;

public class Broker {

	private static String id;

	public static void main(String[] args) throws InterruptedException {
		try {
			Socket brokerSocket = new Socket("localhost", 5000);
			PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromRouter, fromBroker;

			System.out.println("Your order, please: ");
			fromBroker = "";
			id = input.readLine();
			System.out.println("connected. id ==  "+ id);
//			output.println(fromBroker);
			while (!fromBroker.equalsIgnoreCase("exit")) {
				fromBroker = stdIn.readLine();
				if (fromBroker.length() > 0) {
					System.out.println("printing to output stream");
					output.println(id + ": "+fromBroker);
				}
				fromRouter = input.readLine();
				System.out.println("Router: "+fromRouter);
			}
		} catch (IOException e) {

			System.out.println("Oops, something bad happened: "+e);
			System.exit(1);
		}

	}
}
