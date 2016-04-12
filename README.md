# Address Gateway Service #
## Overview ##
The Address Gateway Service is a camel application that acts as a common route to an address lookup service. It exposes two http endpoints; one which exposes a REST interface, the other which exposes a SOAP interface. Both routes result in a call to a central address service.

The service supports two operations
- it retrieves a list of addresses matching a full or partial postcode
- it retrieves the single address which matches the specified uprn

The REST endpoint can be addressed as follows
- http://localhost:8081/addresses/postcode/WA36XF
- http://localhost:8081/addresses/uprn/1223454

The SOAP endpoint is can be found at http://localhost:8082/OnDemand-2011-03/. Examples of the messages that can be processed can be found in the SoapUI project in the src/main/soap-ui folder

## Running ##
The application is built as a "fat jar" file and can be run from the command line as follows
>java -jar addressingservicepoc-0.0.1-SNAPSHOT.jar

## Supporting Projects ##
Within the same GitLab group there are two additional projects
- addressproviderstub provides a very basic emulation of the OS Places web service. It will probably need significant beefing up
- addressservice-ui acts as a simple UI, allowing a user to enter a postcode and execute the search against the Address Gateway Service

Both of these run as web applications and are deployed to a Tomcat container as part of the CI build.
