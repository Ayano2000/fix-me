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

    public MarketController() {
        brokers.add(new Broker("Arata", 10000));
        brokers.add(new Broker("Rigardt", 10000));
        brokers.add(new Broker("Carah", 10000));
        System.out.println("INSTRUMENTS:");
        for (Instrument instrument : instruments) {
            System.out.println(instrument.toString());
        }
        for (Broker broker : brokers) {
            System.out.println(broker.toString());
        }
    }

    public String buyRequest(String productID, String brokerID, int amount)
    {
        String message = "";

        if (marketModel.purchaseStock(productID, brokerID, amount) == true) {
            message = brokerID + ": buy order for " + amount + "product: " + productID + " Accepted";
        } else {
            message = brokerID + ": buy order for " + amount + "product: " + productID + " Rejected";
        }
        return (message);
    }

    public String sellRequest(String productID, String brokerID, int amount)
    {
        String message = "";

        if (marketModel.sellBrokerStock(productID, brokerID, amount) == true) {
            message = brokerID + ": sell order for " + amount + "product: " + productID + " Accepted";
        } else {
            message = brokerID + ": sell order for " + amount + "product: " + productID + " Rejected";
        }
        return (message);
    }
}
