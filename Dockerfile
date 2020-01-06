FROM openjdk:8-jre-alpine
RUN apk add curl jq
COPY /start.sh start.sh
COPY /target/wlcp-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
CMD ["/start.sh"]