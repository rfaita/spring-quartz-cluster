FROM openjdk:15-alpine

VOLUME /tmp
RUN apk add --no-cache netcat-openbsd &&\
    apk add --no-cache bash &&\
    apk add -U tzdata &&\
    cp -f /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime

ARG JAR_FILE
ARG UTIL_DIR
ENV JAVA_OPTS "-Xmx512m -Xms256m"

RUN addgroup -S javauser && adduser -S javauser -G javauser
WORKDIR /home/javauser

ADD ${UTIL_DIR}wait-for-it.sh ./wait-for-it.sh
ADD ${UTIL_DIR}entrypoint.sh ./entrypoint.sh

RUN chmod +x ./wait-for-it.sh &&\
    chmod +x ./entrypoint.sh

ADD ${JAR_FILE} app.jar
USER javauser
ENTRYPOINT ["/home/javauser/entrypoint.sh"]