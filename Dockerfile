FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

COPY target/belajar-spring-restful-api.jar belajar-spring-restful-api.jar
COPY src/main/resources/application.properties config/application.properties

ENTRYPOINT ["java", "-jar", "belajar-spring-restful-api.jar", "--spring.config.location=file:config/"]
