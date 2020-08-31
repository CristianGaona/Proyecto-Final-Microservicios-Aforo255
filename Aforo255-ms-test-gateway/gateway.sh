#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
docker build -t app-gateway:1.0 .
docker run -p 8090:8090 --name app-gateway --network aforo255-test -d app-gateway:1.0 
echo ============================================================
echo End Process
echo ============================================================