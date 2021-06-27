FROM openjdk:11
ARG JAR_FILE=target/docker_SB_3.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]