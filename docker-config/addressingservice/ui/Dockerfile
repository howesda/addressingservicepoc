FROM tomcat:8-jre8

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY addresslookup.war /usr/local/tomcat/webapps

COPY app.props /usr/src/app/app.props

COPY setenv.sh /usr/local/tomcat/bin/setenv.sh

