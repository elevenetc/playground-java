FROM ubuntu
MAINTAINER Eugene Levenetc

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean
ENV SLACK_TOKEN ""

RUN ls
RUN pwd
ADD . /usr/local/playground-java
WORKDIR /usr/local/playground-java
RUN ./gradlew clean jar
#RUN java -jar ./build/libs/playground-java.jar
#CMD ["./gradlew", "clean", "jar"]
#CMD ["echo", "`begin`"]
#CMD ["echo", "./build/libs/playground-java.jar"]
#CMD ["echo", "`end`"]
#CMD ["java", "-jar", "./build/libs/playground-java.jar"]
