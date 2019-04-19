CREATE DATABASE tv_company;
\c shop;

CREATE TABLE tv_chennel (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(80) UNIQUE,
	description VARCHAR(200)
	);

CREATE TABLE subscriber (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(80) UNIQUE NOT NULL
	);
	
CREATE TABLE favorite_chennel (
	id_subscriber BIGINT NOT NULL, 
	id_chennel BIGINT NOT NULL,
	PRIMARY KEY (id_subscriber, id_chennel),
	FOREIGN KEY (id_subscriber) REFERENCES subscriber(id) ON DELETE NO ACTION,
	FOREIGN KEY (id_chennel) REFERENCES tv_chennel(id) ON DELETE NO ACTION
	);
	
INSERT INTO tv_chennel (name, description) VALUES  
('chennel #1', 'chennel #1 description'),
('chennel #2', 'chennel #2 description'),
('chennel #3', 'chennel #3 description'),
('chennel #4', 'chennel #4 description'),
('chennel #5', 'chennel #5 description'),
('chennel #6', 'chennel #6 description');


INSERT INTO subscriber (name) VALUES
('subscriber #1'),
('subscriber #2'),
('subscriber #3');


INSERT INTO favorite_chennel (id_subscriber, id_chennel) VALUES
(1, 1),
(1, 6),
(2, 2),
(2, 5),
(3, 1),
(3, 2),
(3, 5);