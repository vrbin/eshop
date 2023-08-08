FROM openjdk:17-oracle
EXPOSE 8080
COPY target/eshop-1.0-SNAPSHOT.jar eshop.jar
ENTRYPOINT ["java", "-jar", "eshop.jar"]