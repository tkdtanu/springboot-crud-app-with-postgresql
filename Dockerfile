FROM openjdk:11-jre-slim
COPY /target/user-crud-app-with-postgress*.jar /app.jar
EXPOSE 9191
ENTRYPOINT ["java","-jar","/app.jar"]
