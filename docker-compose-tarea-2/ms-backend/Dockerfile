FROM gradle:4.10-jdk8-alpine as compiler
COPY --chown=gradle:gradle . /home/app/
WORKDIR /home/app
RUN apk update
RUN gradle build bootJar --stacktrace

FROM openjdk:8-jdk-alpine
WORKDIR /home/app
EXPOSE 1115
COPY --from=compiler /home/app/build/libs/ /home/app
CMD ["java","-jar","ms-backend.jar"]

