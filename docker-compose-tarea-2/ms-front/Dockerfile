FROM node:6.14-alpine AS builder
WORKDIR /home/app
COPY . .
RUN apk update && npm install && npm run build

FROM nginx:1.13-alpine
EXPOSE 80 443
COPY --from=builder /home/app/dist/ /var/www/dist/app
COPY ./conf/ /etc/nginx/conf.d/
RUN mkdir -p /home/app/logs
