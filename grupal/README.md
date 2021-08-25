# Pokedex-lite-en-grupo

Implementación del TP Pokedex-Lite en forma colaborativa.
## Diagrama ER

```plantuml
entity Entrenador {
    * id
    + name
    }
entity Pokemon {
    * id
    + name
    + nivel
    }
entity Tipo {
    * id
    + name
    + descripcion
    }
entity Habilidad {
    * id
    + name
    + descripcion
    }

          Entrenador||..|{ Pokemon : "tiene"
          Pokemon}|--|{ Tipo : "posee"
          Pokemon }|--|{ Habilidad : "posee"

```
## Rutas
### Entrenador
#### 1. Listado de entrenadores:  
El listado muestra:  
   - id 
   - nombre       

El endpoint:
   - entrenador/
#### 2. Buscar un entrenador por Id:
Muestra:
- id
- nombre

El endpoint:
- entrenador/{id}