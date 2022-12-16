FROM eclipse-temurin:19.0.1_10-jre-alpine
LABEL maintainer="none@email.com"
VOLUME /main-app
ADD build/libs/spring-boot-mysql-base-project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]