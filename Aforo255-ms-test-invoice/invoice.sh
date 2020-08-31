#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
docker build -t app-invoice:1.0 .
docker run -p 8012:8012 --name app-invoice --network aforo255-test -d app-invoice:1.0 
echo ============================================================
echo End Process
echo ============================================================