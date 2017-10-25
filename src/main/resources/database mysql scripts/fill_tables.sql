INSERT INTO `categories` (`id`, `name`) VALUES
    (1, "shirts"),
    (2, "shoes");

INSERT INTO `products` (`id`, `name`, `price`, `description`, `full_description`, `novelty`, `category_id`) VALUES
    (1, 'yung lean shirt', 120, "Yung lean shirt", "Luckyfridayf Harajuku kyoto sad boys 2002 unknown death", true, 1),
    (2, 'twenty one pilot shirt', 80, "twenty one pilot description", "twenty one pilots shirts super", false, 1);