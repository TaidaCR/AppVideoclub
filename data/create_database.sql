CREATE TABLE "generos" (
	"id"	INTEGER,
	"descripcion"	TEXT,
	PRIMARY KEY("id")
);

CREATE TABLE "directores" (
	"id"	INTEGER,
	"nombre"	TEXT,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id")
);

CREATE TABLE "artistas" (
	"id"	INTEGER,
	"nombre"	TEXT,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id")
);

CREATE TABLE "peliculas" (
	"id"	INTEGER,
	"titulo"	TEXT,
	"id_director"	INTEGER,
	"anyo"	INTEGER,
	"url_caratula"	TEXT,
	"id_genero"	INTEGER,
	"es_animacion"	INTEGER,
	FOREIGN KEY("id_genero") REFERENCES "generos"("id"),
	FOREIGN KEY("id_director") REFERENCES "directores"("id")
);

CREATE TABLE "repartos" (
	"id_pelicula"	INTEGER,
	"id_artista"	INTEGER,
	PRIMARY KEY("id_pelicula")
);

INSERT INTO directores (nombre, url_foto, url_web) VALUES 
('Christopher Nolan', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg/440px-Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg', 'https://en.wikipedia.org/wiki/Christopher_Nolan'),
('Quentin Tarantino', 'https://upload.wikimedia.org/wikipedia/commons/2/23/Quentin_Tarantino_by_Gage_Skidmore.jpg', 'https://en.wikipedia.org/wiki/Quentin_Tarantino'),
('Martin Scorsese', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Martin_Scorsese_Cannes_2010.jpg/440px-Martin_Scorsese_Cannes_2010.jpg', 'https://en.wikipedia.org/wiki/Martin_Scorsese'),
('Steven Spielberg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Steven_Spielberg_Cannes_2013.jpg/440px-Steven_Spielberg_Cannes_2013.jpg', 'https://en.wikipedia.org/wiki/Steven_Spielberg'),
('James Cameron', 'https://upload.wikimedia.org/wikipedia/commons/9/9d/James_Cameron_Navy_Birthday_Ball_cropped.jpg', 'https://en.wikipedia.org/wiki/James_Cameron');

INSERT INTO artistas (id, nombre, url_foto, url_web) VALUES 
(1, 'Leonardo DiCaprio', 'https://upload.wikimedia.org/wikipedia/commons/8/8d/Leonardo_DiCaprio_2016.jpg', 'https://en.wikipedia.org/wiki/Leonardo_DiCaprio'),
(2, 'Martin Scorsese', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Martin_Scorsese_Cannes_2010.jpg/440px-Martin_Scorsese_Cannes_2010.jpg', 'https://en.wikipedia.org/wiki/Martin_Scorsese'),
(3, 'Quentin Tarantino', 'https://upload.wikimedia.org/wikipedia/commons/2/23/Quentin_Tarantino_by_Gage_Skidmore.jpg', 'https://en.wikipedia.org/wiki/Quentin_Tarantino'),
(4, 'Steven Spielberg', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Steven_Spielberg_Cannes_2013.jpg/440px-Steven_Spielberg_Cannes_2013.jpg', 'https://en.wikipedia.org/wiki/Steven_Spielberg'),
(5, 'Christopher Nolan', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg/440px-Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg', 'https://en.wikipedia.org/wiki/Christopher_Nolan');

INSERT INTO peliculas (id, titulo, id_director, anyo, url_caratula, id_genero, es_animacion) VALUES 
(1,'Inception', 5, 2010, 'https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg', 9, 0), 
(2,'Pulp Fiction', 3, 1994, 'https://upload.wikimedia.org/wikipedia/en/3/3b/Pulp_Fiction_%281994%29_poster.jpg', 11, 0), 
(3,'The Dark Knight', 5, 2008, 'https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg', 2, 0), 
(4,'Schindlers List', 4, 1993, 'https://upload.wikimedia.org/wikipedia/en/3/38/Schindler%27s_List_movie.jpg', 7, 0), 
(5,'Shutter Island', 2, 2010, 'https://upload.wikimedia.org/wikipedia/en/7/76/Shutterislandposter.jpg', 7, 0),
(6,'The Departed', 2, 2006, 'https://upload.wikimedia.org/wikipedia/en/5/50/Departed234.jpg', 7, 0), 
(7,'Django Unchained', 3, 2012, 'https://upload.wikimedia.org/wikipedia/en/8/8b/Django_Unchained_Poster.jpg', 2, 0), 
(8,'Avatar', 5, 2009, 'https://upload.wikimedia.org/wikipedia/en/b/b0/Avatar-Teaser-Poster.jpg', 9, 0); 
