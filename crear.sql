create table Usuario (
	Id NUMBER (6),
	Nombre VARCHAR (32),
	Password VARCHAR (32),
	PRIMARY KEY (Id)
);

create table Recetas (
	Id NUMBER (6),
	Nombre VARCHAR (32),
	Tiempo_total NUMBER (6),
	Personas NUMBER (6),
	Usuario NUMBER (6),
	PRIMARY KEY (Id),
	FOREIGN KEY (Usuario) references Usuario(Id)
);

create table Utensilios (
	Id NUMBER (6),
	Nombre VARCHAR (32),
	PRIMARY KEY (Id)
);

create table Ingredientes (
	Id NUMBER (6),
	Nombre VARCHAR (32),

	PRIMARY KEY (Id)	
);

create table Usa(
	Recetas NUMBER (6),
	Utensilios NUMBER (6),
	PRIMARY KEY (Recetas, Utensilios),
	FOREIGN KEY (Recetas) references Recetas(Id),
	FOREIGN KEY (Utensilios) references Utensilios(Id)
);

create table Usa_2(
	Recetas NUMBER (6),
	Ingredientes NUMBER (6),
	Cantidad NUMBER (6),
	PRIMARY KEY (Recetas, Ingredientes),
	FOREIGN KEY (Recetas) references Recetas(Id),
	FOREIGN KEY (Ingredientes) references Ingredientes(Id)
);

create table pasos(
	Numero NUMBER (6),
	Tiempo NUMBER (6),
	Informacion VARCHAR (500),
	Recetas NUMBER (Id),
	Utensilios NUMBER (Id),
	Ingredientes NUMBER (Id),
	PRIMARY KEY (Numero, Recetas),
	FOREIGN KEY (Recetas) references Recetas(Id),
	FOREIGN KEY (Ingredientes) references Ingredientes(Id),
	FOREIGN KEY (Utensilios) references Utensilios(Id)
);



