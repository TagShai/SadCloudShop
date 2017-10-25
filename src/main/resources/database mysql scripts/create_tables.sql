CREATE TABLE IF NOT EXISTS `categories` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100)
    -- `parent_category_id` INTEGER,

    -- FOREIGN KEY (parent_category_id) REFERENCES categories (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `products` (
    `id`  INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `description` VARCHAR(100),
    `full_description` TEXT,
    `novelty` BIT NOT NULL,
    `category_id` INTEGER,

    FOREIGN KEY (category_id) REFERENCES categories (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `active` BIT NOT NULL
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `roles` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `user_roles` (
    `user_id` INTEGER NOT NULL,
    `role_id` INTEGER NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;