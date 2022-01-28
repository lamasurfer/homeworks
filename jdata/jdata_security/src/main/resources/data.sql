INSERT IGNORE INTO roles (authority)
VALUES ('ROLE_READ'),
       ('ROLE_WRITE'),
       ('ROLE_DELETE');


INSERT IGNORE INTO users (username, password, enabled)
VALUES ('john', '$2a$10$II.53w5gMxP0XtI230a6xui2MEiP/L1jpslsAjS69trpk3vmjUFWi', 1),
       ('ivan', '$2a$10$hwrGt/oUbYXcHtwOE1YI2ufwvXbqf/3zo5PqjIye5hnL/cG3ohPme', 1),
       ('scott', '$2a$10$YSUb6SThvCUtgR9DRTfmqObvNpIXj5WA6xDihaHVRRwwNHO2x0B9K', 1);

INSERT IGNORE INTO authorities (username, authority)
VALUES ('john', 'ROLE_READ'),
       ('john', 'ROLE_WRITE'),
       ('john', 'ROLE_DELETE'),
       ('ivan', 'ROLE_READ'),
       ('ivan', 'ROLE_WRITE'),
       ('scott', 'ROLE_READ');

INSERT IGNORE INTO person (name, surname, age, phone_number, city_of_living)
VALUES ('John', 'Doe', 20, '+79261111111', 'Moscow'),
       ('Jill', 'Doe', 22, '+79262222222', 'Moscow'),
       ('Jeff', 'Doe', 23, '+79263333333', 'Paris'),
       ('Jane', 'Doe', 25, '+79264444444', 'London'),
       ('Jack', 'Doe', 20, '+79265555555', 'Moscow');
