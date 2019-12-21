FROM openjdk:8-jre-alpine
COPY /target/wlcp-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
CMD ["/usr/bin/java", "-jar", "app.jar"]