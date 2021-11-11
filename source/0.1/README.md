# myRx Project

Built from Maven archetype: spring-ws-archetype (org.springframework.ws)

To build the project:
### mvn package

## Directory Structure:
- src/pom.xml
- src/main/java/cmsc495/{java source files}
- src/main/resources/{css, images, ect}
- src/main/webapp/WEB-INF/{jsp, html templates, ect}

## /pom.xml #
Tells Maven how to build the project and which dependencies are needed.

## /src/main/webapp/WEB-INF/web.xml #
Tells the app server how to deliver web content to the user (html, css, ect)

## /src/main/webapp/WEB-INF/spring-ws-servlet.xml #
Bean definitions for Spring
