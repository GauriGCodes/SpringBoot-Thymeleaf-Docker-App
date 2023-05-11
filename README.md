# SpringBoot-Thymeleaf-Docker-App
Repository is created for CS 612 - Assignment - 6

# Configured End Points 

/students 
Returns the list of all the students

/students/{id}
Returns the student with id supplied in the URL. 

/students/{id}/courseRegistered
Returns the Courses Registered by student with supplied id in the URL

/students/{id}/courseRegistered/{coursenumber}
Returns the course having courseNumber registered by student with id supplied in the URL





# Please follow the below steps to run the application 

1) clone the repo
2) cd to the repo
3) mvn clean package
4) docker build --tag=csigraduatestudent-api:latest .
5) docker run -p8080:8080 csigraduatestudent-api:latest
