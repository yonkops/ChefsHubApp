
INSERT INTO users (id, email, first_name, last_name, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 'user@example.com', 'User', 'Userov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');



INSERT INTO users_roles(`user_entity_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);
