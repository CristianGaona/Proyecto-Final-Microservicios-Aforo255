FROM openjdk:8
VOLUME /tmp
EXPOSE 8090
ADD ./target/Aforo255-ms-test-gateway-0.0.1-SNAPSHOT.jar app-gateway.jar
ENTRYPOINT ["java", "-jar", "/app-gateway.jar"]