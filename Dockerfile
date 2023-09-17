FROM openjdk:11-jdk-slim
COPY target/*.jar product-service.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "/product-service.jar", "-Dspring.profiles.active=test"]