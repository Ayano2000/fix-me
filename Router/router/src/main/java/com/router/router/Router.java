package server;

import java.net.*;
import java.io.*;
import server.KnockKnockProtocol;

public class Router {

	public static void main(String[] arg) throws InterruptedException {
		// dont think we need this check, our main wont need to take ports as an input
		// since theyre already defined as 5000/5001
		/*
		if (arg.length != 1)
			throw new IllegalArgumentException();
		int port = Integer.parseInt(arg[0]);

		*/
		try (
			// user chooses unused port to run server on
			ServerSocket serverSocket = new ServerSocket(/* this should be the array of 5000 & 5001 */);

			//will wait for request on server socket at port
			//when successfully connected, accept() returns new Socket object bound to that port
			//server can communicate with client over this socket
			Socket clientSocket = serverSocket.accept();
			// PrintWriter(OutputStream, bool:autoFlush)
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		) {
			String inputLine, outputLine;

			// Below starts a convo with the client, in this case the joke
			// for us it should make a connection to the market(?) maybe not
			// make a connection but it should connect and listen for buy/sell requests

			// Start convo with client
			/*
			KnockKnockProtocol kkp = new KnockKnockProtocol();
			outputLine = kkp.processInput(null);
			output.println(outputLine);

			while ((inputLine = input.readLine()) != null) {
				outputLine = kkp.processInput(inputLine);
				output.println(outputLine);
				if (outputLine.equals("Ok, well, bye."))
					break;
			}
			*/
		} catch (NumberFormatException e) {
			System.out.println(e);
			System.exit(1);
		} /*
			since we dont have a required amount of args we dont need this exception

			catch (IllegalArgumentException e) {
			System.out.println(e);
			System.exit(1);
		} */catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
