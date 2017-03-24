create database if not exists Software;
use Software;
create table users (
	id BIGINT (6),
	name VARCHAR (32),
	password VARCHAR (32),
	PRIMARY KEY (id)
);

create table recipes (
	id BIGINT (6),
	name VARCHAR (32),
	total_time BIGINT (6),
	people BIGINT (6),
	user BIGINT (6),
	PRIMARY KEY (id),
	FOREIGN KEY (user) references users(id)
);

create table utensils (
	id BIGINT (6),
	name VARCHAR (32),
	PRIMARY KEY (id)
);

create table ingredients (
	id BIGINT (6),
	name VARCHAR (32),
	PRIMARY KEY (id)	
);

create table use_1 (
	recipe BIGINT (6),
	utensil BIGINT (6),
	PRIMARY KEY (recipe, utensil),
	FOREIGN KEY (recipe) references recipes(id),
	FOREIGN KEY (utensil) references utensils(id)
);

create table use_2 (
	recipe BIGINT (6),
	ingredient BIGINT (6),
	quantity BIGINT (6),
	PRIMARY KEY (recipe, ingredient),
	FOREIGN KEY (recipe) references recipes(id),
	FOREIGN KEY (ingredient) references ingredients(id)
);

create table steps (
	step BIGINT (6),
	time BIGINT (6),
	information VARCHAR (500),
	recipe BIGINT (6),
	PRIMARY KEY (step, recipe),
	FOREIGN KEY (recipe) references recipes(id)
);


create table use_3 (
	step BIGINT (6),
	recipe BIGINT (6),
	ingredient BIGINT (6),
	PRIMARY KEY (step,recipe, ingredient),
	FOREIGN KEY (recipe) references steps(recipe),
	FOREIGN KEY (step) references steps(step),
	FOREIGN KEY (ingredient) references ingredients(id)
);

create table use_4 (
	step BIGINT (6),
	recipe BIGINT (6),
	utensil BIGINT (6),
	PRIMARY KEY (step,recipe, utensil),
	FOREIGN KEY (recipe) references steps(recipe),
	FOREIGN KEY (step) references steps(step),
	FOREIGN KEY (utensil) references utensils(id)
);
