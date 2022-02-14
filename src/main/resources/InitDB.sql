CREATE SCHEMA `my_stream` ;

CREATE TABLE `my_stream`.`notes` (
                                     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                     `date` DATETIME NOT NULL,
                                     `name` VARCHAR(45) NOT NULL,
                                     `text` VARCHAR(600) NOT NULL,
                                     PRIMARY KEY (`id`));

INSERT INTO `my_stream`.`notes` (`date`, `name`, `text`) VALUES ('2020-10-10', 'Name_1', 'Text_1');
INSERT INTO `my_stream`.`notes` (`date`, `name`, `text`) VALUES ('2020-10-11', 'Name_2', 'Text_2');
INSERT INTO `my_stream`.`notes` (`date`, `name`, `text`) VALUES ('2020-10-12', 'Name_3', 'Text_3');
INSERT INTO `my_stream`.`notes` (`date`, `name`, `text`) VALUES ('2020-10-13', 'Name_4', 'Text_4');
