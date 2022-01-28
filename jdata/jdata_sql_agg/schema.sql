CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    id           int NOT NULL,
    name         varchar(255),
    surname      varchar(255),
    age          tinyint,
    phone_number varchar(25),
    CHECK (age >= 0 AND age <= 120),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ORDERS
(
    id           int NOT NULL AUTO_INCREMENT,
    date         TIMESTAMP DEFAULT now(),
    customer_id  int,
    product_name varchar(255),
    amount       int,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);