/* Tabla de entrenadores */
INSERT INTO entrenadores (id,nombre) VALUES(1, 'Ash');
INSERT INTO entrenadores (id,nombre) VALUES(2, 'Misty');
INSERT INTO entrenadores (id,nombre) VALUES(3, 'Brock');
INSERT INTO entrenadores (id,nombre) VALUES(4, 'Rojo');
INSERT INTO entrenadores (id,nombre) VALUES(5, 'Azul');
INSERT INTO entrenadores (id,nombre) VALUES(6, 'Oak');

/* Tabla de pokemones */
INSERT INTO pokemones (id,nombre,nivel) VALUES (1,'Pikachu',1);
INSERT INTO pokemones (id,nombre,nivel) VALUES (2,'Charmander',2);
INSERT INTO pokemones (id,nombre,nivel) VALUES (3,'Bolbasour',3);
INSERT INTO pokemones (id,nombre,nivel) VALUES (4,'Ratata',4);
INSERT INTO pokemones (id,nombre,nivel) VALUES (5,'Rauchu',21);
INSERT INTO pokemones (id,nombre,nivel) VALUES (6,'Charmeleon',22);
INSERT INTO pokemones (id,nombre,nivel) VALUES (7,'Charizard',32);
INSERT INTO pokemones (id,nombre,nivel) VALUES (8,'Ivasaur',23);
INSERT INTO pokemones (id,nombre,nivel) VALUES (9,'Venusaur',33);
INSERT INTO pokemones (id,nombre,nivel) VALUES (10,'Ratacate',24);
INSERT INTO pokemones (id,nombre,nivel) VALUES (11,'Pidgey',5);
INSERT INTO pokemones (id,nombre,nivel) VALUES (12,'Pidgeotto',15);
INSERT INTO pokemones (id,nombre,nivel) VALUES (13,'Pidgeot',25);
INSERT INTO pokemones (id,nombre,nivel) VALUES (14,'Meowth',6);
INSERT INTO pokemones (id,nombre,nivel) VALUES (15,'Persian',16);

/* Tabla de habilidades */
INSERT INTO habilidades (id,nombre) VALUES (1,'Impactrueno');
INSERT INTO habilidades (id,nombre) VALUES (2,'Volar');
INSERT INTO habilidades (id,nombre) VALUES (3,'Correr');
INSERT INTO habilidades (id,nombre) VALUES (4,'Envenenar');
INSERT INTO habilidades (id,nombre) VALUES (5,'Relampago de Voltajes');
INSERT INTO habilidades (id,nombre) VALUES (6,'Flexibilidad');
INSERT INTO habilidades (id,nombre) VALUES (7,'Mar Llamas');
INSERT INTO habilidades (id,nombre) VALUES (8,'Torrente');
INSERT INTO habilidades (id,nombre) VALUES (9,'Vista Lince');
INSERT INTO habilidades (id,nombre) VALUES (10,'Agallas');
INSERT INTO habilidades (id,nombre) VALUES (11,'Espesura');


/* Tabla de Tipos */
INSERT INTO tipos (id,nombre) VALUES (1,'Planta');
INSERT INTO tipos (id,nombre) VALUES (2,'Veneno');
INSERT INTO tipos (id,nombre) VALUES (3,'Fuego');
INSERT INTO tipos (id,nombre) VALUES (4,'Volador');
INSERT INTO tipos (id,nombre) VALUES (5,'Agua');
INSERT INTO tipos (id,nombre) VALUES (6,'Bicho');
INSERT INTO tipos (id,nombre) VALUES (7,'Normal');
INSERT INTO tipos (id,nombre) VALUES (8,'Electrico');
INSERT INTO tipos (id,nombre) VALUES (9,'Tierra');
INSERT INTO tipos (id,nombre) VALUES (10,'Hada');

/* Tabla de relación Pokemon con Habilidad*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (1,1); /* Pikachu - Impactrueno*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (4,3); /* Ratata - Correr*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (1,5); /* Pikachu - Impactrueno*/

INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (2,7); /* Charmander - Mar Llamas*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (6,7); /* Charmeleon - Mar Llamas*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (7,7); /* Charizard - Mar Llamas*/

INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (3,11); /* Bolbasaur - Espesura*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (8,11); /* Ivasaur - Espesura*/
INSERT INTO pokemon_habilidad (pokemon_id,habilidad_id) VALUES (9,11); /* Venusaur - Espesura*/

/* Tabla de relación Pokemon con Tipo*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (1,8); /* Pikachu - Eléctrico*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (1,7); /* Pikachu - Normal*/

INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (4,6); /* Ratata - Bicho*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (4,7); /* Ratata - Normal*/

INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (2,3); /* Charmander - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (6,3); /* Charmeleon - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (7,3); /* Charizard - Fuego*/
INSERT INTO pokemon_tipo (pokemon_id,tipo_id) VALUES (7,4); /* Charizard - Volador*/


/* Tabla de Evoluciones Evoluciona_a*/
/*TODO: pokemon deberia de tener un tabla que sea el nivel de cada pokemon al estilo (id,nivel)  o que esta tabla tenga pares (pokemon_id,nivel)unico */
INSERT INTO evoluciona_a (pokemon_inicial_id,pokemon_evolucion_id) VALUES (1,5); /* pikachu - raichu*/

INSERT INTO evoluciona_a (pokemon_inicial_id,pokemon_evolucion_id) VALUES (2,6); /* Charmander - Charmeleon*/
INSERT INTO evoluciona_a (pokemon_inicial_id,pokemon_evolucion_id) VALUES (6,7); /* Charmeleon - Charizard*/

INSERT INTO evoluciona_a (pokemon_inicial_id,pokemon_evolucion_id) VALUES (3,8); /* Bolbasaur - Ivasaur*/
INSERT INTO evoluciona_a (pokemon_inicial_id,pokemon_evolucion_id) VALUES (8,9); /* Ivasaur - Venasaur*/

/* Tabla de Pokemon_en_entrenamiento */
INSERT INTO pokemon_en_entrenamiento (id,nivel_actual,entrenador_id,pokemon_id) VALUES (1,11,1,1); /* ash tiene a Pikachu con nivel 10 */
INSERT INTO pokemon_en_entrenamiento (id,nivel_actual,entrenador_id,pokemon_id) VALUES (2,5,1,4); /* ash tiene a Ratata con nivel 4 */

INSERT INTO pokemon_en_entrenamiento (id,nivel_actual,entrenador_id,pokemon_id) VALUES (3,14,1,2); /* ash tiene a Charmander con nivel 14 */
INSERT INTO pokemon_en_entrenamiento (id,nivel_actual,entrenador_id,pokemon_id) VALUES (4,20,1,3); /* ash tiene a Bolbasaur con nivel 20 */