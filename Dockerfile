FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=target/springboot-backend.jar
ADD ${JAR_FILE} springboot-backend.jar
ENTRYPOINT ["java","-jar","springboot-backend.jar"]

