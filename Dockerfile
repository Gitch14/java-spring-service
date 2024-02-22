#FROM maven:3.8.4-openjdk-17-slim AS build

#WORKDIR /app

#COPY pom.xml .

#COPY src ./src

#RUN mvn clean package -DskipTests

FROM openjdk:17

ARG JAR_FILE=target/java-spring-service-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]