package main.java.market.models;

import main.java.market.interfaces.Instrument;
import main.java.market.models.brokers.Broker;

import java.util.List;

public class MarketModel
{
    private List<Instrument> instruments = null;
    private List<Broker> brokers = null;

    public MarketModel(List<Instrument> instrumentList, List<Broker> brokerList) {
        instruments = instrumentList;
        brokers = brokerList;
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
        addBroker(brokerID);
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
        addBroker(brokerID);

        if (amount < 1) {
            return false;
        }
        for (Broker broker : brokers) {
            if ((broker.getID()).equals(brokerID)) {
                if (broker.getStockBalance(productID) < amount) {
                    return false; // broker does now own enough stock to sell this much
                } else {
                    for (Instrument instrument : instruments) {
                        if ((instrument.getProductID()).equals(productID)) {
                            broker.removeStock(productID, amount);
                            broker.setBalance(broker.getBalance() + (instrument.getPrice() * amount));
                            instrument.setAmountAvailable(instrument.getAmountAvailable() + amount);
                            return true;
                        }
                    }
                }
            }
        }
        return false; // broker doesn't exist
    }

    public boolean purchaseStock(String productID, String brokerID, int amount)
    {
        addBroker(brokerID);
        if (checkIfInstrumentExists(productID) == false) {
            return false;
        }
        else if (checkBrokerBalanceForPurchase(productID, brokerID, amount) == false){
            return false;
        }
        else if (checkInstrumentAvailableStock(productID, amount) == false) {
            return false;
        }
        for (Broker broker : brokers) {
            if ((broker.getID()).equals(brokerID)) {
                for (Instrument instrument : instruments) {
                    if ((instrument.getProductID().equals(productID))) {
                            instrument.setAmountAvailable(instrument.getAmountAvailable() - amount);
                            broker.setBalance(broker.getBalance() - (instrument.getPrice() * amount));
                            broker.addStock(productID, amount);
                            return true;
                    }
                }
            }
        }
        return false;
    }


    // only adds if broker does not exist
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
        for (Instrument instrument : instruments) {
            if ((instrument.getProductID()).equals(id)) {
                return true;
            }
        }
        return false;
    }
}