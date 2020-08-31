FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD ./target/Aforo255-ms-test-config-server-0.0.1-SNAPSHOT.jar app-config-server.jar
ENTRYPOINT ["java", "-jar", "/app-config-server.jar"]