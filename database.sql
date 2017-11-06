-- contains the ddl to create the tables needed for this project
-- DB used here is mysql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_address` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_department` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `department` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `name`, `email`)
VALUES
	(1,'user','user@email.com');

INSERT INTO `user_address` (`id`, `user_id`, `address`)
VALUES
	(1,1,'test_address');

INSERT INTO `user_department` (`id`, `user_id`, `department`)
VALUES
	(1,1,'test_department');