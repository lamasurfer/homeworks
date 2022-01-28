# mysql> SELECT * FROM CUSTOMERS;
# +----+--------+-----------+------+--------------+
# | id | name   | surname   | age  | phone_number |
# +----+--------+-----------+------+--------------+
# |  1 | John   | Doe       |   28 | +79261111111 |
# |  2 | Jane   | Doe       |   30 | +79262222222 |
# |  3 | aLeXeY | Mixed     |    5 | +79263333333 |
# |  4 | alexey | Lowercase |    3 | +79264444444 |
# |  5 | Alexey | Normal    |   25 | +79265555555 |
# |  6 | ALEXEY | Uppercase |   35 | +79266666666 |
# +----+--------+-----------+------+--------------+
# 6 rows in set (0.01 sec)
#
# mysql> SELECT * FROM ORDERS;
# +----+---------------------+-------------+----------------+--------+
# | id | date                | customer_id | product_name   | amount |
# +----+---------------------+-------------+----------------+--------+
# |  1 | 2021-04-02 11:25:46 |           1 | Windows 10     |      5 |
# |  2 | 2021-04-02 11:25:46 |           2 | WinRAR         |      5 |
# |  3 | 2021-04-02 11:25:46 |           3 | IDEA Ultimate  |      1 |
# |  4 | 2021-04-02 11:25:46 |           4 | UltraEdit      |      1 |
# |  5 | 2021-04-02 11:25:46 |           5 | Uninstall Tool |      1 |
# |  6 | 2021-04-02 11:25:46 |           6 | Windows 95     |      1 |
# +----+---------------------+-------------+----------------+--------+
# 6 rows in set (0.00 sec)

# т.к. по умолчанию для VARCHAR в mysql поиск case-insensitive всех Алексеев ищем так

SELECT CUSTOMERS.name, CUSTOMERS.surname, ORDERS.product_name
FROM CUSTOMERS
INNER JOIN ORDERS
ON CUSTOMERS.id = ORDERS.customer_id
WHERE name = 'aLeXey';

# mysql> SELECT CUSTOMERS.name, CUSTOMERS.surname, ORDERS.product_name
#     -> FROM CUSTOMERS
#     -> INNER JOIN ORDERS
#     -> ON CUSTOMERS.id = ORDERS.customer_id
#     -> WHERE name = 'aLeXey';
# +--------+-----------+----------------+
# | name   | surname   | product_name   |
# +--------+-----------+----------------+
# | aLeXeY | Mixed     | IDEA Ultimate  |
# | alexey | Lowercase | UltraEdit      |
# | Alexey | Normal    | Uninstall Tool |
# | ALEXEY | Uppercase | Windows 95     |
# +--------+-----------+----------------+
# 4 rows in set (0.00 sec)

# алексея lowercase независимо от ввода можно найти например так

SELECT CUSTOMERS.name, CUSTOMERS.surname, ORDERS.product_name
FROM CUSTOMERS
INNER JOIN ORDERS
ON CUSTOMERS.id = ORDERS.customer_id
WHERE name = BINARY LOWER('aLeXey');

# mysql> SELECT CUSTOMERS.name, CUSTOMERS.surname, ORDERS.product_name
#     -> FROM CUSTOMERS
#     -> INNER JOIN ORDERS
#     -> ON CUSTOMERS.id = ORDERS.customer_id
#     -> WHERE name = BINARY LOWER('aLeXey');
# +--------+-----------+--------------+
# | name   | surname   | product_name |
# +--------+-----------+--------------+
# | alexey | Lowercase | UltraEdit    |
# +--------+-----------+--------------+
# 1 row in set (0.00 sec)
