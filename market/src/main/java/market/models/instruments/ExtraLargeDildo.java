package main.java.market.models.instruments;

import main.java.market.interfaces.Instrument;

public class ExtraLargeDildo extends Dildo implements Instrument
{
    public ExtraLargeDildo()
    {
        // XLD = extra large dildo, 01 = default
        // if we add colours etc we can change the 01 value
        this.productID = "XLD01";
        this.size = "Extra Large";
        this.price = 950;
        this.amountAvailable = 20;
        this.acceptedValues.add("extralarge");
        this.acceptedValues.add("extra large");
        this.acceptedValues.add("Extra-Large");
        this.acceptedValues.add("xl");
    }

    public String getProductID()
    {
        return this.productID;
    }

    public String getSize()
    {
        return this.size;
    }

    public int getAmountAvailable()
    {
        return this.amountAvailable;
    }

    public int getPrice()
    {
        return this.price;
    }

    public void setProductID(String value)
    {
        this.productID = value;
    }

    public void setSize(String value)
    {
        this.size = value;
    }

    public void setAmountAvailable(int value)
    {
        this.amountAvailable = value;
    }

    public void setPrice(int value)
    {
        this.price = value;
    }

    public boolean checkAlias(String request)
    {
        for (String alias : this.acceptedValues) {
            if (alias.equalsIgnoreCase(request)) {
                return true;
            }
        }
        return false;
    }
}
