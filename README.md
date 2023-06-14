# Spring Boot 3 Project with Spring Security and Swagger UI Integration

Este proyecto es una aplicación web Spring Boot 3 que integra Spring Security para autenticación y autorización,
y Swagger UI para la documentación de la API usando OpenAPI 3.

## Prerequisites

- Java 17 or higher
- Maven 3 or higher

## Getting Started

1. Clonar el repositorio.
   ```
   git clone https://github.com/gianco409/spring-boot-service-auth.git
   ```

2. Ir a la carpeta del proyecto.
    ```
   cd spring-boot-security-swagger
   ```

3. Levantar el proyecto.
    ```
   mvn clean install
   ```

4. Ejecutar el proyecto.
    ```
   mvn spring-boot:run
   ```

5. Acceda a la interfaz de usuario Swagger en [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html). 

## Features

- Spring Security para autenticacion y autorizacion.
- Registro de Notas asociado al Usuario autorizado.
- Swagger UI para la documentación de API utilizando OpenAPI 3.

## Usage

1. Ejecuta la aplicacion.
2. Acceda a la interfaz de usuario Swagger en [http://localhost:8088/swagger-ui/index.html](http://localhost:8088/swagger-ui/index.html).
3. Utilice la interfaz de usuario Swagger para probar los endpoint de la API. Tambien puede usar el archivo API-Notas.postman_collection.json para probar los endpoint del API.
4. Puede usar los siguiente usuarios para la autenticacion: 
   ```
   Usuario: usergian | Contraseña: password
   ```
   ```
   Usuario: usermarco | Contraseña: password
   ```

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [OpenAPI 3](https://swagger.io/specification/)

## Contact

- [Gianmarcos Perez](gianco409@gmail.com)
