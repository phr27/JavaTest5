FROM registry.saas.hand-china.com/tools/mysql:5.7.17
COPY ./docker/mysql/sakila* /
RUN cat /sakila-schema.sql > /docker-entrypoint-initdb.d/dump.sql && \
cat /sakila-data.sql >> /docker-entrypoint-initdb.d/dump.sql