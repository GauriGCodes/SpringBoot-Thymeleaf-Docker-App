# SpringBoot-Thymeleaf-Docker-App
Repository is created for CS 612 - Assignment - 6

Please follow the below steps to run the application 

1) clone the repo
2) cd to the repo
3) mvn clean package
4) docker build --tag=csigraduatestudent-api:latest .
5) docker run -p8080:8080 csigraduatestudent-api:latest