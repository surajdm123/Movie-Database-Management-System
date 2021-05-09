  CREATE DATABASE movies;
  
  CREATE TABLE `movies`.`genre` (
  `genre_id` INT NOT NULL AUTO_INCREMENT,
  `genre_name` VARCHAR(100) NOT NULL,
  `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`genre_id`),
  UNIQUE INDEX `genre_name_UNIQUE` (`genre_name` ASC) VISIBLE);
  
  CREATE TABLE `movies`.`language` (
  `language_id` INT NOT NULL AUTO_INCREMENT,
  `language_name` VARCHAR(100) NOT NULL,
  `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`language_id`),
  UNIQUE INDEX `language_name_UNIQUE` (`language_name` ASC) VISIBLE);
  
    CREATE TABLE `movies`.`country` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(100) NOT NULL,
  `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`country_id`),
  UNIQUE INDEX `country_name_UNIQUE` (`country_name` ASC) VISIBLE);
  
  CREATE TABLE `movies`.`movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `genre_id` INT,
  `language_id` INT,
  `country_id` INT,
  `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `updated` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`movie_id`),
  FOREIGN KEY (`genre_id`) REFERENCES `genre`(`genre_id`),
  FOREIGN KEY (`language_id`) REFERENCES `language`(`language_id`),
  FOREIGN KEY (`country_id`) REFERENCES `country`(`country_id`));
  