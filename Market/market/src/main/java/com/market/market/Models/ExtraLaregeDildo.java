package com.market.market.Models;

public class ExtraLargeDildo
{
    private string productID;
    private string size;
    private int pice;
    private int amountAvailible;

    public static ExtraLargeDildo()
    {
        // XLD = extra large dildo, 01 = defaut
        // if we add colours etc we can change the 01 value
        this.productID = "XL01";
        this.size = "Extra Large";
        this.price = 950;
        this.amountAvailible = 20;
    }

    public string getProductID()
    {
        return this.productID;
    }

    public string getSize()
    {
        return this.size;
    }

    public int getAmountAvailible()
    {
        return this.amountAvailible;
    }

    public int getPrice()
    {
        return this.price;
    }

    public string setProductID(string value)
    {
        this.productID = value;
    }

    public string setSize(string value)
    {
        this.size = value;
    }

    public int setAmountAvailible(int value)
    {
        this.amountAvailible = value;
    }

    public int setPrice(int value)
    {
        this.price = value;
    }
}