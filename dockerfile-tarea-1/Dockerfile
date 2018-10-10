FROM node:6.14-alpine

LABEL maintainer="dparada8817@gmail.com"

EXPOSE 3000

ENV APP_DIR /usr/src/app

RUN mkdir -p $APP_DIR

WORKDIR $APP_DIR

COPY . .

RUN apk update \
    && apk add --update tini \
    && npm install \ 
    && npm cache clean --force 

ENTRYPOINT ["/sbin/tini", "node", "./bin/www"]