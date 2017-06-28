FROM openjdk:8-alpine
MAINTAINER u6k.apps@gmail.com

# Setup Application
RUN mkdir /opt
COPY target/spec-engine.jar .

# Setup docker run setting
EXPOSE 8080

CMD ["java", "-jar", "/opt/spec-engine.jar"]
