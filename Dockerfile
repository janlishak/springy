FROM openjdk:8-jdk-alpine
MAINTAINER Jan Lishak
VOLUME /tmp
EXPOSE 8080
ADD target/springbootpostgresqldocker-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/springbootpostgresqldocker.jar"]
