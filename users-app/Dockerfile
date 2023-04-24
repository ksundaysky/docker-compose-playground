FROM gradle:7.2.0-jdk17 AS build
COPY --chown=gradlew:gradlew . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew BootJar

FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/users-app-0.0.1-SNAPSHOT.jar /app/usersapp.jar

ENTRYPOINT ["java","-jar","/app/usersapp.jar"]