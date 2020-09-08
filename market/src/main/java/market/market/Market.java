package market;

import Interface.Instrument;
import model.brokers.Broker;
import model.brokers.Brokers;
import model.instruments.Instruments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        Instruments instrumentManager = new Instruments();
        Brokers brokerManager = new Brokers();

        List<Instrument> instruments = instrumentManager.getInstruments();
        List<Broker> brokers = brokerManager.getBrokerList();

        // now to handle the communication with the market
        try (Socket socket = new Socket("localhost", 5001)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

            String received;
            String toSend;

            while (!(received = reader.readLine()).equalsIgnoreCase("Exit"))
            {
                System.out.println(received);
//                if (/*order is buy */true) {}
//                if (/*order is sell */true) {}
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
