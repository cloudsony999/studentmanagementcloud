FROM openjdk:8-jdk-alpine
COPY target/studentmanagement-0.0.1-SNAPSHOT.jar myserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/myserver-0.0.1-SNAPSHOT.jar"]