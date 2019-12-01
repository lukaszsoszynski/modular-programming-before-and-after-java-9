FROM bitnami/postgresql:9.6

ENV POSTGRESQL_PASSWORD=postgres
ENV POSTGRESQL_DATABASE=forum

WORKDIR /docker-entrypoint-initdb.d

COPY scheme.sql .
