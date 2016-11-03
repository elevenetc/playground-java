FROM ubuntu

RUN apt-get update
RUN apt-get dist-upgrade -y

RUN DEBIAN_FRONTEND=noninteractive apt-get -y dist-upgrade
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install python-software-properties
RUN DEBIAN_FRONTEND=noninteractive apt-get -y install software-properties-common

RUN DEBIAN_FRONTEND=noninteractive echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN apt-get install -y oracle-java8-installer
RUN rm -rf /var/lib/apt/lists/*
RUN rm -rf /var/cache/oracle-jdk8-installer

WORKDIR /data
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV SLACK_TOKEN ""
CMD ["./gradlew", "clean", "jar"]
CMD ["java" "-jar" "./build/libs/playground-java.jar"]
