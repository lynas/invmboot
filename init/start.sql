INSERT INTO `app_user` (`id`, `full_name`, `password`, `user_name`) VALUES
  (1, 'Md Sazzad Islam', 'e10adc3949ba59abbe56e057f20f883e', 'sazzad');

INSERT INTO `user_role` (`id`, `name`) VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');

INSERT INTO `app_user_roles` (`app_user_id`, `roles_id`) VALUES
  (1, 1),
  (1, 2);