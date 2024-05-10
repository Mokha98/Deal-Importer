# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the Maven settings file if it exists
COPY .mvn/ .mvn

# Copy the source code
COPY src/ src/

# Build the application
RUN mvn package -DskipTests

# Create a new image with just the JAR file
FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /app/target/ClusteredDataWarehouse.jar .

# Specify the command to run your application
CMD ["java", "-jar", "ClusteredDataWarehouse.jar"]
