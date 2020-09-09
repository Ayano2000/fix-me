package main.java.market.model.brokers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Brokers
{
    private List<Broker> brokerList = new CopyOnWriteArrayList<Broker>();

    public Brokers()
    {

    }

    public void addBroker(String id, int balance)
    {
        brokerList.add(new Broker(id, balance));
        // maybe add some safety checks here
    }

    public List<Broker> getBrokerList()
    {
        return brokerList;
    }
}
