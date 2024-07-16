# API REST do ForumHub

ForumHub é um aplicativo Spring Boot que fornece uma API RESTful para gerenciar tópicos de fórum com autenticação JWT.

## Estrutura

```
forumhub/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── forum/
│   │   │           └── forumhub/
│   │   │               ├── config/
│   │   │               │   └── JwtRequestFilter.java
│   │   │               ├── controller/
│   │   │               │   ├── AuthenticationController.java
│   │   │               │   └── TopicController.java
│   │   │               ├── model/
│   │   │               │   └── Topic.java
│   │   │               ├── repository/
│   │   │               │   └── TopicRepository.java
│   │   │               ├── security/
│   │   │               │   ├── JwtTokenUtil.java
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── service/
│   │   │               │   ├── AuthenticationService.java
│   │   │               │   ├── TopicService.java
│   │   │               │   └── UserDetailsServiceImpl.java
│   │   │               └── ForumHubApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── forum/
│                   └── forumhub/
│                       └── ForumhubApplicationTests
│
├── pom.xml
└── README.md

```

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado:
- Kit de desenvolvimento Java (JDK) 17 ou posterior
- Ferramenta de construção Maven
- Servidor MySQL

## Instruções de configuração

### 1. Clone o repositório

```bash
clone do git https://github.com/seunomedeusuário/forumhub.git
cd forumhub
```

### 2. Configurar banco de dados MySQL

Crie um banco de dados MySQL chamado `forumhub`. Atualize `application.properties` em `src/main/resources` com seu nome de usuário e senha do MySQL:
```propriedades
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=atualização
```

### 3. Execute o aplicativo

```bash
mvn spring-boot:executar
```

A aplicação iniciará em `http://localhost:8080`.

## Terminais de API

### Autenticação

#### Conecte-se

- **URL:** `/login`
- **Método:** POST
- **Descrição:** Gera um token JWT para autenticação.

#### Exemplo de solicitação:

``` http 
POST /login HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username": "yourusername",
    "password": "yourpassword"
}
```

#### Exemplo de resposta:
```json
{
 "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Gerenciamento de tópicos

#### Criar tópico

- **URL:** `/topicos`
- **Método:** POST
- **Descrição:** Cria um novo tópico.

#### Exemplo de solicitação:

``` http
POST /topicos HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

{
    "title": "Topic Title",
    "message": "Topic Message",
    "author": "Author Name",
    "course": "Course Name"
}

```

#### Recuperar todos os tópicos

- **URL:** `/topicos`
- **Método:** GET
- **Descrição:** Recupera uma lista de todos os tópicos.

#### Exemplo de solicitação:

``` http
GET /topicos HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

```

#### Recuperar tópico por ID

- **URL:** `/topicos/{id}`
- **Método:** GET
- **Descrição:** Recupera detalhes de um tópico específico por ID.

#### Exemplo de solicitação:
``` http
GET /topicos/1 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

```

#### Atualizar tópico

- **URL:** `/topicos/{id}`
- **Método:** PUT
- **Descrição:** Atualiza detalhes de um tópico específico por ID.

#### Exemplo de solicitação:
``` http
PUT /topicos/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...

{
    "title": "Updated Title",
    "message": "Updated Message",
    "author": "Updated Author",
    "course": "Updated Course"
}

```

#### Excluir tópico

- **URL:** `/tópicos/{id}`
- **Método:** DELETE
- **Descrição:** Exclui um tópico específico por ID.

#### Exemplo de solicitação:
``` http
DDELETE /topicos/1 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

## Tecnologias usadas

- Java 17
- Inicialização de Primavera 3.3.1
- Spring Security para autenticação JWT
- JPA de dados Spring
- Banco de dados MySQL
- Maven

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE para obter detalhes.