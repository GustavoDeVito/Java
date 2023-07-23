# Stage 1: Build the Spring application
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the source code and pom.xml to the container
COPY pom.xml .
COPY src/ ./src/

# Build the application with Maven
RUN mvn package

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=builder /app/target/post-0.0.1-SNAPSHOT.jar /app/post-0.0.1-SNAPSHOT.jar

# Expose the port your Spring application is running on (change the port if needed)
EXPOSE 8081

# Command to run your Spring application
CMD ["java", "-jar", "post-0.0.1-SNAPSHOT.jar"]