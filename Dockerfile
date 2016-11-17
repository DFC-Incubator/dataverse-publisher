#docker file for java exec deployment
FROM tomcat:9.0-jre8-alpine
COPY target/something.jar /usr/local/dv/something.jar

