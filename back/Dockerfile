FROM maven:3.9-eclipse-temurin-11 AS build

RUN mkdir -p /workspace
WORKDIR /workspace

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package -DskipTests


FROM eclipse-temurin:11-jdk

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]