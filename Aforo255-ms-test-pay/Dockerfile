FROM openjdk:8
VOLUME /tmp
EXPOSE 8011
ADD ./target/Aforo255-ms-test-pay-0.0.1-SNAPSHOT.jar app-pay.jar
ENTRYPOINT ["java", "-jar", "/app-pay.jar"]