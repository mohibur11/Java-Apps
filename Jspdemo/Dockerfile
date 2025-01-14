# Start with a base image containing Java runtime
FROM openjdk:23-jdk

# Make port 8088 available to the world outside this container
EXPOSE 8080
ADD . /input-webapp
WORKDIR /input-webapp
ENTRYPOINT ./mvnw spring-boot:run

