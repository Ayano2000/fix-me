package model.instruments;

import Interface.Instrument;
import model.instruments.Dildo;

public class ExtraSmallDildo extends Dildo implements Instrument
{
    private String productID;
    private String size;
    private int price;
    private int amountAvailable;

    public ExtraSmallDildo()
    {
        // XSD = extra small dildo, 01 = default
        // if we add colours etc we can change the 01 value
        this.productID = "XSD01";
        this.size = "Extra Small";
        this.price = 750;
        this.amountAvailable = 20;
    }

    public String getProductID()
    {
        return productID;
    }

    public String getSize()
    {
        return size;
    }

    public int getAmountAvailable()
    {
        return amountAvailable;
    }

    public int getPrice()
    {
        return price;
    }

    public void setProductID(String value)
    {
        productID = value;
    }

    public void setSize(String value)
    {
        size = value;
    }

    public void setAmountAvailable(int value)
    {
        amountAvailable = value;
    }

    public void setPrice(int value)
    {
        price = value;
    }
}