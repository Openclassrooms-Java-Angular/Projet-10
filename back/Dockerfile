# utiliser une image officielle de Maven basée sur Java 11
FROM maven:3.9-eclipse-temurin-11 AS build

# définir le répertoire de travail
WORKDIR /workspace

# copier le fichier pom.xml et télécharger les dépendances avec mise en cache
COPY pom.xml .
RUN mvn -B dependency:go-offline

# copier les sources du projet et construire l'application avec mise en cache
COPY src ./src
RUN mvn -B clean package -DskipTests

# utiliser une image officielle de Java 11 pour exécuter l'application
FROM eclipse-temurin:11-jre

# nouveau répertoire de travail
WORKDIR /app

# copier le fichier jar généré
COPY --from=build /workspace/target/*.jar app.jar

# exposer le port pour accéder à l'application
EXPOSE 8080

# renseigner le point d'entrée de l'application
ENTRYPOINT ["java", "-jar", "app.jar"]