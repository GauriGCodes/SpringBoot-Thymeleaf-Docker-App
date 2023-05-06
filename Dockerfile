FROM openjdk:8-jdk-alpine
MAINTAINER Gauri Gupta
EXPOSE 8080
COPY target/*.jar CSGraduateStudentsApi-0.0.1.jar
ENTRYPOINT ["java","-jar","/CSGraduateStudentsApi-0.0.1.jar"]