FROM openjdk:8-jdk-alpine

LABEL maintainer=pawel.wojtowicz@trapezegroup.pl

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/Configuration-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} configurationTool.jar

ENTRYPOINT["java","-Djava.security.edg=file:/dev/./urandom","-jar","/configurationTool.jar"]
