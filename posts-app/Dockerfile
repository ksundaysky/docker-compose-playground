FROM gradle:7.2.0-jdk17 AS build
COPY --chown=gradlew:gradlew . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew bootJar

FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/posts-app-0.0.1-SNAPSHOT.jar /app/postsapp.jar

ENTRYPOINT ["java","-jar","/app/postsapp.jar"]