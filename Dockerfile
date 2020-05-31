FROM openjdk:12
VOLUME /temp
EXPOSE 8081
ADD ./target/microservicios-items-0.0.1-SNAPSHOT.jar item.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=America/Bogota",  "/item.jar"]