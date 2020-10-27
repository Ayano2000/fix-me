# fix-me

Nobody can fix you, you need to fix yourself.

I don't even know what we're meant to do for this project :(

Let's fix that...

Multi-threaded network application that simulates financial market exchanges using a simplified version of the Financial Information eXchange protocol message notation. 

There are three components that make up the app:

### Router
> The router is the central component of your applications. All other components connect to it in order to send messages to other components.

Initially, Router waits for a Market component to connect on port 5001; our reason being it wouldn't make sense for the Broker component to connect if there isn't a Market to trade on.
Then it creates a new thread for each Broker that connects on port 5000.
It assigns unique 6-digit IDs to any Market or Broker that connects, and keeps track of assigned IDs for use in message validation.

### Market
> A market has a list of instruments that can be traded. When orders are received from brokers, the market tries to execute it.  If the execution is successfull, it updates the internal instrument list and sends the broker an Executed message. If the order can’t be met, the market sends a Rejected message.

### Broker
Sends Buy and Sell orders to the Router for the Market. Receives Executed and Rejected messages. The Broker also validates user input and transforms it into a message that resembles FIX message notation.

---
##### Maybe TODO (pretty sure this is doable in an afternoon):
- [ ] Convert to using non-blocking sockets (the PDF mentions this briefly on page 4)
