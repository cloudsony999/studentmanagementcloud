FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar studentmanagement-0.0.1-SNAPSHOT.jar.jar
ENTRYPOINT ["java","-jar","/target/studentmanagement-0.0.1-SNAPSHOT.jar"]
