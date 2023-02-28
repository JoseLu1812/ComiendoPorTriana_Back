
# Comiendo Por Triana

ApiRest realizada en Spring Boot, cuenta con base de datos en H2 y PostgreSql(se explica en el siguiente apartado). tambien cuenta con documentacion con Swagger-ui.

Trata sobre una red social a estilo foro de opiniones de bares de triana.

## Perfiles

Dispone de 2 perfiles:

 - Developer (dev): cuenta con una base de datos en H2.
 - Production (prod): base de datos administrada en PostgreSql, implementada mediante un "DockerCompose", creando un contenedor para esta.


Para cambiar en perfil, entrando en el application.properties, basta con poner en el apartado: "spring.profiles.active=", justo después del igual, "dev" o "prod". Con el perfil "prod", ejecutar antes de arrancar la API, "docker compose up" en la terminal. 


## Entidades

Cuenta con tres entidades:

### Bar

Aquí se gestionan todos los bares, restaurantes... Es la entidad principal, y en las que las demás se basan. Todo el mundo puede ver uno varios bares, pero solo los usuarior propietarios (BARMAN), pueden crearlos y administrarlos. 

### Coment

Aquí se gestionan los comentarios de los bares. Todos los usuarios pueden crear uno o varios comentarios, pero solo sus dueños de estos pueden editarlos o eliminarlos.

## User

Aqui se encuentra la gestión de usuarios de la aplicación. La aplicación cuenta con dos tipos de usuarios: BARMAN y CLIENT.

A continuación algunos usuarios de ejemplo:

#### Propietarios
- Username: "Joseluhn"      Contraseña: "Master_1812"
- Username: "CSainz55"      Contraseña: "Ferrari_55"
- Username: "MPilarnt"      Contraseña: "Mairena_123"

#### Clientes
- Username: "PdelaRosa"     Contraseña: "Bahrein_2005"
- Username: "ConchiHV"      Contraseña: "Cordoba_123"
- Username: "PaquirriH"     Contraseña: "Arcangel_123"



