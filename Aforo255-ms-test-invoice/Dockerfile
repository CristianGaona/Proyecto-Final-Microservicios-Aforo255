FROM openjdk:8
VOLUME /tmp
EXPOSE 8012
ADD ./target/Aforo255-ms-test-invoice-0.0.1-SNAPSHOT.jar app-invoice.jar
ENTRYPOINT ["java", "-jar", "/app-invoice.jar"]