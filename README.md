## metaphorce-diagnostic

> Docker 

- Ingresar a la ruta
  ... \ms-database-lib
  - Ejecutar 
    > docker compose up
    
> Creacion BD y registros

CREATE TABLE "public"."rol" (
    "idrol" int4 NOT NULL DEFAULT nextval('rol_idrol_seq'::regclass),
    "nombre" varchar(50) NOT NULL,
    PRIMARY KEY ("idrol")
);
  
  INSERT INTO "public"."rol" ("idrol", "nombre") VALUES
  (1, 'Tester');
  INSERT INTO "public"."rol" ("idrol", "nombre") VALUES
  (2, 'Admin');

CREATE TABLE Usuario (
    idUsuario SERIAL PRIMARY KEY,
    nombreUsuario VARCHAR(50) NOT NULL,
    contrasenia VARCHAR(100) NOT NULL,
    idRol INT NOT NULL,
    FOREIGN KEY (idRol) REFERENCES Rol(idRol)
);

INSERT INTO usuario (nombreUsuario, contrasenia, idrol) 
VALUES ('user1', 'contrasenia1', 1),
       ('user2', 'contrasenia2', 2);

> Build Jar DatabaseLib

- Abrir ms-database-lib
  > Realizar clean install

> Build Jar DatabaseLib

- Iniciar los microservicios
  > \ms-auth-web : 8005
  > \ms-user-web : 8080

## Autenticacion


- Debemos iniciar sesion para generar el codigo de acceso
  * Podemos realizarlo mediante web http://127.0.0.1:8080//oauth2/authorization/user-web
  * Igualmente podemos enviar un post a http://127.0.0.1:8005/login
    Sera necesario enviar el body como formulario username : periodontal y password : 12345

- Se generara un codigo como el siguiente "D_ELVpyM4DHkawXRX6toOmyRapgiEPFfKo2HVvxj-mj8FOGqkoiMzRl0z_W8t-Ixy6y2K-WXPSPWRWjsXujTgL-1yf6oIeD1-LCbOHhRpze8W0NzBg-SU8H15ZbkeaVZ"

- Una vez obtenido podemos autenticarnos hacia http://127.0.0.1:8005/oauth2/token
  *  Es necesario enviar en el body code : "codigo_obtenido" , grant_type: authorization_code, redirect_uri : http://127.0.0.1:8080/authorized

- Obtendremos el JWT que nos permitira el acceso a los enpoints con los usuarios autorizados
  * Debemos enviar el token a los enpoints correspondientes como un **Bearer Token** : "JWT"

- Ahora podremos alcanzar
 * http://127.0.0.1:8080/createUser
 * http://127.0.0.1:8080/getUsers


### Nota:
Las collections para probar los enpoints estan en el repositorio
       
  


