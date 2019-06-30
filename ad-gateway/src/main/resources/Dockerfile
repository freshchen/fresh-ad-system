FROM openjdk:8u212
MAINTAINER freshchen
VOLUME /tmp
ADD ad-gateway-1.0-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8801
ENTRYPOINT ["echo","172.18.0.2 localhost",">>","/etc/hosts"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]