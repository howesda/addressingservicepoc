FROM java:8-jdk

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY addressingservicepoc.jar /usr/src/app/
COPY route.properties /usr/src/app/
COPY run.sh /usr/src/app/
COPY datasource.properties /usr/src/app/

EXPOSE 8081
EXPOSE 8091

ENTRYPOINT /usr/src/app/run.sh
