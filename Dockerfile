FROM openjdk:17
ARG JAR_FILE=./build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8000
ENTRYPOINT [ "java",
#"-Dspring.datasource.url=jdbc:mysql://${host.docker.internal}:3306/test?rewriteBatchedStatements=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul",
"-jar",
"/app.jar" ]