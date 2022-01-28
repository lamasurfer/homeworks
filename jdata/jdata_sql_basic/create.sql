CREATE TABLE PERSONS
(
    name           varchar(50),
    surname        varchar(50),
    age            tinyint,
    phone_number   varchar(25),
    city_of_living varchar(50),
    CHECK (age >= 0 AND age <= 120),
    PRIMARY KEY (name, surname, age)
);