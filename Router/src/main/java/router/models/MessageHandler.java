package main.java.router.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageHandler {
    public MessageHandler() {}

    public String parse(String message, String brokerID) {
        String parsedMessage = brokerID;
        String checksum;
        parsedMessage += "|"+message.replaceAll(" ", "|");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            md.update(parsedMessage.getBytes());
            byte[] bytes = md.digest();

            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            checksum = sb.toString();
            parsedMessage += "|"+checksum;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return parsedMessage;
    }

    public boolean validate(String message) {
        String[] msgPieces = message.split(" ");
        if (msgPieces.length == 3) {
            if ((msgPieces[0].equalsIgnoreCase("buy") || msgPieces[0].equalsIgnoreCase("sell"))
                && msgPieces[1].length() > 0 && msgPieces[2].length() > 0) {
                try {
                    Integer.parseInt(msgPieces[2]);
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Please format your message properly and try again.");
                }
            }
        }
        return false;
    }

    public boolean validateMarketMessage(String message) {
        String[] msgPieces = message.split("\\|");
        if (msgPieces.length == 5) {
            // TODO: validate msg based on checksum
        }
        return false;
    }
}
