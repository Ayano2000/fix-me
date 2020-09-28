package main.java.router.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageHandler {
    public MessageHandler() {}

    public boolean validateChecksum(String message) {

        int receivedChecksum = Integer.parseInt(message.split("\\|")[4]);
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
}
