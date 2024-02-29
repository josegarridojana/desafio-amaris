# Spring Boot Amaris CRUD: Building Rest API con Spring Data JPA

Detalle:

> [Desafio Amaris: Build a CRUD Rest APIs](http://localhost:8088/amaris/)

> [Desafio Amaris: Build a CRUD Rest APIs Actuator](http://localhost:8088/amaris/actuator/health)

> [Desafio Amaris: Build a CRUD Rest APIs Swagger]( http://localhost:8088/amaris/swagger-ui.htm)



 
En esta prueba, crearemos un ejemplo de API CRUD de Spring Boot Rest con Maven que usa Spring Data JPA para interactuar con la base de datos H2 en memoria. 

Pasos:

- Configurar Spring Data, JPA, Hibernate para trabajar con la base de datos
- Definir modelos de datos, interfaces de repositorio y services
- Definir Patron de diseño MVC en API RestFull
- Crear Spring Rest Controller para procesar solicitudes HTTP
- Se Usa Spring Data JPA para interactuar con H2 Database
- Uso de lombook
- Validacion de email
- Validacion de password es Mínimo ocho caracteres, al menos una letra y un número
- No es necesario scrip de bd ya que se genera automatico

CURL
> 
	
Front-end eso funciona bien con esto Back-end
> 

Más práctica:
>

Manejo de excepciones:
>

Otras bases de datos:
>

Seguridad:
>

Fullstack:
> 

Ejecute tanto el back-end como el front-end en un solo lugar:
> 

Se deja collection de postman:
> 

dentro de la carpeta "postman"



## Run Spring Boot application in Maven
```
mvn spring-boot:run
```

## Run Spring Boot application IDE Eclipse
```
run as run
run configurations
create manager and run configurations

spring-boot:run
```

## Run Spring Boot application java
```
java -jar nombreJar.jar
```

# Desafío Java Amaris

Ejercicio: Plataforma de Noticias

Descripción:

Debes desarrollar una plataforma de noticias que permita a los usuarios ver y buscar noticias.
Adicionalmente el usuario puede guardar en favoritos las noticias que desee conservar en el tiempo. 
La plataforma constará de dos partes: una interfaz web SPA y un microservicio.

Parte 1: Interfaz web SPA con Angular
Desarrolla una interfaz web de una sola página (SPA) utilizando Angular. 
La interfaz debe tener las siguientes características:

Página de inicio: Muestra las noticias más recientes en una lista ordenada por fecha. Como usuario deseo ingresar al sitio y ver las últimas 10 noticias.
• Cada noticia debe mostrar su título, descripción, resumen y fecha de publicación. La fecha debe mostrarse en formato dd MMM yyyy, Ej: 13 Jun 2023.
• Se espera poder contar con paginado, ordenamiento y búsqueda en la misma interfaz.
• Se debe incorporar una opción para agregar una noticia a la lista de favoritos.

Página favoritos: Muestra el listado de noticias guardados por el usuario. Al ingresar a la
ventana “favoritos” como usuario deseo ver las últimas 10 noticias guardadas ordenadas por la fecha que fueron guardadas.
• Desde esta interfaz el usuario debe tener las mismas funcionalidades que en la página
principal; paginado, filtrado y ordenamiento.
• Adicionalmente en este listado quisiera poder ver la fecha en que se guardó el artículo.
La fecha en formato dd MMM yyyy.

Integración con APIs de terceros: Para obtener las noticias, debes consumir el siguiente API de
noticias https://api.spaceflightnewsapi.net/v4/articles.. El api permite ordenar, filtrar y paginar.
Ver sección de referencias para documentación del Api.
Integración con Api propia: Para guardar y obtener el listado de favoritos se debe consumir un

Api propia que se describirá en la segunda parte de la prueba.

Diseño de la interfaz de usuario libre.

Deseable control de errores en la interfaz, hacer una manipulación correcta de errores que impida que se quiebre la interfaz del usuario.

Requerido desarrollar test unitarios en los nuevos componentes que se desarrollen.



Parte 2: Microservicio con Java y Spring Boot

Desarrolla un microservicio utilizando Java y Spring Boot que gestione la lógica de negocio y las operaciones CRUD de las noticias destacadas (favoritos). 
El microservicio debe tener las siguientes características:

Almacenamiento en base de datos en memoria: Utiliza una base de datos en memoria (por ejemplo, H2) para almacenar los favoritos.

Endpoints RESTful: Implementa endpoints RESTful que permitan a la interfaz web obtener las noticias favoritas desde la base de datos. 
Los endpoints deben cubrir las operaciones para obtener todos los favoritos, buscar favoritos por título, filtrar y ordenar. Además, se deben poder cargar y borrar favoritos.

Requerido implementar pruebas unitarias a servicios y controladores

Deseable implementar un buen control de errores.

El modelo de datos es libre siempre que se respeten los campos mencionados en el documento.

Entregables:

1. Contrato swagger (openapi) del microservicio en formato yml como documento independiente.
2. Documento técnico exponiendo la solución y el detalle de la tecnología elegida y dependencias para desplegar y probar el código.
3. Código de la solución en repositorio github público.

Nota: El repositorio público no puede tener las palabras Sodexo y/o Pluxee como parte de la ruta o nombre del repositorio.

Restricciones técnicas
Java + Spring Boot (java superior a la versión 8)
Angular (superior a la versión 8)

Referencias
Documentación de Angular: https://angular.io/docs
Documentación de Spring Boot: https://spring.io/projects/spring-boot
Documentación de la API de noticias https://api.spaceflightnewsapi.net/v4/docs/

