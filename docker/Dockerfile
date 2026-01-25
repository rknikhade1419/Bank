# Use a stable OpenJDK 8 image
FROM openjdk:8-jdk-alpine

# Port the bank app runs on
EXPOSE 8070

# Define app directory
ENV APP_HOME /usr/src/app

# UPDATED: Matches the new artifactId from your pom.xml
COPY target/banking-system-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

# Use exec form for better signal handling
ENTRYPOINT ["java", "-jar", "app.jar"]
