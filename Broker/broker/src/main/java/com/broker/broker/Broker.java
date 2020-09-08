package com.broker.broker;

import java.net.*;
import java.io.*;

public class Broker {

	public static void main(String[] args) throws InterruptedException {
		try (
			Socket brokerSocket = new Socket("localhost", 5000);
			PrintWriter output = new PrintWriter(brokerSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(brokerSocket.getInputStream()));
		) {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromRouter, fromBroker;
			System.out.println("Your order, please: ");
			fromBroker = stdIn.readLine();
			System.out.println("you said: "+ fromBroker);
			output.println(fromBroker);
			while ((fromRouter = input.readLine()) != null) {
				System.out.println("Router: "+fromRouter);
				if (fromRouter.equals("Exit"))
					break;
				fromBroker = stdIn.readLine();
				if (fromBroker != null) {
					System.out.println("Broker: "+fromRouter);
					output.println(fromBroker);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}

	}
}
