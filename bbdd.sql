DROP DATABASE IF EXISTS tpv_practice;
CREATE DATABASE tpv_practice;
USE tpv_practice;

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient(
	id integer not null unique auto_increment,
    name varchar(50),
    constraint PK_Ingredient primary key (id)
);

DROP TABLE IF EXISTS drink;
CREATE TABLE drink(
	id integer not null unique auto_increment,
    name varchar(50),
    price double,
    photo varchar(255),
    hasSugar boolean default true,
    constraint PK_Drink primary key (id)
);

DROP TABLE IF EXISTS burger;
CREATE TABLE burger(
	id integer not null unique auto_increment,
    name varchar(100),
    price integer,
    photo varchar(255),
    isVegan boolean default false,
    hasGluten boolean default true,
    constraint PK_Burger primary key (id)
);

DROP TABLE IF EXISTS burger_ingredient;
CREATE TABLE burger_ingredient(
	id_burger integer not null,
    id_ingredient integer not null,
    constraint PK_Burger_Ingredient primary key (id_burger, id_ingredient),
    constraint FK_Burger_Ingredient_Id_Burger foreign key (id_burger) references burger(id) on delete cascade on update cascade,
    constraint FK_Burger_Ingredient_Id_Ingredient foreign key (id_ingredient) references ingredient(id) on delete cascade on update cascade
);

DROP TABLE IF EXISTS cart;
CREATE TABLE cart(
	id integer not null unique auto_increment,
    quantity integer,
    size enum('S', 'M', 'L'),
    price double,
    iva_price double,
    id_product integer,
    constraint PK_Cart primary key (id),
    constraint FK_Cart_Product_Burger foreign key (id_product) references burger(id) on delete cascade on update cascade,
    constraint FK_Cart_Product_Drink foreign key (id_product) references drink(id) on delete cascade on update cascade
);