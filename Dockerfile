# Pull base image
FROM openjdk:8-stretch
# Copy compiled jar into image
COPY ./target/docker-test.jar docker-test.jar
# Expose ports
EXPOSE 8100

# Run Spring ppliction
CMD ["java", "-jar", "docker-test.jar"]