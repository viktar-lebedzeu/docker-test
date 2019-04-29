# Pull base image
FROM openjdk:8-stretch
MAINTAINER Viktar Lebedzeu <vlebedzeu@gmail.com>

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib /usr/share/lib

# Copy compiled jar into image
ARG JAR_FILE
COPY target/${JAR_FILE} ${JAR_FILE}

# Expose ports
EXPOSE 8100

# Run Spring ppliction
CMD ["java", "-jar", "docker-test.jar"]