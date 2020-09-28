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

    public String createChecksum(String message)
    {
        String[] values = message.split("\\|");
        String parsedMessage = values[0];
        int checksum = 0;
        parsedMessage += "|" + message.replaceAll(" ", "|");
        for (int i = 0; i < parsedMessage.length(); i++) {
            int temp = (int) (Math.floor(Math.log(parsedMessage.charAt(i)) / Math.log(2))) + 1;
            checksum += ((1 << temp) - 1) ^ parsedMessage.charAt(i);
        }
        return Integer.toString(checksum) ;
    }

    public boolean checkChecksum(String message)
    {
        int receivedChecksum = Integer.parseInt(message);
        String originalMessage = message.substring(0, message.length() - ((int)(Math.log10(receivedChecksum)) + 2));
        int checksum = 0;

        for (int j = 0; j < originalMessage.length(); j++) {
            int temp = (int) (Math.floor(Math.log(originalMessage.charAt(j)) / Math.log(2))) + 1;
            checksum += ((1 << temp) - 1) ^ originalMessage.charAt(j);
        }
        try {
            if (checksum == receivedChecksum)
                return true;
        } catch (NumberFormatException e) {
            System.out.println("Something went wrong: "+e);
        }

        return false;
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