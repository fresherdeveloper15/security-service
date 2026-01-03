# Use Java 17 JDK
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy your specific JAR into the container
COPY target/security-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render provides dynamic PORT)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
