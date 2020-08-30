FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/restful-web-services-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "restful-web-services-0.0.1-SNAPSHOT.jar"]