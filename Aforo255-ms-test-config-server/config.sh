#!/bin/bash
echo ============================================================
echo Generate JAR
echo ============================================================
mvn clean package -DskipTests
echo ============================================================
echo BUILD and PUSH Project to Docker
echo ============================================================
#docker build -t crisda24/micro-security .
#docker push crisda24/micro-security
docker build -t app-config-server:1.0 .
docker run -p 8888:8888 --name app-config-server --network aforo255-test -d app-config-server:1.0 
echo ============================================================
echo End Process
echo ============================================================