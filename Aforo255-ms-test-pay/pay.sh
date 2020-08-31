#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
docker build -t app-pay:1.0 .
docker run -p 8011:8011 --name app-pay --network aforo255-test -d app-pay:1.0 
echo ============================================================
echo End Process
echo ============================================================