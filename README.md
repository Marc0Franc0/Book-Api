# [Books-Api](https://github.com/Marc0Franc0/Book-Api#Book-Api)
Esta API permite realizar operaciones básicas sobre los libros almacenados en una base de datos de libros.

## Características
- CRUD para la entidad "Book"

## Tecnologías
- Java
- Spring Boot
- Maven
- MongoDB
- Lombok

## Ejecución
1. Clonar repositorio:

```shell
git clone https://github.com/Marc0Franc0/Book-Api.git
```
2. Ir al directorio del proyecto:

```shell
cd Book-Api
```
3. Seguir pasos para ejecución con Maven

## Requerimientos para ejecutar con Maven

Para construir y ejecutar la aplicación necesita:
- [JDK 20+](https://www.oracle.com/java/technologies/downloads/#java20)
- [Maven 3+](https://maven.apache.org)

4. Configurar datos de la base de datos MongoDB: application.properties

5. Ejecución en maquina local

```shell
mvn clean install package -DskipTests 
```
```shell
mvn spring-boot:run
```
Dirigirse a: [http://localhost:8080/](http://localhost:8080/)
