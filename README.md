# SpringBoot-ClickFarma - API REST

echo "📋 Visão Geral
Uma API REST completa para gestão de farmácias desenvolvida em Spring Boot com autenticação JWT e documentação Swagger.

🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot 3.2.2
- Spring Security
- JWT
- Spring Data JPA
- PostgreSQL
- H2 Database
- Lombok
- Maven
- Swagger/OpenAPI

🔐 Funcionalidades
Autenticação e Segurança:
- Registro e login de usuários
- Autenticação JWT
- Controle de acesso por roles
- Criptografia de senhas

Gestão de Farmácia:
- CRUD de produtos
- Gestão de categorias
- Controle de usuários
- Validações de negócio

Características Técnicas:
- API RESTful
- Tratamento centralizado de exceções
- Bean Validation
- Configurações por ambiente
- Testes unitários e de integração

🛠️ Pré-requisitos
- Java 17+
- Maven 3.6+
- PostgreSQL
- Git

⚙️ Configuração e Instalação

1. Clone o repositório:
git clone https://github.com/gustavsonmenezes/springboot-clickfarma
cd springboot-clickfarma

2. Configuração do Banco:

Desenvolvimento (H2):
Console: http://localhost:8080/h2-console
JDBC: jdbc:h2:mem:clickfarma
User: sa
Senha: <vazia>

Produção (PostgreSQL):
CREATE DATABASE clickfarma;
CREATE USER clickfarma_user WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE clickfarma TO clickfarma_user;

3. Execute a aplicação:
mvn spring-boot:run

📚 Documentação da API:
Swagger UI: http://localhost:8080/swagger-ui.html
OpenAPI JSON: http://localhost:8080/v3/api-docs

Endpoints Principais:
Autenticação:
POST /api/auth/login
POST /api/auth/register

Produtos:
GET    /api/produtos
GET    /api/produtos/{id}
POST   /api/produtos
PUT    /api/produtos/{id}
DELETE /api/produtos/{id}

Categorias:
GET /api/categorias
POST /api/categorias

🧪 Testes:
mvn test
mvn test -Dtest=*UnitTest
mvn test -Dtest=*IntegrationTest

🏗 Estrutura do Projeto:
src/
├── main/
│   ├── java/com/clickfarma/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── security/
│   │   └── config/
│   └── resources/
└── test/

🔧 Perfis:
mvn spring-boot:run -Dspring-boot.run.profiles=dev
mvn spring-boot:run -Dspring-boot.run.profiles=prod

🤝 Contribuição:
- Fork
- Branch
- Commit
- Push
- Pull Request

📝 Licença: MIT

👨‍💻 Autor:
Gustavo Menezes (GitHub: @gustavsonmenezes)
Versão: 1.0.0
Última atualização: Dez/2023"
