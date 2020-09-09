package main.java.market.interfaces;

public interface BrokerInterface
{
    // setters
    String getID();
    int getBalance();
    int getStockBalance(String id);
    void addStock(String id, int amount);
    void removeStock(String id, int amount);

    // Getters
    void setID(String value);
    void setBalance(int vale);
}
