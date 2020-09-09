package main.java.market.Interface;

public interface Instrument
{
    // setters
    String getProductID();
    String getSize();
    int getAmountAvailable();
    int getPrice();

    // Getters
    void setAmountAvailable(int value);
    void setPrice(int value);
    void setProductID(String value);
    void setSize(String value);
}
