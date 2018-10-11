FROM centos:7
ENV RELEASE_PATH target/myapi-swarm.jar
RUN yum install -y \
    java-1.8.0-openjdk-headless \
  && yum clean all

WORKDIR /opt/myapi

ADD ${RELEASE_PATH} /opt/myapi

RUN groupadd -r duser -g 1001 \
    && useradd -u 1001 -r -g duser -d /opt/myapi/ -s /sbin/nologin -c "Docker image user" duser \
    && chown -R duser:duser /opt/myapi/ \
    && chgrp -R 0 /opt/myapi && chmod -R g=u /opt/myapi

USER 1001


EXPOSE 8080

ENV PORT_OFFSET=0
ENV LOGGING_LEVEL=INFO

CMD java -jar /opt/myapi/myapi-swarm.jar \
    -Dswarm.port.offset=${PORT_OFFSET} \
    -Dswarm.logging=${LOGGING_LEVEL}
