package main.java.broker;

import java.net.*;
import java.io.*;

public class Broker {

	private static String id;

	public static void main(String[] args) {
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
					if (fromBroker.equalsIgnoreCase("exit"))
						break;
					if (validateInput(fromBroker)) {
						output.println(parseMessage(fromBroker));
						fromRouter = input.readLine();
						if (fromRouter != null)
							if (fromRouter.length() > 0)
								System.out.println("Router: "+fromRouter);
					} else {
						System.out.println("Please check the format of your order and try again...");
					}
				} catch (IOException | NullPointerException e) {
					throw e;
				}
			}
		} catch (IOException | NullPointerException e) {
			System.out.println("Oops, something bad happened: ");
			e.printStackTrace();
		}
	}

	private static String parseMessage(String message) {
		String parsedMessage = id;
		int checksum = 0;
		parsedMessage += "|"+message.replaceAll(" ", "|");
		for (int i = 0; i < parsedMessage.length(); i++) {
			int temp = (int) (Math.floor(Math.log(parsedMessage.charAt(i)) / Math.log(2))) + 1;
			checksum += ((1 << temp) - 1) ^ parsedMessage.charAt(i);
		}
		parsedMessage += "|"+checksum;
		return parsedMessage;
	}

	private static boolean validateInput(String message) {
		String[] msgPieces = message.split(" ");
		if (msgPieces.length == 3) {
			if ((msgPieces[0].equalsIgnoreCase("buy") || msgPieces[0].equalsIgnoreCase("sell"))
					&& msgPieces[1].length() > 0 && msgPieces[2].length() > 0) {
				try {
					Integer.parseInt(msgPieces[2]);
					return true;
				} catch (NumberFormatException e) {
					System.out.println("Please format your message properly and try again.");
				}
			}
		}
		return false;
	}
}
