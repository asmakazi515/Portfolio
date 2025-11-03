# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy all files from your project
COPY . .

# Build the project (skip tests to speed up)
RUN ./mvnw clean package -DskipTests

# Expose the port
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/Portfolio-1-1.0.jar"]



