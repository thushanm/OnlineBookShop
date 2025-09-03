# --- Build Stage ---
# Use the official Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the Project Object Model (pom.xml) and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of your application source code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean install -DskipTests


# --- Run Stage ---
# Use a slim Java runtime image for the final, smaller container
FROM eclipse-temurin:17-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file from the 'build' stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port your application will run on (default for Spring Boot is 8080)
EXPOSE 8080

# The command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
