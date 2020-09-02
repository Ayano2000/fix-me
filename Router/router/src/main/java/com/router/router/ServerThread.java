package server;

import java.net.*;
import java.io.*;
import java.util.Random

public class ServerThread extends Thread {
	private Socket socket = null;
	static final ArrayList<String> marketIDs = new List<String>();
	static final ArrayList<String> brokerIDs = new List<String>();

	public ServerThread(Socket socket, String name) {
		super(name);
		this.socket = socket;
	}

	public void run() {
		try (
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()), true);
				) {
				// generate id : have seperate class?
//			String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//			StringBuilder sb = new StringBuilder(6);
//			Random random = new Random();
//			for (int i = 0; i < 6; i++) {
//				int randInt = random.nextInt(allowedChars.length());
//				sb.append(allowedChars.charAt(randInt));
//			}
			marketIDs.add()
			String request, response;
			Market market = new Market(/*id*/);
			Broker broker = new Broker(/*id*/);

			/*
			 * .getOrder(): return input.readLine()
			 **/
			while ((request = broker.getOrder()) != null) {
				response = market.processOrder(request);
				output.println(response);
				if (response.equals("Exit"))
						break;
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
