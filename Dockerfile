# 1️⃣ Use an official lightweight JDK image
FROM openjdk:17-jdk-slim

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy everything from your project folder to the container
COPY . .

# 4️⃣ Give permission to the Maven wrapper (important for Linux builds)
RUN chmod +x mvnw

# 5️⃣ Build the project (skip tests to speed up)
RUN ./mvnw clean package -DskipTests

# 6️⃣ Expose the port your Spring Boot app will run on
EXPOSE 8080

# 7️⃣ Start the app
CMD ["java", "-jar", "target/Portfolio-1-1.0.jar"]
