FROM tomcat:latest

LABEL maintainer="Miguel P"

ADD ./target/SpringBootApp-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]