package main.java.market.market;

import main.java.market.model.MarketModel;

public class Market {
    public static void main(String[] args) {
        // now to handle the communication with the market
        MarketModel marketModel = new MarketModel();
//        try (Socket socket = new Socket("localhost", 5001)) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
//
//            String received;
//            String toSend;
//
//            while (!(received = reader.readLine()).equalsIgnoreCase("Exit"))
//            {
//                received = reader.readLine();
//                System.out.println(received);
//                if (/*order is buy */true) {}
//                if (/*order is sell */true) {}
//            }
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
