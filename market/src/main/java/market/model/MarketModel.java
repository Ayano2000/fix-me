package main.java.market.model;

import main.java.market.Interface.Instrument;
import main.java.market.model.brokers.Broker;
import main.java.market.model.brokers.Brokers;
import main.java.market.model.instruments.Instruments;

import java.util.List;

public class MarketModel
{
    private Instruments instrumentManager = new Instruments();
    private Brokers brokerManager = new Brokers();

    private List<Instrument> instruments = instrumentManager.getInstruments();
    private List<Broker> brokers = brokerManager.getBrokerList();

    public MarketModel() {
//        for (Instrument instrument : instruments) {
//            System.out.println(instrument.toString());
//        }
//        brokers.add(new Broker("ARATA", 1200));
//        brokers.add(new Broker("RIGARDT", 1200));
//        brokers.add(new Broker("CARAH", 1200));
//        for (Broker broker : brokers) {
//            System.out.println(broker.toString());
//        }
    }

    public boolean checkInstrumentAvailableStock(String id, int amount)
    {
        for (Instrument instrument : instruments) {
            if ((instrument.getProductID()).equals(id)) {
                if (instrument.getAmountAvailable() < amount) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkBrokerBalanceForPurchase(String productID, String brokerID, int amount)
    {
        addBroker(brokerID); // only adds if broker does not exist
        for (Broker broker : brokers) {
            if ((broker.getID()).equals(brokerID)) {
                for (Instrument instrument : instruments) {
                    if ((instrument.getProductID()).equals(productID)) {
                        if ((instrument.getPrice() * amount) > broker.getBalance()) {
                            return false; // broker doesn't have enough money
                        }
                        else {
                            return true; // broker can afford and instrument exists
                        }
                    }
                }
                return false; // instrument doesn't exist
            }
        }
        return false; // broker doesn't exist
    }

    public boolean sellBrokerStock(String productID, String brokerID, int amount)
    {
        if (amount < 1) {
            return false;
        }
        for (Broker broker : brokers) {
            if ((broker.getID()).equals(brokerID)) {
                if (broker.getStockBalance(productID) < amount) {
                    return false; // broker does now own enough stock to sell this much
                } else {
                    broker.removeStock(productID, amount);
                    for (Instrument instrument : instruments) {
                        if ((instrument.getProductID()).equals(productID)) {
                            broker.setBalance(broker.getBalance() + (instrument.getPrice() * amount));
                        }
                    }
                }
            }
        }
        return false; // broker doesn't exist

    }

    private void addBroker(String id)
    {
        for (Broker broker : brokers) {
            if ((broker.getID()).equals(id)) {
                return;
            }
        }
        brokers.add(new Broker(id, 1200));
        return;
    }

    private boolean checkIfInstrumentExists(String id)
    {
        // todo
        return false;
    }
}