#docker file for java exec deployment
FROM tomcat:9.0-jre8-alpine
COPY target/dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar /dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar
CMD ["java -jar dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar"]
