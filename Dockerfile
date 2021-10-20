FROM gradle:7.2-jdk11-hotspot AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

EXPOSE 3001

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/echo-ip.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/echo-ip.jar"]