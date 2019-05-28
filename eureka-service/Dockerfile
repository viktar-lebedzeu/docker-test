# Pull base image
FROM openjdk:8-stretch
MAINTAINER Viktar Lebedzeu <vlebedzeu@gmail.com>

# Installing curl *inux package
RUN apt-get update
RUN apt-get install -y curl

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib /usr/share/lib

# Copy compiled jar into image
ARG JAR_FILE
# COPY target/${JAR_FILE} /opt/server/${JAR_FILE}
COPY target/${JAR_FILE} /opt/server/docker-test-eureka-service.jar

# Expose ports
EXPOSE 8761

# Run Spring appliction
# RUN ["ls", "-lah", "/"]
# RUN ["ls", "-lah", "/opt"]
RUN ["ls", "-lah", "/opt/server"]
CMD ["java", "-jar", "/opt/server/docker-test-eureka-service.jar"]
