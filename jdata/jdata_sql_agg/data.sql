INSERT IGNORE INTO CUSTOMERS (id, name, surname, age, phone_number)
VALUES ('1', 'John', 'Doe', '28', '+79261111111'),
       ('2', 'Jane', 'Doe', '30', '+79262222222'),
       ('3', 'aLeXeY', 'Mixed', '5', '+79263333333'),
       ('4', 'alexey', 'Lowercase', '3', '+79264444444'),
       ('5', 'Alexey', 'Normal', '25', '+79265555555'),
       ('6', 'ALEXEY', 'Uppercase', '35', '+79266666666');

INSERT IGNORE INTO ORDERS (customer_id, product_name, amount)
VALUES (1, 'Windows 10', 5),
       (2, 'WinRAR', 5),
       (3, 'IDEA Ultimate', 1),
       (4, 'UltraEdit', 1),
       (5, 'Uninstall Tool', 1),
       (6, 'Windows 95', 1);
