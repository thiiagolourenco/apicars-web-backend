<h1 align="center">
    API REST DE USUÁRIOS E SEUS CARROS
</h1>

<p align="center">
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-solução">Solução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-estórias-de-usuário">Estórias de usuário</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-pré-requisitos">Pré-requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-Swagger">Swagger</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-buildando-e-executando">Buildando e executando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-deploy">Deploy</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-autor">Autor</a>
</p>

<br>

## 💻 Projeto

**API CARS** - Criação de uma API Rest de usuários e seus carros proposto no desafio técnico.
<br/>
<br/>
**Obs.:** a url da API de produção pode ser utilizada através da URL: 🚗 https://apicars-web-backend.onrender.com
<br/>
**Obs².:** o projeto do frontend está no repositório: [Front-end](https://github.com/thiiagolourenco/apicars-web-frontend).

## 💡 Solução

Pensando no desafio foi definido 3 principais pilares:

**1.** A framework: Java Spring que permite a criação de uma API Rest robusta. Dentro do projeto foram escolhidas algumas dependências dentre elas: Lombok e DevTools (simplificando o desenvolvimento e reduzindo a quantidade de código), Spring Web e Security (para criação de Endpoints e das suas proteções), JPA/Hibernate (facilitar a integração com o banco) e H2 (para um banco de testes locais). Focando na parte dos testes unitários foram escolhidas as bibliotecas do Junit e Mockito, respectivamente, para criamos os testes e seus mocks.

**2.** O banco de dados: se tratando de um desafio de dados relacionais foi escolhido o PostgreSQL por ser um banco robusto e escalável para esse tipo de dados.

<div style="display:flex;align-items:center;">
    <img src="/src/main/resources/static/img/relational_modeling.png" title="Relational Modeling" alt="Relational Modeling" width="480px" />
</div>

**3.** Deploy: no geral a ideia era fazer o deploy do serviço em um ambiente nuvem para que tudo ficasse escalável e disponível para os revisores. Já havia trabalhado com o Heroku, AWS e Render, mas entre esses decidi pelo Render por ser totalmente gratuito inicialmente e já ter feito exatamente esse processo com ele e o Spring.

No fim, por ser um projeto simples foi escolhido o modelo tradicional de **Design Patterns** utilizando conceitos de _MVC_, _Solid_ e _clean code_.

<div style="display:flex;align-items:center;">
    <img src="/src/main/resources/static/img/architecture.png" title="Architecture" alt="architecture" width="480px" />
</div>

## 💡 Estórias de usuário

Para que ficasse mais claro e simples no commit as estórias foram definidas como **nome_do_projeto-número_da_estória**, por exemplo: APICARS-08. Sabendo disso, após analisar o desafio foram definidas as seguintes estórias de usuário:

**1.** ESTÓRIAS RELACIONADAS COM USUÁRIO NÃO AUTENTICADO:

- ✔️APICARS-00: EU COMO usuário QUERO um sistema que tenha usuário e seus carros PARA gerênciar esses indivíduos.
- ✔️APICARS-01: EU COMO novo usuário QUERO me cadastrar no sistema PARA ter acesso completo ao sistema. (POST)
- ✔️APICARS-02: EU COMO usuário não autenticado QUERO listar os usuários do sistema PARA ver quem está cadastrado. (GET)
- ✔️APICARS-03: EU COMO usuário não autenticado QUERO buscar um usuário pelo seu id PARA ver as suas informações. (GET)
- ✔️APICARS-04: EU COMO usuário não autenticado QUERO remover um usuário pelo seu id PARA excluir suas informações. (DELETE)
- ✔️APICARS-05: EU COMO usuário não autenticado QUERO editar um usuário pelo seu id PARA atualizar alguma informação do usuário. (PUT)

**2.** ESTÓRIAS RELACIONADAS COM USUÁRIO AUTENTICADO:

- ✔️APICARS-06: EU COMO usuário já cadastrado QUERO me logar no sistema PARA utilizar todas as funcionalidades do mesmo. (POST)
- ✔️APICARS-07: EU COMO usuário logado QUERO listar todos os meus carros PARA gerencia-los. (GET)
- ✔️APICARS-08: EU COMO usuário logado QUERO cadastrar um novo carro PARA que ele vá para a lista dos meus carros. (POST)
- ✔️APICARS-09: EU COMO usuário logado QUERO buscar um carro pelo seu id PARA QUE ver as suas informações. (GET)
- ✔️APICARS-10: EU COMO usuário logado QUERO remover um carro pelo seu id PARA QUE excluir suas informações. (DELETE)
- ✔️APICARS-11: EU COMO usuário logado QUERO editar um carro pelo seu id PARA QUE atualizar alguma informação do carro. (PUT)

**OBS.:** Dessa maneira as branchs terão nomes como: **APICARS-número_estória_o_que_será_feito -> APICARS-01_USER_SIGNUP.**

## 📝 Pré-requisitos

Para contribuir com o projeto é necessário os seguintes requisitos:

- GIT,
- Java 17,
- PostgreSQL 12 e PgAdmin,
- Render,
- IDE Java da sua escolha (recomendação: [STS](https://spring.io/tools)),
- Plataforma de API Rest da sua escolha (recomendação: [Postman](https://www.postman.com/downloads/)).

## 🚀 Tecnologias

Esse projeto foi desenvolvido utilizando o framework [Java Spring 3.2.4](https://spring.io/) com os seguintes dependências:

- Maven,
- Spring Web,
- Spring Security,
- Spring Data JPA/Hibernate,
- H2 Databse,
- PostgreSQL Driver,
- Spring Boot DevTools,
- Lombok,
- Spring Boot Starter Test (JUnit e Mockito),
- Spring doc openapi (para geração do Swagger).

## 📨 Swagger

A API foi desenvolvida utilizando o **Swagger** para facilitar a documentação e entendimento. Se você quiser acessar para ver os detalhes de cada endpoint basta rodar a aplicação localmente e acessar [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui.html).

## 💻 Buildando e executando

Após clonar o projeto é necessário compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Quando finalizar o passo anterior vamos dar o start da nossa aplicação:
```
mvn spring-boot:run
```
Após o carregamento está tudo pronto! A aplicação irá levantar na porta 8080 e na url http://localhost:8080.
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```

## 🧗 Deploy

Para realizar o deploy foi utilizado a ferramente Render e seguimos os seguintes passos: 
<br/>
O primeiro passo é validar se o banco Postgres está corretamente configurado localmente. Crie três perfis de projeto

application-test.properties (para testes unitários)
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=apicars
spring.datasource.password=admin
```

application-dev.properties(validação de banco local H2)
```
#spring.jpa.properties.javax.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.javax.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.javax.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;

spring.datasource.url=jdbc:postgresql://localhost:5432/dsvendas
spring.datasource.username=postgres
spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.hibernate.ddl-auto=none
```

application-prod.properties (PostgresSQL)
```
spring.datasource.url=${DATABASE_URL}
```
Após isso, execute o projeto no ambiente de dev e execute os scripts abaixo para popular o banco Postgres local.
Create
```
create table cars (yeear integer, id bigserial not null, user_id bigint, color varchar(255), license_plate varchar(255) unique, model varchar(255), primary key (id));
create table users (birthday date, created_at timestamp(6), id bigserial not null, last_login timestamp(6), email varchar(255) unique, first_name varchar(255), last_name varchar(255), login varchar(255) unique, password varchar(255), phone varchar(255), role varchar(255) check (role in ('ADMIN','USER')), primary key (id));
alter table if exists cars add constraint FKqw4c8e6nqrvy3ti1xj8w8wyc9 foreign key (user_id) references users;
```
Insert
```
INSERT INTO users(first_name, last_name, email, birthday, login, password, role, phone, created_at, last_login) VALUES ('Thiago', 'Lourenço', 'thiago@email.com', '08-04-2020', 'thiagologin', '123456789', 'ADMIN', '81972349834', '2024-04-08 12:00:00+00:00', '2024-04-08 12:00:00+00:00');
INSERT INTO cars(user_id, yeear, license_plate, model, color) VALUES (1, 2020, 'JY3PA23', 'Celta', 'AZUL');
```
Depois de popular o banco é só testar uma requisição para ver se está tudo OK. Se estiver você deve trocar o conteúdo do application.properties para:
application.properties
```
spring.profiles.active=${APP_PROFILE:test}

spring.jpa.open-in-view=false
```
Após isso você deve criar o seguinte arquivo na **raiz do projeto**:
```
java.runtime.version=17
```
Agora que já criamos todos os ambientes e suas configurações é só realizar o deploy no Render e adicionar as variáveis de ambiente. Após isso, basta conectar o banco com o PgAdmin e rodar novamente os scrips acima para popular inicialmente o banco.

## 🐞 Testes unitários

Foram utilizados o Junit e Mockito para desenvolver os testes unitário da aplicação, mas apenas um caso para cada serviço, pois como na maioria dos serviços utilizou-se os métodos do JPA não faz muito sentido criar muitos testes já que o próprio JPA se responsabiliza dos testes internamente.
<br>
Para rodar os teste unitários que foram criados basta ir na classe do teste, clicar com o botão direito e executar como JUnit test. Veja abaixo:
<div style="display:flex;align-items:center;">
    <img src="/src/main/resources/static/img/unit_test.png" title="Unit test" alt="Unit test" width="480px" />
</div>

## 📝 Autor

Por **Thiago Lourenço** dá uma olhadinha no [LinkedIn](https://www.linkedin.com/in/thiiagolourenco) e no meu [Medium](https://thiiagolourenco.medium.com/) ✌🏽 
