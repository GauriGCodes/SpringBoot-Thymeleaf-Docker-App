# SpringBoot-Thymeleaf-Docker-App


# Configured End Points 

/students 
Returns the list of all the students

/students/{id}
Returns the student with id supplied in the URL. 

/students/{id}/courseRegistered
Returns the Courses Registered by student with supplied id in the URL

/students/{id}/courseRegistered/{coursenumber}
Returns the course having courseNumber registered by student with id supplied in the URL

# Components

- maven (pom.xml) configured with dependencies of SpringBoot Web, Thymeleaf.
- Index.html - single page web application written with HTML,CSS,Jquery and Bootstrap. 
- Controller - Configured with above mentioned end-points
- Service - Interacts with Database and load results in Model and return it back to controller.
- Model - Created according to the JSON Database.  
- Control flow and business logic are independent of one another.

# Docker File
 - Docker File is executes the jar created in the target folder. 

# Please follow the below steps to run the application 

1) clone the repo
2) cd to the repo
3) mvn clean package
4) docker build --tag=csigraduatestudent-api:latest .
5) docker run -p8080:8080 csigraduatestudent-api:latest
