# Start with a base image containing Java runtime
#FROM openjdk:23-jdk
#
## Make port 8088 available to the world outside this container
#EXPOSE 8080
#ADD . /input-webapp
#WORKDIR /input-webapp
#ENTRYPOINT ./mvnw spring-boot:runcat

FROM tomcat:9-jdk8
WORKDIR usr/local/tomcat
# Declare the build argument
ARG ARTIFACT_ID=jspdemo
ARG VERSION=0.0.2

# Set an environment variable using the artifactId
ENV APP_NAME=${ARTIFACT_ID}_${VERSION}
RUN rm -rf webapps/*
COPY target/${APP_NAME}.war webapps/${APP_NAME}.war
EXPOSE 8080
CMD ["catalina.sh", "run"]