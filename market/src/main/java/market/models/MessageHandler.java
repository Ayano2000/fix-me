package main.java.market.models;

import main.java.market.interfaces.Instrument;

import java.util.List;

public class MessageHandler {

    private List<Instrument> instruments;

    public MessageHandler(List<Instrument> instrumentList)
    {
        instruments = instrumentList;
    }

    public String[] parse(String message)
    {
        String[] values = new String[4];
        values = message.split("[|]");
        String productID = convertToProductID(values[2]);
        values[2] = productID;
        return (values);
    }

    public String convertToProductID(String request)
    {
        for(Instrument instrument : instruments) {
            if (instrument.checkAlias(request) == true) {
                return instrument.getProductID();
            }
        }
        return ("Error!");
    }
}
