package main.java.market.controllers;

import main.java.market.interfaces.Instrument;
import main.java.market.models.MarketModel;
import main.java.market.models.MessageHandler;
import main.java.market.models.brokers.Broker;
import main.java.market.models.brokers.Brokers;
import main.java.market.models.instruments.Instruments;

import java.util.List;

public class MarketController {
    private Instruments instrumentManager = new Instruments();
    private Brokers brokerManager = new Brokers();

    private List<Instrument> instruments = instrumentManager.getInstruments();
    private List<Broker> brokers = brokerManager.getBrokerList();

    private MarketModel marketModel = new MarketModel(instruments, brokers);
    private MessageHandler messageHandler = new MessageHandler(instruments);

    public MarketController() { }

    public void printInventory()
    {
        for (Instrument instrument : instruments) {
            System.out.println(instrument.toString());
        }
    }

    public void printBrokers()
    {
        for (Broker broker : brokers) {
            System.out.println(broker.toString());
        }
    }

    public String parseAndEvaluate(String message)
    {
        String messageToSend = "";
        String[] values = messageHandler.parse(message);
        if (values[1].equalsIgnoreCase("buy")){
            messageToSend = buyRequest(values[2], values[0], Integer.parseInt(values[3]));
        } else if (values[1].equalsIgnoreCase("sell")) {
            messageToSend = sellRequest(values[2], values[0], Integer.parseInt(values[3]));
        }
        return (messageToSend);
    }

    public String buyRequest(String productID, String brokerID, int amount)
    {
        String message = "";
        String checksum = "";

        if (marketModel.purchaseStock(productID, brokerID, amount) == true) {
            message = brokerID + "|" + amount + "|" + productID + "|Accepted";
        } else {
            message = brokerID + "|" + amount + "|" + productID + "|Rejected";
        }
        checksum = messageHandler.createChecksum(message);
        message = message + "|" + checksum;
        return (message);
    }

    public String sellRequest(String productID, String brokerID, int amount)
    {
        String message = "";
        String checksum = "";

        if (marketModel.sellBrokerStock(productID, brokerID, amount) == true) {
            message = brokerID + "|" + amount + "|" + productID + "|Accepted";
        } else {
            message = brokerID + "|" + amount + "|" + productID + "|Rejected";
        }
        checksum = messageHandler.createChecksum(message);
        message = message + "|" + checksum;
        return (message);
    }
}
