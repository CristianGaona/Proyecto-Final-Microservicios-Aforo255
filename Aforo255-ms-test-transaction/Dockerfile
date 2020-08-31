FROM openjdk:8
VOLUME /tmp
EXPOSE 8013
ADD ./target/Aforo255-ms-test-transaction-0.0.1-SNAPSHOT.jar app-transaction.jar
ENTRYPOINT ["java", "-jar", "/app-transaction.jar"]