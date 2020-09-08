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
        // instruments are our dildos, wanna make the same one for the brokers
        List<Instrument> instruments = instrumentManager.getInstruments();
        List<Broker> brokers = brokerManager.getBrokerList();
        // brokers needs some work but will come back to it.
        // need to figure out how to keep track of the brokers stock
        // but we can keep track of the brokers and the instruments like this.

        // now to handle the communication with the market
        try (Socket socket = new Socket("localhost", 5001)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

            String received = reader.readLine();
            String toSend;

            while (!received.equalsIgnoreCase("Exit"))
            {
                received = reader.readLine();
                System.out.println(received);
                if (/*order is buy */true) {}
                if (/*order is sell */true) {}
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
