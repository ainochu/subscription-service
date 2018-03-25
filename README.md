# Subscription-service

This is a demo project of a RESTful service subscription application. This application is written in Java 1.8.
It is composed of four microservices:
  - Subscription-service: is the main rest service of the application. In this part, the current user register inside application.
  - Event-service/Email-service: receives the data of the registry and return a OK request.
  - Subscription-database: contain the schema of the application.

# Requirements
 -  Java <= 8
 - Apache Maven <= 3.5.2
 - docker >= 17

# Building
    cd /project_folder/
    maven clean package

This will generate a .jar file inside /target directory.


# Dockerizing
docker-compose up

Docker is another powerful tool for developing and delivering. For this project a simple docker image is built from nginx so as to serve the web application.

After running the commands above you can browse http://localhost:8080/ to see it working.



# Dependencies

### Spring Boot Framework
It's basically a suite, pre-configured, pre-sugared set of frameworks/technologies to reduce boiler plate configuration providing you the shortest way to have a Spring web application up and running with smallest line of code/configuration out-of-the-box. 
Used for create a simple RESTful application up and running with almost zero configuration. 
http://projects.spring.io/spring-boot/

### SpringFox
Automated JSON API documentation for API's built with Spring. Used for create the subscription-service documentation.
https://github.com/springfox/springfox

### Orika
Used for create the subscription's mapper inside application.
https://orika-mapper.github.io/orika-docs/index.html

When the application started, you can browse http://localhost:8080/swagger-ui.html#/ to see it working.

### Mysql connection
Used for create the schema database of the application and save the data of the subscribe user.
https://www.mysql.com/





