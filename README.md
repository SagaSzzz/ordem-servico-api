# Ordem Serviço API
API REST desenvolvida com Java e Spring Boot para gerenciamento de clientes, equipamentos e ordens de serviço.

## Tecnologias utilizadas:

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman
- Git/GitHub

## Sobre o projeto

O projeto consiste em uma API REST para controle de ordens de serviço.

A aplicação permite cadastrar clientes, equipamentos e ordens de serviço, relacionando cada ordem a um cliente e a um equipamento. Também possui consultas personalizadas para buscar ordens por status, cliente e equipamento.

O sistema foi desenvolvido seguindo uma arquitetura em camadas:

- Model
- Repository
- Service
- Controller

## Funcionalidades

- Cadastro, listagem, busca, atualização e remoção de clientes
- Cadastro, listagem, busca, atualização e remoção de equipamentos
- Cadastro, listagem, busca, atualização e remoção de ordens de serviço
- Relacionamento entre ordem de serviço, cliente e equipamento
- Busca de ordens por status
- Busca de ordens por cliente
- Busca de ordens por equipamento
- Status da ordem controlado com Enum
- Validações de dados com Bean Validation
- Tratamento de erros com ControllerAdvice

## Estrutura do projeto

```txt
src
 └── main
     ├── java
     │   └── com.example.ordemService
     │       ├── controller
     │       ├── model
     │       ├── repository
     │       └── service
     └── resources
         ├── application-example.properties
         └── application.properties
```

## Pré-requisitos

Antes de rodar o projeto, é necessário ter instalado:

- Java
- Maven
- MySQL
- Git

## Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/SagaSzzz/ordem-servico-api.git
cd ordem-servico-api
```

### 2. Criar o banco de dados

No MySQL, crie o banco:

```sql
CREATE DATABASE ordemservice;
```

### 3. Configurar o application.properties

Crie um arquivo chamado `application.properties` dentro de:

```txt
src/main/resources
```

Use como base o arquivo `application-example.properties`.

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ordemservice
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 4. Rodar o projeto

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```txt
http://localhost:8080
```

## Endpoints

### Clientes

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/cliente` | Cadastra um cliente |
| GET | `/cliente` | Lista todos os clientes |
| GET | `/cliente/{id}` | Busca cliente por ID |
| PUT | `/cliente/{id}` | Atualiza cliente |
| DELETE | `/cliente/{id}` | Remove cliente |

### Equipamentos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/equipamento` | Cadastra um equipamento |
| GET | `/equipamento` | Lista todos os equipamentos |
| GET | `/equipamento/{id}` | Busca equipamento por ID |
| PUT | `/equipamento/{id}` | Atualiza equipamento |
| DELETE | `/equipamento/{id}` | Remove equipamento |

### Ordens de serviço

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/ordemServico` | Cadastra uma ordem de serviço |
| GET | `/ordemServico` | Lista todas as ordens |
| GET | `/ordemServico/{id}` | Busca ordem por ID |
| PUT | `/ordemServico/{id}` | Atualiza ordem |
| DELETE | `/ordemServico/{id}` | Remove ordem |
| GET | `/ordemServico/status/{status}` | Busca ordens por status |
| GET | `/ordemServico/cliente/{clienteId}` | Busca ordens por cliente |
| GET | `/ordemServico/equipamento/{equipamentoId}` | Busca ordens por equipamento |

## Exemplos de requisição

### Criar cliente

```json
{
  "nome": "Caio",
  "telefone": "21999999999",
  "email": "caio@email.com"
}
```

### Criar equipamento

```json
{
  "nome": "Notebook",
  "marca": "Dell",
  "modelo": "Inspiron 15",
  "defeito": "Não liga"
}
```

### Criar ordem de serviço

```json
{
  "comeco": "2026-06-15",
  "descProblema": "Notebook não liga",
  "fim": null,
  "status": "ABERTA",
  "valor": 170,
  "cliente": {
    "id": 1
  },
  "equipamento": {
    "id": 1
  }
}
```

### Atualizar ordem de serviço

```json
{
  "comeco": "2026-06-15",
  "descProblema": "Notebook liga, mas não dá vídeo",
  "fim": "2026-06-15",
  "status": "FINALIZADA",
  "valor": 220,
  "cliente": {
    "id": 1
  },
  "equipamento": {
    "id": 1
  }
}
```

## Exemplos de consultas

Buscar ordens por status:

```txt
GET /ordemServico/status/ABERTA
```

Buscar ordens por cliente:

```txt
GET /ordemServico/cliente/1
```

Buscar ordens por equipamento:

```txt
GET /ordemServico/equipamento/1
```

## Status disponíveis

Atualmente os status são enviados como texto no JSON.

Exemplos:

```txt
ABERTA
EM_ANDAMENTO
FINALIZADA
CANCELADA
```

Em uma melhoria futura, os status podem ser implementados com `Enum`.

## Melhorias futuras

- Utilizar DTOs para entrada e saída de dados
- Padronizar respostas com `ResponseEntity`
- Adicionar documentação com Swagger/OpenAPI
- Criar testes automatizados

## Autor

Desenvolvido por Caio Cesar.

