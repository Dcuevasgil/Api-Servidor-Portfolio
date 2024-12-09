# API de Gestión de Proyectos - DAW

**Ciclo Formativo:** Técnico Superior en Desarrollo de Aplicaciones Web\
**Alumno:** David Cuevas Gil


## Índice
1. [Introducción](#introducción)
2. [Funcionalidades y Tecnologías utilizadas](#funcionalidades-y-tecnologías-utilizadas)
3. [Guía de instalación](#guía-de-instalación)
4. [Guía de uso](#guía-de-uso)
5. [Conclusión](#conclusión)
6. [Licencias](#licencias)
7. [Contacto](#contacto)

## Introducción
Este proyecto consiste en una API RESTful diseñada para gestionar información sobre desarrolladores, proyectos y tecnologías dentro del ámbito del desarrollo de software. El objetivo principal es ofrecer una herramienta sencilla pero poderosa que permita gestionar de manera eficiente los diferentes aspectos de un proyecto, como los desarrolladores asignados, el estado en el que se encuentran y las tecnologías utilizadas.

La API está orientada a facilitar la organización de equipos de desarrollo, permitiendo a los usuarios gestionar el ciclo de vida de los proyectos de forma estructurada. Con funcionalidades como la asignación de desarrolladores a proyectos, el control del estado de cada proyecto y la asociación de tecnologías, el sistema busca mejorar la gestión y el seguimiento de los proyectos en equipos de desarrollo ágiles.


La motivación detrás de este proyecto es proporcionar una solución accesible y eficiente para las empresas que necesitan gestionar múltiples proyectos de software simultáneamente, asegurando una visión clara y actualizada de los recursos, el progreso y las herramientas utilizadas.

### Funcionalidades

- **Gestión de Desarrolladores**: Los usuarios pueden crear, editar y eliminar desarrolladores, asignándolos a proyectos específicos.

- **Gestión de Proyectos**: Los proyectos pueden ser creados, actualizados o eliminados. También se puede controlar su estado (por ejemplo, en progreso, completado, etc.) y asociarles tecnologías.

- **Tecnologías**: Se pueden asociar tecnologías específicas a cada proyecto, lo que facilita el control de las herramientas utilizadas.

- **Estados de los Proyectos**: Los proyectos pueden tener diferentes estados, lo que permite un seguimiento claro de su progreso.

### Tecnologias Utilizadas

- **Java**: Lenguaje de programación principal para el desarrollo de la API.

- **Spring Boot**: Framework para facilitar la creación de la API RESTful.

- **Hibernate / JPA**: Para el manejo de la persistencia de datos en la base de datos.

- **MySQL**: Base de datos relacional utilizada para almacenar la información.

- **Postman**: Herramienta utilizada para realizar las pruebas de la API.

## Guía de Instalación

Para instalar y ejecutar este proyecto en tu máquina local, sigue los siguientes pasos:

<!-- TODO: Poner mi repositorio de github cuando lo cree -->
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu_usuario/gestion-proyectos.git

2. **Instalar dependencias:** Asegúrate de tener Java 11 o superior instalado en tu sistema. Luego, navega a la carpeta del proyecto y ejecuta el siguiente comando para instalar las dependencias:
    ```bash
    ./mvnw install

3. **Configurar la base de datos:** Asegúrate de tener MySQL configurado en tu máquina. Crea una base de datos llamada `portfolio`.

4. **Configuración del archivo application.properties:** Configura las credenciales de la base de datos en el archivo src/main/resources/application.properties:

    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/portfolio?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=tu-usuario
    spring.datasource.password=tu-contraseña
    spring.jpa.hibernate.ddl-auto=validate
    spring.jpa.show-sql=true
    logging.level.org.springframework.web=DEBUG
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    server.port=8084

5. **Ejecutar la aplicación:** Ejecuta la aplicación desde el archivp principal

## Guía de uso

### Acceder a la API
Una vez que la aplicación esté en funcionamiento, puedes acceder a los endpoints de la API a través de `http://localhost:8084/api/v1/`.

### EndPoints Disponibles:

#### **EndPoint de Projects**
- **GET /projects**: Obtiene todos los proyectos registrados en la base de datos.
- **GET /projects/{word}**: Obtiene los detalles de un proyecto específico por su `palabra clave`.
- **POST /projects**: Crea un nuevo proyecto en la base de datos. Requiere los datos del proyecto en el cuerpo de la solicitud.
- **PUT /projects/{id}**: Actualiza la información de un proyecto existente por su `id`.
- **DELETE /projects/{id}**: Elimina un proyecto de la base de datos por su `id`.

#### **EndPoints de Developers**
- **POST /developers**: Crea un nuevo desarrollador en la base de datos. Requiere los datos del desarrollador en el cuerpo de la solicitud.
- **DELETE /developers/{id}**: Elimina un desarrollador de la base de datos por su `id`.

#### **EndPoint de Technologies**
- **POST /technologies**: Crea una nueva tecnología en la base de datos. Requiere los datos de la tecnología en el cuerpo de la solicitud.
- **DELETE /technologies/{id}**: Elimina una tecnología de la base de datos por su `id`.

## Conclusión
Este proyecto constituye una solución para administrar desarrolladores, proyectos, tecnologías y estados en un entorno de desarrollo de software. La API ofrece un enfoque organizado para gestionar información esencial, lo que simplifica la coordinación y el control de equipos de trabajo.

Durante el desarrollo de este proyecto, he adquirido habilidades en Java y cumple los objetivos planteados, tanto actuales como futuros.

En resumen, esta API es funcional, escalable y adaptable a diferentes necesidades.

## Contribuciones, Agradecimientos y Referencias  

Este proyecto no habría sido posible sin las herramientas que nos han permitido llevarlo a cabo: 

- **Spring Boot:** Por proporcionar un marco robusto para el desarrollo de aplicaciones web.

- **Hibernate:** Por simplificar la gestión de bases de datos mediante JPA. 

- **MySQL:** Por ser un sistema de base de datos confiable y eficiente.  

- **Postman:** Por facilitar las pruebas y la depuración de la API.  

## Licencias

Este proyecto está licenciado bajo la **Licencia MIT**, lo que significa que puedes usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, siempre que se incluya una copia del aviso de derechos de autor y la licencia en cualquier copia o parte sustancial del software.  

Puedes consultar los detalles completos en el archivo [LICENSE](./LICENSE) incluido en este repositorio.  

La Licencia MIT asegura la libertad de uso del software al tiempo que mantiene el reconocimiento de los derechos del autor original.

## Contacto
Si tienes preguntas, sugerencias o comentarios sobre este proyecto, no dudes en ponerte en contacto conmigo. Estoy abierto a recibir tu retroalimentación y a colaborar en posibles mejoras o nuevas ideas relacionadas con este proyecto.

- **Correo Electrónico:** [dcuevasgil@gmail.com](mailto:dcuevasgil@gmail.com)  
- **GitHub:** [Github](https://github.com/Dcuevasgil)  
- **LinkedIn:** [Linkedin](https://www.linkedin.com/in/david-cuevas-gil-36a728309/)
