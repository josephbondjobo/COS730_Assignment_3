FROM oracle/glassfish

COPY  ./Executions-1.0-SNAPSHOT.WAR ${GLASHFISH_HOME}/glassfish5/glassfish/domains/domain1/autodeploy

# FROM microsoft/mssql-server-linux
# COPY ./target/Executions-1.0-SNAPSHOT.war .

# CMD mvn clean verify org.codehaus.cargo:cargo-maven2-plugin:run

#FROM glassfish:latest
#COPY ./target/Executions-1.0-SNAPSHOT.war /
#COPY ./start.sh /

EXPOSE 8080
EXPOSE 4848

#ENTRYPOINT ["/start.sh"]