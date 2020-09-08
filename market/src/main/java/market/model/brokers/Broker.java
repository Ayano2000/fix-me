package model.brokers;

public class Broker implements Interface.Broker
{
    private String ID;
    private int balance;
    private string[5][2] stock;
    // will need to convert int values for stock to strings for this array.

    public Broker(String brokerID, int brokerBalance)
    {
        ID = brokerID;
        balance = brokerBalance;
        // this is ugly but we can clean it later
        stock[0][0] = "XSD01";
        stock[0][1] = "0";

        stock[0][0] = "RSD01";
        stock[0][1] = "0";

        stock[0][0] = "RMD01";
        stock[0][1] = "0";

        stock[0][0] = "RLD01";
        stock[0][1] = "0";

        stock[0][0] = "XLD01";
        stock[0][1] = "0";
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
    }

    public void addStock(string id, int amount)
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

    public void removeStock(string id, int amount)
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
