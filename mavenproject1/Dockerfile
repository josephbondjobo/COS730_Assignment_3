#FROM anapsix/alpine-java
#FROM maven:3.3-jdk-8
#FROM maasencioh/glassfish-maven:latest
FROM maasencioh/glassfish-maven:latest
COPY ./target/Executions-1.0-SNAPSHOT.war /home/Executions-1.0-SNAPSHOT.war
COPY . .
CMD mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run

#FROM glassfish:5.0


# FROM microsoft/mssql-server-linux
# COPY ./target/Executions-1.0-SNAPSHOT.war .

# CMD mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run

#FROM glassfish:latest
#COPY ./target/Executions-1.0-SNAPSHOT.war /
#COPY ./start.sh /

EXPOSE 8080
EXPOSE 4848

#ENTRYPOINT ["/start.sh"]
