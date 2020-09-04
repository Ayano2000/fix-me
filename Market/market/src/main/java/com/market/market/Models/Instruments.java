package com.market.market.Models;
public class Instruments
{
    // could name this fiels the same as the product code
    // EG 'extraSmallDildo' becomes 'XSD01'
    private ExtraSmallDildo extraSmallDildo;
    private SmallDildo smallDildo;
    private MediumDildo mediumDildo;
    private LargeDildo largeDildo;
    private ExtraLargeDildo extraLargeDildo;

    public static Instruments()
    {
        // need to keep one of each of the stock models.
        this.extraLargeDildo = new ExtraSmallDildo();
        this.smallDildo = new SmallDildo();
        this.mediumDildo = new MediumDildo();
        this.largeDildo = new LargeDildo();
        this.extraLargeDildo = new ExtraLargeDildo();
    }

    public boolean purchaseItem(int amount, int clientBalance, string productCode)
    {
        // this can maybe return error codes so the broker
        // can know why the transaction was rejected
        if (clientBalance < 600) {  return false; }
        if (amount < 1) { return false }

        // lets set a var to be the same as the product we are working with

        // probably should be a switch case
        var product;
        if (productCode == 'XSD01') { product = this.extraSmallDildo; }
        if (productCode == 'RSM01') { product = this.smallDildo; }
        if (productCode == 'RMD01') { product = this.mediumDildo; }
        if (productCode == 'RLD01') { product = this.largeDildo; }
        if (productCode == 'XLD01') { product = this.extraLargeDildo; }

        if (product === null) { return false; }
        if ((product.getPrice() * amount) > clientBalance) { return false; }
        if (product.getAmountAvailible < amount || product.getAmountAvailible < 0) { return false; }

        return (true);
    }

}
