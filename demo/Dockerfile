# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from target directory into the container
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "demo.jar"]
