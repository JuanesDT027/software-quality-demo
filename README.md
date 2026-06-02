QualityDemo
Descripción del proyecto

QualityDemo es una aplicación backend desarrollada con Spring Boot que implementa una arquitectura por capas (controller, service, repository, entity). El sistema expone una API REST para la gestión de usuarios y tareas, persistiendo los datos en una base de datos PostgreSQL.

El proyecto está containerizado con Docker y utiliza Docker Compose para la orquestación de servicios. Además, integra SonarQube para el análisis estático de código, permitiendo evaluar métricas de calidad como mantenibilidad, deuda técnica y detección de code smells.

Arquitectura

El sistema sigue una arquitectura por capas:

Controller: expone los endpoints REST.
Service: contiene la lógica de negocio.
Repository: gestiona el acceso a datos mediante Spring Data JPA.
Entity: representa el modelo de datos.
Tecnologías utilizadas
Java 21
Spring Boot 3.5.14
Spring Data JPA
Hibernate
PostgreSQL 16
Docker
Docker Compose
SonarQube
Maven
Requisitos previos
Docker y Docker Compose instalados
Java 21 instalado (opcional si se ejecuta en Docker)
Maven instalado (si se ejecuta localmente)
Puerto 8080 disponible
Puerto 5432 disponible
Puerto 9000 disponible (SonarQube)
Despliegue del proyecto
1. Clonar el repositorio
git clone <URL_DEL_REPOSITORIO>
cd qualitydemo
2. Levantar los contenedores

El proyecto utiliza Docker Compose para levantar la aplicación y la base de datos.

docker compose up --build

Esto iniciará:

Aplicación Spring Boot en http://localhost:8080
Base de datos PostgreSQL en puerto 5432
3. Verificar contenedores
docker ps

Debe mostrarse:

qualitydemo-app
postgres-quality
Endpoints de la API
Usuarios
POST /usuarios
GET /usuarios
GET /usuarios/{id}
PUT /usuarios/{id}
DELETE /usuarios/{id}

Ejemplo de JSON:

{
  "nombre": "Juan",
  "correo": "juan@ejemplo.com"
}
Tareas
POST /tareas
GET /tareas
GET /tareas/{id}
PUT /tareas/{id}
DELETE /tareas/{id}

Ejemplo de JSON:

{
  "titulo": "Ejemplo tarea",
  "descripcion": "Descripción de la tarea"
}
Acceso a la aplicación
API REST: http://localhost:8080
Usuarios: http://localhost:8080/usuarios
Tareas: http://localhost:8080/tareas
Base de datos

El sistema utiliza PostgreSQL en Docker con las siguientes credenciales:

Base de datos: qualitydb
Usuario: admin
Contraseña: admin
Host: postgres
Puerto: 5432
SonarQube (calidad de código)

El proyecto incluye análisis estático con SonarQube.

Acceso

http://localhost:9000

Ejecución del análisis
mvn clean verify sonar:sonar -Dsonar.projectKey=qualitydemo -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<TOKEN>
Flujo de ejecución
El cliente realiza una petición HTTP.
El Controller recibe la solicitud.
El Service procesa la lógica de negocio.
El Repository interactúa con la base de datos.
PostgreSQL almacena o consulta los datos.
La respuesta se retorna al cliente en formato JSON.
Calidad de software

El proyecto incorpora análisis estático de código mediante SonarQube, permitiendo evaluar:

Mantenibilidad del código
Deuda técnica
Code smells
Bugs potenciales
Vulnerabilidades

Esto garantiza buenas prácticas de desarrollo y mejora continua del software.
