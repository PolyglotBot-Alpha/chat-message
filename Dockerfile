# Use the official Maven image to build the app with OpenJDK 17
FROM maven:3.8-openjdk-17 AS build

# Author
LABEL author="yuqi.guo17@gmail.com"

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the application source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use the official OpenJDK image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/chat-message-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the application runs
EXPOSE 8081

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "app.jar"]
