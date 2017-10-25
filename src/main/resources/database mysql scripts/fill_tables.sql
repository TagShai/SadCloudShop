INSERT INTO `categories` (`id`, `name`) VALUES
    (1, "shirts"),
    (2, "shoes");

INSERT INTO `products` (`id`, `name`, `price`, `description`, `full_description`, `novelty`, `category_id`) VALUES
    (1, 'yung lean shirt', 120, "Yung lean shirt", "Luckyfridayf Harajuku kyoto sad boys 2002 unknown death", true, 1),
    (2, 'twenty one pilot shirt', 80, "twenty one pilot description", "twenty one pilots shirts super", false, 1);

INSERT INTO `users` (`id`, `email`, `password`, `active`) VALUES
    (1, 'user1@gmail.com', 'user1_password', true),
    (2, 'user2@gmail.com', 'user2_password', false),
    (3, 'user3@gmail.com', 'user3_password', true);

INSERT INTO `roles` (`id`, `name`) VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
    (1, 1),
    (2, 2),
    (3, 2);