package server;

import java.net.*;
import java.io.*;
import com.router.router.ServerThread;

public class Router {

	public static void main(String[] arg) throws InterruptedException {
		boolean listening = true;
		try (
			// user chooses unused port to run server on
			ServerThread brokerSocket = new ServerSocket(5000);
			ServerThread marketSocket = new ServerSocket(5001);
		) {
			while (listening) {
				new ServerThread(brokerSocket.accept().start());
				new ServerThread(brokerSocket.accept().start);
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}
