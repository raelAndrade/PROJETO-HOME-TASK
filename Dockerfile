FROM openjdk:8
ADD target/docker-embrace.jar docker-embrace.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "docker-embrace.jar"]