FROM openjdk:17.0-oracle

ARG JAR_FILE=target/paqueteria-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080