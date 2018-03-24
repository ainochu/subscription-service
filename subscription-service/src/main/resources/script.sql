create database subscription_db;
create user 'adidas_user'@'localhost' identified by 'adidas_password';
grant all on subscription_db.* to 'adidas_user'@'localhost';

CREATE TABLE IF NOT EXISTS subscription_db.subscription (
  newsletter_id bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  first_name VARCHAR(45),
  agree TINYINT NOT NULL DEFAULT 0,
  gender ENUM('MALE', 'FEMALE') NULL DEFAULT 'MALE',
  date_of_birthday DATE NOT NULL,
  campaign_id bigint(20) NOT NULL,
  PRIMARY KEY (newsletter_id),
  UNIQUE INDEX email_UNIQUE (email ASC))
ENGINE = InnoDB;