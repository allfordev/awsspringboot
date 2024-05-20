FROM eclipse-temurin
#FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

#COPY target/classes .
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

#CMD java -classpath classes com.allfordev.demo3.Demo3Application
ENTRYPOINT ["java","-jar","/app.jar"]