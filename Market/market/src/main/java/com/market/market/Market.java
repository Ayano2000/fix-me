package com.market.market;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Market 
{
    // market has to recieve buy/sell requests from the router.
    // then has to evaluate the request and send back either,
    // executed or rejected

    // the market also has a list of instruments that can be traded
    // it needs to update this on a buy/sell request and
    // check it before executing either.
    // this could go in its own model inthe market project
    public static void main( String[] args )
    {
        // maybe should go in a try block, this way if it fails we can
        // throw an error?
        try (Socket marketSocket = new Socket("we can decide on an ip", 5001))
        {
            // we still need a reader and a writer for the market to
            // get and send requests to and from the router
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()), true);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // might need a scanner ??

            // market should also listen for 'exit' so when app closes it all closes
        }
    }
}
