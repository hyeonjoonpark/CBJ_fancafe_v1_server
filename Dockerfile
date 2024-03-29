FROM openjdk:17
ARG JAR_FILE=build/libs/fancafe.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
