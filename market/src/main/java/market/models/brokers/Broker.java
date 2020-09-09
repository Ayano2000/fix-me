package main.java.market.models.brokers;

import main.java.market.interfaces.BrokerInterface;

import java.util.Arrays;
import java.util.StringJoiner;

public class Broker implements BrokerInterface
{
    private String ID;
    private int balance;
    private String[][] stock;
    // will need to convert int values for stock to strings for this array.

    public Broker(String brokerID, int brokerBalance)
    {
        ID = brokerID;
        balance = brokerBalance;
        stock = new String[5][2];
        // this is ugly but we can clean it later
        stock[0][0] = "XSD01";
        stock[0][1] = "0";

        stock[1][0] = "RSD01";
        stock[1][1] = "0";

        stock[2][0] = "RMD01";
        stock[2][1] = "0";

        stock[3][0] = "RLD01";
        stock[3][1] = "0";

        stock[4][0] = "XLD01";
        stock[4][1] = "0";
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (String[] row : stock) {
            sj.add(Arrays.toString(row));
        }
        String result = sj.toString();
        return "ID: " + ID + " Balance: " + balance + " Stock: " + result;
    }

    public String getID() {
        return (ID);
    }

    public int getBalance() {
        return (balance);
    }

    public void setID(String value)
    {
        ID = value;
        return;
    }

    public void setBalance(int value)
    {
        balance = value;
        return;
    }

    public int getStockBalance(String id)
    {
        if (id.equals("XSD01"))
        {
            return (Integer.parseInt(stock[0][1]));
        }
        else if (id.equals("RSD01"))
        {
            return (Integer.parseInt(stock[1][1]));
        }
        else if (id.equals("RMD01"))
        {
            return (Integer.parseInt(stock[2][1]));
        }
        else if (id.equals("RLD01"))
        {
            return (Integer.parseInt(stock[3][1]));
        }
        else if (id.equals("XLD01"))
        {
            return (Integer.parseInt(stock[4][1]));
        }
        return (0);
    }

    public void addStock(String id, int amount)
    {
        int newAmount = 0;

        if (id.equals("XSD01"))
        {
            newAmount = Integer.parseInt(stock[0][1]) + amount;
            stock[0][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RSD01"))
        {
            newAmount = Integer.parseInt(stock[1][1]) + amount;
            stock[1][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RMD01"))
        {
            newAmount = Integer.parseInt(stock[2][1]) + amount;
            stock[2][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RLD01"))
        {
            newAmount = Integer.parseInt(stock[3][1]) + amount;
            stock[3][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("XLD01"))
        {
            newAmount = Integer.parseInt(stock[4][1]) + amount;
            stock[4][1] = Integer.toString(newAmount);
            return;
        }
        return;
    }

    public void removeStock(String id, int amount)
    {
        int newAmount = 0;

        if (id.equals("XSD01"))
        {
            newAmount = Integer.parseInt(stock[0][1]) - amount;
            stock[0][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RSD01"))
        {
            newAmount = Integer.parseInt(stock[1][1]) - amount;
            stock[1][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RMD01"))
        {
            newAmount = Integer.parseInt(stock[2][1]) - amount;
            stock[2][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("RLD01"))
        {
            newAmount = Integer.parseInt(stock[3][1]) - amount;
            stock[3][1] = Integer.toString(newAmount);
            return;
        }
        else if (id.equals("XLD01"))
        {
            newAmount = Integer.parseInt(stock[4][1]) - amount;
            stock[4][1] = Integer.toString(newAmount);
            return;
        }
        return;
    }
}
