package main.java.market.market;

import main.java.market.controllers.MarketController;

public class Market {
    public static void main(String[] args) {
        // now to handle the communication with the market
        MarketController marketController = new MarketController();

//        try (Socket socket = new Socket("localhost", 5001)) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
//
//            String received;
//            String toSend;
//
//            while (true)
//            {
//                received = reader.readLine();
//                System.out.println(received);
//                // todo
////                toSend = marketController.evaluate();
//            }
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
