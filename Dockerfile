FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=target/springboot-backend.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]




