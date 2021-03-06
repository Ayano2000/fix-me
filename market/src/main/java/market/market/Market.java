package main.java.market.market;

import main.java.market.controllers.MarketController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Market {
    private static String id;

    public static void main(String[] args) {
//         now to handle the communication with the market
         MarketController marketController = new MarketController();

         try (Socket socket = new Socket("localhost", 5001)) {
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
             String received = reader.readLine();
             String toSend;

             id = received;
             
             while (true)
             {
                 received = reader.readLine();
                 toSend = marketController.parseAndEvaluate(received);
                 writer.println(toSend);
             }

         } catch (UnknownHostException e) {
            System.out.println("host name error");
            e.printStackTrace();
         } catch (IOException e) {
            System.out.println("Please start the router first");
            e.printStackTrace();
         }
    }
}
