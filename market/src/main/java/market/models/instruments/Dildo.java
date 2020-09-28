package main.java.market.models.instruments;

import java.util.ArrayList;
import java.util.List;

public class Dildo {
    protected String productID;
    protected String size;
    protected int price;
    protected int amountAvailable;
    protected List<String> acceptedValues = new ArrayList<String>();

    @Override
    public String toString() {
        return "Product: " + productID + " Size: " + size + " Price: " + price + " amount available: " + amountAvailable;
    }
}
