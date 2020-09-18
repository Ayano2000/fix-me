#!/bin/bash

PID=`lsof -ti :5000`
if [ -n $PID ]; 
then
	kill $PID
fi
PID=`lsof -ti :5001`
if [ -n $PID ];
then
	kill $PID
fi
mvn clean package
java -jar ./Router/target/router-1.0-SNAPSHOT.jar &
java -jar ./market/target/market-1.0-SNAPSHOT.jar
