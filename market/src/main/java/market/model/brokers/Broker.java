package model.brokers;

public class Broker implements Interface.Broker
{
    private String ID;
    private int balance;
    // need to figure out how to keep track of stock owned
    // maybe change the id if the instruments to make it a
    // counter like we had in avaj-launcher? :)

    public Broker(String brokerID, int brokerBalance)
    {
        ID = brokerID;
        balance = brokerBalance;
    }

    public String getID() {
        return (ID);
    }

    public int getBalance() {
        return (balance);
    }

    public void setID(String value) {
        ID = value;
        return;
    }

    public void setBalance(int value) {
        balance = value;
        return;

    }
}
