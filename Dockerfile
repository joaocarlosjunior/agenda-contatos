FROM tomcat:9.0.86-jdk17

COPY target/agenda-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]