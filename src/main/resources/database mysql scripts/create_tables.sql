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