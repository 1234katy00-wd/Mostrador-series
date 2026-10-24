# TV Serie

Aplicación web para administrar un catálogo de series. Permite crear una cuenta e iniciar sesión, consultar series y agregar, editar, ver el detalle o eliminar registros.

Este proyecto fue desarrollado como parte de un bootcamp full stack java de Skillnest.

## Tecnologías

- Java 17
- Spring Boot 4
- Spring MVC y Spring Data JPA
- MySQL
- JSP y JSTL
- Maven

## Requisitos

- JDK 17 o superior
- MySQL en ejecución
- Maven (opcional: el proyecto incluye Maven Wrapper)

## Configuración

1. Crea la base de datos en MySQL:

   ```sql
   CREATE DATABASE examenSeries_db;
   ```

2. Abre `src/main/resources/application.properties` y configura las credenciales de MySQL. La URL predeterminada apunta a `localhost:3306/examenSeries_db` y el usuario predeterminado es `root`.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/examenSeries_db
   spring.datasource.username=root
   spring.datasource.password=TU_CONTRASENA
   ```

   Reemplaza `TU_CONTRASENA` por la contraseña de tu entorno local. No guardes credenciales reales en el repositorio.

3. Hibernate actualiza el esquema al iniciar la aplicación (`spring.jpa.hibernate.ddl-auto=update`).

## Ejecutar

Desde la carpeta del proyecto, inicia la aplicación con Maven Wrapper:

**Windows (PowerShell):**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS / Linux:**

```bash
./mvnw spring-boot:run
```

Luego abre [http://localhost:8080/registro](http://localhost:8080/registro) para crear una cuenta. Si ya tienes una, puedes iniciar sesión en [http://localhost:8080/login](http://localhost:8080/login).

## Funcionalidades y rutas

| Ruta | Acción |
| --- | --- |
| `/registro` | Muestra el formulario de registro |
| `/procesa/registro` | Procesa el registro |
| `/login` | Muestra el formulario de inicio de sesión |
| `/procesa/login` | Procesa el inicio de sesión |
| `/logout` | Cierra la sesión |
| `/inicio/series` | Muestra el catálogo |
| `/agregar/serie` | Muestra el formulario para agregar una serie |
| `/procesar/agregar/serie` | Guarda una serie |
| `/detalle/serie/{id}` | Muestra el detalle de una serie |
| `/editar/serie/{id}` | Muestra el formulario de edición |
| `/procesar/editar/serie` | Actualiza una serie |
| `/eliminar/serie/{id}` | Elimina una serie |

El formulario de series incluye título, año, descripción, URL de imagen, cantidad y precio. Los datos se validan antes de guardarse. Las contraseñas de las cuentas se almacenan con BCrypt.

## Ejecutar las pruebas

**Windows:**

```powershell
.\mvnw.cmd test
```

**macOS / Linux:**

```bash
./mvnw test
```

## Estructura del proyecto

```text
src/main/java/com/javaSpring/examen/
├── Controlador/   # Controladores MVC de usuarios y series
├── Modelos/       # Entidades Usuario y Serie
├── Repositorio/   # Repositorios JPA
└── Servicios/     # Lógica de negocio y validaciones

src/main/resources/
└── application.properties

src/main/webapp/WEB-INF/  # Vistas JSP
```
