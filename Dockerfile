FROM openjdk:8-jdk-alpine

ARG JAR_FILE=build/libs/automation-portal-0.0.3.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8881
CMD java -jar app.jar
