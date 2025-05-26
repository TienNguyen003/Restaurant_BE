# Sử dụng image Java chính thức (Java 17)
FROM openjdk:17-jdk-slim

# Set thư mục làm việc trong container
WORKDIR /app

# Copy file .jar từ thư mục target vào container
COPY target/myapp.jar /app/myapp.jar

# Expose port 8080 để ứng dụng có thể truy cập được
EXPOSE 2003

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
