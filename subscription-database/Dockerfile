FROM mysql:5.7.15

ENV MYSQL_ROOT_PASSWORD=root \
    MYSQL_USER=adidas_user \
    MYSQL_PASSWORD=adidas_password \
	MYSQL_DATABASE=subscription_db

ADD script.sql /docker-entrypoint-initdb.d

EXPOSE 3306