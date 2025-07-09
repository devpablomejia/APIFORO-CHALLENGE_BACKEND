# 🧠 APIFORO-CHALLENGE_BACKEND

Bienvenido a la **API REST de Foro**, una aplicación backend construida con **Spring Boot**.  
Permite gestionar tópicos (temas de discusión) de manera segura y organizada, aplicando buenas prácticas RESTful y autenticación con JWT.

---

## 🚀 Funcionalidades

✅ Crear, consultar, actualizar y eliminar tópicos  
🔐 Seguridad implementada con Spring Security  
🔑 Validación de tokens JWT  
📦 Manejo de errores comunes (`400`, `404`, etc.)  
🧱 Arquitectura limpia y escalable  
🗃️ Integración con base de datos relacional y Flyway

---

## 🛠️ Tecnologías Utilizadas

- Java 24
- Spring Boot
- Spring Security
- JWT (Json Web Token)
- Maven
- mySQL
- Flyway

---

## 📦 Instalación y Ejecución

### 🔧 Requisitos Previos

- Java SDK 17+
- Maven
- mySQL

### ⚙️ Pasos para correr el proyecto

1. Clona el repositorio:
   ```bash
   https://github.com/devpablomejia/APIFORO-CHALLENGE_BACKEND.git


2. Configura tus credenciales en application.properties:

   ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/foro
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    jwt.secret=clave_secreta_segura
    ```


3. Ejecuta la aplicacion:
   mvn spring-boot:run

---
### endpoints
🛡️ Todos los endpoints (excepto el login) requieren autenticación con JWT en el header Authorization
Formato del header: Authorization: Bearer <tu-token-jwt>

```json
{
  "username": "usuario123",
  "password": "tu_clave"
}

```

### ejemplo json para crear un topico

```json
"autor":"usuario_1",
"titulo":"PROBLEMAS LITERALURA",
"mensaje":"no puedo usar la api de gutenberg",
"curso":"challenge literalura"
```






