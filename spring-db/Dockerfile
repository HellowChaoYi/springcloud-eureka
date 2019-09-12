FROM java:8
VOLUME /tmp
ADD springdb-0.0.1-SNAPSHOT.jar springdb.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springdb.jar"]
