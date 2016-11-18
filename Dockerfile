#docker file for java exec deployment
FROM java:8
COPY target/dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar /dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar", "dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar"]
