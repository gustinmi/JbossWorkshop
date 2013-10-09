CREATE TABLE `users` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL DEFAULT '0',
    `password` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name` (`name`)
);

INSERT INTO `users` (`id`, `name`, `password`) VALUES (1, 'janez', 'janez');
INSERT INTO `users` (`id`, `name`, `password`) VALUES (2, 'miha', 'miha');