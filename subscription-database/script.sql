USE subscription_db;

CREATE TABLE IF NOT EXISTS subscription (
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