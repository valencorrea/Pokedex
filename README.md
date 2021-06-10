# Simulacion de Pokedex

### · · · Caracteristicas del modelo · · · 
  Simulacion de una Pokedex, la cual tiene como funcionalidades principales:
  
    - el listado de todos los entrenadores, pokemones y datos específicos de un pokemon en particular,
    - la recuperacion de un pokemon desde la base de datos,
    - la actualización de todos los campos de un pokemon.
    
El modelo se desarrollo siguiendo el patron MVC. Por otro lado, cuenta con interfaz grafica e interaccion con el usuario, incluyendo seguridad para el registro de estos, ademas de solicitudes a la base de datos.


### · · · Metodologias usadas · · · 
  El proyecto Maven se desarrollo usando Java en la parte del back, junto al framework Spring. Los datos que se necesitan usar se levantan desde la base de datos h2 integrada en Java. Para la parte del front, se utilizan formularios HTML levantados en el puerto 9090 localhost, y Javascript (Jquery, Ajax).
  
Para las tests hechas a las clases pertenecientes al service, se utilizo el framework JUnit, las cuales validan tanto casos ideales como el correcto lanzado de excepciones.


### · · · Log in · · · 
  Los usuarios que tendran acceso a la pagina son los entrenadores que se encuentran en la base de datos. El ingreso podra hacerse para cualquiera de ellos siguiendo: 
  
    User: Entrenador
    Pass: entrenadorENTRENADOR01

en donde entrenador equivale a alguno de los nombres registrados.


### · · · Corrida · · · 

###  · · · Detalles sobre la implementacion · · · 

###  · · · Elecciones de diseño · · · 

###  · · · Galeria de imagenes · · · 
