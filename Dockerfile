FROM java:8-jdk

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY target/addressingservicepoc.jar /usr/src/app/
COPY docker/route.properties /usr/src/app/
COPY docker/run.sh /usr/src/app/
COPY docker/datasource.properties /usr/src/app/

EXPOSE 8081
EXPOSE 8091

ENTRYPOINT /usr/src/app/run.sh
