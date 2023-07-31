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
    constraint PK_Drink primary key (id)
);

DROP TABLE IF EXISTS burger;
CREATE TABLE burger(
	id integer not null unique auto_increment,
    name varchar(100),
    price integer,
    photo varchar(255),
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
    id_burger integer,
    id_drink integer,
    constraint PK_Cart primary key (id),
    constraint FK_Cart_Id_Burger foreign key (id_burger) references burger(id) on delete cascade on update cascade,
    constraint FK_Cart_Id_Drink foreign key (id_drink) references drink(id) on delete cascade on update cascade
);

-- Fill Database
insert into ingredient(name) values ("bread");
insert into ingredient(name) values ("meat");
insert into ingredient(name) values ("cheese");
insert into ingredient(name) values ("tomato");
insert into ingredient(name) values ("lettuce");
insert into ingredient(name) values ("bacon");
insert into ingredient(name) values ("onion");
insert into ingredient(name) values ("pickles");
insert into ingredient(name) values ("ketchup");
insert into ingredient(name) values ("mayonese");
insert into ingredient(name) values ("mustard");
insert into ingredient(name) values ("BBQ sauce");
insert into ingredient(name) values ("egg");
insert into ingredient(name) values ("chicken");

insert into burger(name, price, photo) values ("Cheese Burger", 5, "https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/4:3/w_3336,h_2502,c_limit/Smashburger-recipe-120219.jpg");
insert into burger(name, price, photo) values ("American Burger", 7, "https://as1.ftcdn.net/v2/jpg/03/34/88/16/1000_F_334881645_vLmn5Hs1YyIYY1r0fcGGNAGZ0HL4ix8T.jpg");
insert into burger(name, price, photo) values ("Chicken Burger", 6, "https://img.freepik.com/premium-photo/big-double-cheddar-cheeseburger-with-chicken-cutlet_147620-1306.jpg");
insert into burger(name, price, photo) values ("BBQ Burger", 6, "https://www.gourmetfleisch.de/shop/images/products/gallery/detail/13980_1.jpg");

insert into drink(name, price, photo) values ("Coca-Cola", 1.5, "https://m.media-amazon.com/images/I/71+PhhPPsHL.jpg");
insert into drink(name, price, photo) values ("Orange Fanta", 1.5, "https://www.encopadebalon.com/3497-large_default/fanta-naranja-pack-24-unidades-33cl.jpg");
insert into drink(name, price, photo) values ("Lemon Fanta", 1.5, "https://www.distribucionesmarpin.es/GM000740/images/products/13303/es/04078.JPG");
insert into drink(name, price, photo) values ("Nestea", 2, "https://www.tumenuenlaoficina.es/wp-content/uploads/2020/11/nestea.jpg");
insert into drink(name, price, photo) values ("Aquarius", 2, "https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/202203/03/00118623900356____12__600x600.jpg");
insert into drink(name, price, photo) values ("Beer", 2, "https://img.freepik.com/fotos-premium/jarra-cerveza-espuma-espesa_159938-839.jpg");

insert into burger_ingredient values (1, 1);
insert into burger_ingredient values (1, 2);
insert into burger_ingredient values (1, 3);
insert into burger_ingredient values (1, 4);
insert into burger_ingredient values (1, 5);
insert into burger_ingredient values (1, 7);
insert into burger_ingredient values (1, 8);
insert into burger_ingredient values (1, 9);
insert into burger_ingredient values (1, 10);

insert into burger_ingredient values (2, 1);
insert into burger_ingredient values (2, 2);
insert into burger_ingredient values (2, 3);
insert into burger_ingredient values (2, 4);
insert into burger_ingredient values (2, 5);
insert into burger_ingredient values (2, 6);
insert into burger_ingredient values (2, 13);
insert into burger_ingredient values (2, 9);
insert into burger_ingredient values (2, 10);

insert into burger_ingredient values (3, 1);
insert into burger_ingredient values (3, 14);
insert into burger_ingredient values (3, 3);
insert into burger_ingredient values (3, 4);
insert into burger_ingredient values (3, 5);
insert into burger_ingredient values (3, 7);
insert into burger_ingredient values (3, 8);
insert into burger_ingredient values (3, 11);

insert into burger_ingredient values (4, 1);
insert into burger_ingredient values (4, 2);
insert into burger_ingredient values (4, 3);
insert into burger_ingredient values (4, 4);
insert into burger_ingredient values (4, 5);
insert into burger_ingredient values (4, 6);
insert into burger_ingredient values (4, 7);
insert into burger_ingredient values (4, 8);
insert into burger_ingredient values (4, 12);

insert into cart(quantity, size, price, iva_price, id_burger) values (1, 'S', 5, 6.05, 1);
insert into cart(quantity, size, price, iva_price, id_drink) values (2, 'M', 2, 2.42, 2);