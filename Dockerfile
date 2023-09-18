FROM openjdk:11-jdk-slim
COPY target/*.jar product-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/product-service.jar", "-Dspring.profiles.active=test"]