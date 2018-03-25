[![Build Status](https://travis-ci.org/ainochu/subscription-service.png?branch=master)](https://travis-ci.org/ainochu/subscription-service)


# Subscription-service

This is a demo project of a RESTful service subscription application. This application is written in Java 1.8.
It is composed of four microservices:

| Service | Description |
| --- | --- |
| subscription-service | is the main rest service of the application. Here, users can register inside the application. |
| event-service/email-service | mock services that receive data from registering users. |
| subscription-database | contain the schema of the application. |

# Requirements
 - Java 8
 - Apache Maven 3.5
 - docker 17

# Building

```
cd ./project_folder/
mvn clean package
```

This will generate a .jar file inside /target directory.


# Profiles of application

We can find two different type of profiles:

| Profile | Description |
| --- | --- |
| default | for run the application witout docker with `java -jar` or `mvn spring-boot:run` |
| docker | each Dockerfile specifies this profile when the java application is started |

Note: if you want to use the docker profile, use this command:

```
mvn spring-boot:run -Dspring.profiles.active=docker
```

# Dockerizing

```
docker-compose up --build
```

Docker is another powerful tool for developing and delivering.

After running the commands above you can browse http://localhost:8080/ to see it working.



# Dependencies

### Spring Boot Framework
It's basically a suite, pre-configured, pre-sugared set of frameworks/technologies to reduce boiler plate configuration providing you the shortest way to have a Spring web application up and running with smallest line of code/configuration out-of-the-box. 
Used to create a simple RESTful application up and running with almost zero configuration. 
[Spring Boot Framework](http://projects.spring.io/spring-boot/)

### SpringFox
Automated JSON API documentation for API's built with Spring. Used for creating the subscription-service documentation.
[SpringFox](https://github.com/springfox/springfox)

### Orika
Used for create the subscription's mapper inside application.
[Orika](https://orika-mapper.github.io/orika-docs/index.html)

When the application started, you can browse http://localhost:8080/swagger-ui.html#/ to see it working.

### Mysql connection
Used to create the schema database of the application and save the data of the subscribe user.
[MySQL](https://www.mysql.com/)

# Continuous Integration
Automated the CI of the application with Travis. With the .travis.yml file, automatically compile subscription-service in [this url](https://travis-ci.org/ainochu/subscription-service)
Inside the .travis.yml file, you can find the following options:
  - **language** Java with oracle jdk8.
  - **M2 cache** for faster builds
  - **mvn package** to compile/install and package the application with its dependencies.
  - **codecov** to generate coverage report from unit test. (TODO in the future)




