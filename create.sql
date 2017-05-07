create database if not exists prsoft;
use prsoft;
drop table if exists use_4;
drop table if exists use_3;
drop table if exists steps;
drop table if exists use_2;
drop table if exists use_1;
drop table if exists ingredients;
drop table if exists utensils;
drop table if exists recipes;
drop table if exists users;

create table users (
	id BIGINT (6) auto_increment ,
	name VARCHAR (50) unique not null,
	password VARCHAR (50) not null,
	PRIMARY KEY (id)
);

create table recipes (
	id BIGINT (6) auto_increment ,
	name VARCHAR (32) not null,
	total_time BIGINT (6) not null,
	person BIGINT (6) not null,
	user BIGINT (6),
	outstanding INT(1) not null default 0,
	picture LONGBLOB,
	PRIMARY KEY (id),
	FOREIGN KEY (user) references users(id)
);

create table utensils (
	id BIGINT (6) auto_increment,
	name VARCHAR (32) not null,
	PRIMARY KEY (id)
);

create table ingredients (
	id BIGINT (6) auto_increment,
	name VARCHAR (32) not null,
	PRIMARY KEY (id)	
);

create table use_1 (
	recipe BIGINT (6) ,
	utensil BIGINT (6) ,
	PRIMARY KEY (recipe, utensil),
	FOREIGN KEY (recipe) references recipes(id),
	FOREIGN KEY (utensil) references utensils(id)
);

create table use_2 (
	recipe BIGINT (6) ,
	ingredient BIGINT (6) ,
	quantity BIGINT (6) not null,
	PRIMARY KEY (recipe, ingredient),
	FOREIGN KEY (recipe) references recipes(id),
	FOREIGN KEY (ingredient) references ingredients(id)
);

create table steps (
	step BIGINT (6) ,
	time BIGINT (6) not null,
	information VARCHAR (500) not null,
	recipe BIGINT (6) ,
	PRIMARY KEY (step, recipe),
	FOREIGN KEY (recipe) references recipes(id)
);


create table use_3 (
	step BIGINT (6) ,
	recipe BIGINT (6) ,
	quantity BIGINT (6) not null,
	ingredient BIGINT (6) ,
	PRIMARY KEY (step,recipe, ingredient),
	FOREIGN KEY (recipe) references steps(recipe),
	FOREIGN KEY (step) references steps(step),
	FOREIGN KEY (ingredient) references ingredients(id)
);

create table use_4 (
	step BIGINT (6) ,
	recipe BIGINT (6) ,
	utensil BIGINT (6) ,
	PRIMARY KEY (step,recipe, utensil),
	FOREIGN KEY (recipe) references steps(recipe),
	FOREIGN KEY (step) references steps(step),
	FOREIGN KEY (utensil) references utensils(id)
);
