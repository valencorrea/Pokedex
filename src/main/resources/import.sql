/* * * * * * * * * * * Tabla de datos de entidades * * * * * * * * * */

/* Tabla de entrenadores */

INSERT INTO entrenadores (id,nombre) VALUES(0, 'Ash');
INSERT INTO entrenadores (id,nombre) VALUES(1, 'Misty');
INSERT INTO entrenadores (id,nombre) VALUES(2, 'Brock');
INSERT INTO entrenadores (id,nombre) VALUES(3, 'Rojo');
INSERT INTO entrenadores (id,nombre) VALUES(4, 'Azul');
INSERT INTO entrenadores (id,nombre) VALUES(5, 'Oak');

/* Tabla de pokemones */

INSERT INTO pokemones (id,nombre,nivel) VALUES (0,'Pikachu',1);
INSERT INTO pokemones (id,nombre,nivel) VALUES (1,'Charmander',2);
INSERT INTO pokemones (id,nombre,nivel) VALUES (2,'Bolbasour',3);
INSERT INTO pokemones (id,nombre,nivel) VALUES (3,'Ratata',4);
INSERT INTO pokemones (id,nombre,nivel) VALUES (4,'Rauchu',21);
INSERT INTO pokemones (id,nombre,nivel) VALUES (5,'Charmeleon',22);
INSERT INTO pokemones (id,nombre,nivel) VALUES (6,'Charizard',32);
INSERT INTO pokemones (id,nombre,nivel) VALUES (7,'Ivasaur',23);
INSERT INTO pokemones (id,nombre,nivel) VALUES (8,'Venusaur',33);
INSERT INTO pokemones (id,nombre,nivel) VALUES (9,'Ratacate',24);
INSERT INTO pokemones (id,nombre,nivel) VALUES (10,'Pidgey',5);
INSERT INTO pokemones (id,nombre,nivel) VALUES (11,'Pidgeotto',15);
INSERT INTO pokemones (id,nombre,nivel) VALUES (12,'Pidgeot',25);
INSERT INTO pokemones (id,nombre,nivel) VALUES (13,'Meowth',6);
INSERT INTO pokemones (id,nombre,nivel) VALUES (14,'Persian',16);

/* Tabla de habilidades */

INSERT INTO habilidades (id,nombre) VALUES (0,'Impactrueno');
INSERT INTO habilidades (id,nombre) VALUES (1,'Volar');
INSERT INTO habilidades (id,nombre) VALUES (2,'Correr');
INSERT INTO habilidades (id,nombre) VALUES (3,'Envenenar');
INSERT INTO habilidades (id,nombre) VALUES (4,'Relampago de Voltajes');
INSERT INTO habilidades (id,nombre) VALUES (5,'Flexibilidad');
INSERT INTO habilidades (id,nombre) VALUES (6,'Mar Llamas');
INSERT INTO habilidades (id,nombre) VALUES (7,'Torrente');
INSERT INTO habilidades (id,nombre) VALUES (8,'Vista Lince');
INSERT INTO habilidades (id,nombre) VALUES (9,'Agallas');
INSERT INTO habilidades (id,nombre) VALUES (10,'Espesura');

/* Tabla de Tipos */

INSERT INTO tipos (id,nombre) VALUES (0,'Planta');
INSERT INTO tipos (id,nombre) VALUES (1,'Veneno');
INSERT INTO tipos (id,nombre) VALUES (2,'Fuego');
INSERT INTO tipos (id,nombre) VALUES (3,'Volador');
INSERT INTO tipos (id,nombre) VALUES (4,'Agua');
INSERT INTO tipos (id,nombre) VALUES (5,'Bicho');
INSERT INTO tipos (id,nombre) VALUES (6,'Normal');
INSERT INTO tipos (id,nombre) VALUES (7,'Electrico');
INSERT INTO tipos (id,nombre) VALUES (8,'Tierra');
INSERT INTO tipos (id,nombre) VALUES (9,'Hada');

/* Tabla de evoluciones*/

INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (0,'Super', 4, 'fuego');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (1,'Mega', 5, 'agua');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (2,'Hiper', 2, 'tierra');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (3,'Super Roja', 8, 'tierra');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (4,'Mega verde', 2, 'aire');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (5,'Hiper Blanca', 5, 'agua');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (6,'Normal', 1, 'nieve');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (7,'Electrico', 3, 'tierra');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (8,'Tierra', 2, 'viento');
INSERT INTO evoluciones (id,nombre,nivel_necesario, tipo) VALUES (9,'Hada', 2, 'agua');



/* * * * * * * * * * * Tabla de datos de relaciones entre entidades * * * * * * * * * */

/* Tabla de relación Pokemon con Habilidad*/

INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (0,0); /* Pikachu - Impactrueno*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (3,2); /* Ratata - Correr*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (0,4); /* Pikachu - Impactrueno*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (1,6); /* Charmander - Mar Llamas*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (5,6); /* Charmeleon - Mar Llamas*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (6,6); /* Charizard - Mar Llamas*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (2,10); /* Bolbasaur - Espesura*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (7,10); /* Ivasaur - Espesura*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (8,10); /* Venusaur - Espesura*/

/* Tabla de relación Pokemon con Tipo*/

INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (0,7); /* Pikachu - Eléctrico*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (0,6); /* Pikachu - Normal*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (3,5); /* Ratata - Bicho*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (3,6); /* Ratata - Normal*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (1,2); /* Charmander - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (5,2); /* Charmeleon - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (6,2); /* Charizard - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (6,3); /* Charizard - Volador*/

/* Tabla de relación Pokemon con Evolucion*/

INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (0,6);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (0,3);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (3,1);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (3,8);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (1,4);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (5,3);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (6,9);
INSERT INTO pokemon_evolucion (pokemon_id,evolucion_id) VALUES (6,2);