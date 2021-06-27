FROM openjdk:11
ARG JAR_FILE=target/docker_SB_2.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]