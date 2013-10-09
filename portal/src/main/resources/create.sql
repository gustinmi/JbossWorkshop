CREATE TABLE `users` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL DEFAULT '0',
    `password` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name` (`name`)
);

CREATE TABLE `log` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `message` VARCHAR(50) NOT NULL DEFAULT '0',
    `timestamp` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
);