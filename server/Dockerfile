# Pull base image
FROM openjdk:8-stretch
MAINTAINER Viktar Lebedzeu <vlebedzeu@gmail.com>

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib /usr/share/lib

# Copy compiled jar into image
# ARG JAR_FILE
# COPY target/${JAR_FILE} ${JAR_FILE}
COPY target/docker-test-server.jar docker-test-server.jar

# Expose ports
EXPOSE 8100

# Run Spring ppliction
# CMD ["java", "-jar", "${JAR_FILE}"]
CMD ["java", "-jar", "docker-test-server.jar"]
