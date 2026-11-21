# chessbase_back

API REST con Spring Boot 2.5 y MySQL (mayo de 2023, ciclo de DAM) para gestionar ejercicios, equipos y usuarios de ajedrez, con autenticación por JWT. El cliente que la usa es [chessbase_front](https://github.com/IkerAbad/chessbase_front).

## Rutas

- `/auth`: `POST /signin` (devuelve el JWT), `POST /signup` y `POST /logout`.
- `/users`, `/teams` y `/exercises`: alta (`POST`), listado (`GET`) y borrado (`DELETE /{id}`); `/users` también tiene `PUT`.
- Los `GET` de usuarios, equipos y ejercicios, y el `POST` y `DELETE` de ejercicios, están abiertos. El resto exige el token en la cabecera `Authorization`.
- Swagger configurado con springfox, y una colección de Postman en la raíz con ejemplos (con datos de prueba).

## Cómo arrancarla

Necesita Java 17 y un MySQL con una base llamada `chessbase_back`.

```
./mvnw spring-boot:run
```

Por defecto escucha en el puerto 8080 y se conecta a `jdbc:mysql://localhost:3306/chessbase_back` con el usuario `user` y la contraseña `user`. Se puede cambiar con las variables de entorno `DB_URL`, `DB_USER`, `DB_PASS` y `JWT_SECRET` (si no se define, se usa una clave de ejemplo que no vale para nada real).

Aviso: CORS y los permisos de la configuración son los de un proyecto de clase y no están pensados para producción.

He comprobado que compila con Java 17 (`mvn compile`); no la he arrancado contra un MySQL desde aquí.

## Licencia

MIT, ver [LICENSE](LICENSE).

---

# chessbase_back (English)

A REST API with Spring Boot 2.5 and MySQL (May 2023, DAM vocational course) to manage chess exercises, teams and users, with JWT authentication. Its client is [chessbase_front](https://github.com/IkerAbad/chessbase_front).

## Routes

- `/auth`: `POST /signin` (returns the JWT), `POST /signup` and `POST /logout`.
- `/users`, `/teams` and `/exercises`: create (`POST`), list (`GET`) and delete (`DELETE /{id}`); `/users` also has `PUT`.
- The `GET`s of users, teams and exercises, and the `POST` and `DELETE` of exercises, are open. Everything else needs the token in the `Authorization` header.
- Swagger set up with springfox, and a Postman collection in the root with examples (with test data).

## Running it

It needs Java 17 and a MySQL with a database called `chessbase_back`.

```
./mvnw spring-boot:run
```

By default it listens on port 8080 and connects to `jdbc:mysql://localhost:3306/chessbase_back` with user `user` and password `user`. This can be changed with the environment variables `DB_URL`, `DB_USER`, `DB_PASS` and `JWT_SECRET` (if unset, a sample key is used, which is worthless for anything real).

A word of caution: the CORS and permission setup is that of a class project and is not meant for production.

I checked that it compiles with Java 17 (`mvn compile`); I have not started it against a MySQL from here.

## License

MIT, see [LICENSE](LICENSE).
