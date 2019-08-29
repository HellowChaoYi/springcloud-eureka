FROM java:8
VOLUME /tmp
ADD spring-user-0.0.1-SNAPSHOT.jar spring-user.jar
EXPOSE 8091
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-user.jar"]
