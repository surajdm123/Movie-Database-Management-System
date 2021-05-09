
-- Insert records in genre table
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Action');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Comedy');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Thriller');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Crime');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Fantasy');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Romance');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Adventure');
INSERT INTO `movies`.`genre` (`genre_name`) VALUES ('Sci-Fi');

-- Insert records in language table
INSERT INTO `movies`.`language` (`language_name`) VALUES ('English');
INSERT INTO `movies`.`language` (`language_name`) VALUES ('Kannada');
INSERT INTO `movies`.`language` (`language_name`) VALUES ('Telugu');
INSERT INTO `movies`.`language` (`language_name`) VALUES ('Tamil');
INSERT INTO `movies`.`language` (`language_name`) VALUES ('Malyalam');
INSERT INTO `movies`.`language` (`language_name`) VALUES ('Hindi');

-- Insert records in country table
INSERT INTO `movies`.`country` (`country_name`) VALUES ('India');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('United States');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('Mexico');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('Canada');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('Germany');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('France');
INSERT INTO `movies`.`country` (`country_name`) VALUES ('Vietnam');

-- Insert records in movie table
INSERT INTO `movies`.`movie` (`title`, `genre_id`, `language_id`, `country_id`) VALUES ('Avengers: Infinity War', '1', '1', '2');
INSERT INTO `movies`.`movie` (`title`, `genre_id`, `language_id`, `country_id`) VALUES ('Avengers: End Game', '1', '1', '2');

