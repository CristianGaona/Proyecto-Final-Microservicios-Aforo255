#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
docker build -t app-transaction:1.0 .
docker run -p 8013:8013 --name app-transaction --network aforo255-test -d app-transaction:1.0 
echo ============================================================
echo End Process
echo ============================================================