FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/subscription-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT [ "sh", "-c", "java -jar -Dspring.profiles.active=docker /app.jar" ]