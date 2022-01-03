FROM openjdk

RUN mkdir -p /app/endereco

ENV APP_NAME=arquivo.jar

COPY ${APP_NAME} /app/endereco

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/endereco/arquivo.jar" ]