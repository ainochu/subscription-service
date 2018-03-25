FROM mysql:5.7.15

ENV MYSQL_ROOT_PASSWORD=root \
    MYSQL_USER=adidas_user \
    MYSQL_PASSWORD=adidas_password

ADD script.sql /docker-entrypoint-initdb.d

RUN /etc/init.d/mysql start

EXPOSE 3306