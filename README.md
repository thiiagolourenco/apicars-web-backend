<h1 align="center">
    API REST DE USUÁRIOS E SEUS CARROS
</h1>

<p align="center">
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-solução">Solução</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-estórias-de-usuário">Estórias de usuário</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-pré-requisitos">Pré-requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-autor">Autor</a>
</p>

<br>

## 💻 Projeto

**API CARS** - Criação de uma API Rest de usuários e seus carros proposto no desafio técnico da vaga de Eng. De Software Pleno pela Pitang.

## 💡 Solução

Pensando no desafio foi definido 3 principais pilares:

**1.** A framework: Java Spring que permite a criação de uma API Rest robusta. Dentro do projeto foram escolhidas algumas dependências dentre elas: Lombok e DevTools (simplificando o desenvolvimento e reduzindo a quantidade de código), Spring Web e Security (para criação de Endpoints e das suas proteções), JPA/Hibernate (facilitar a integração com o banco) e H2 (para um banco de testes locais).

**2.** O banco de dados: se tratando de um desafio de dados relacionais foi escolhido o PostgreSQL por ser um banco robusto e escalável para esse tipo de dados.

<div style="display:flex;align-items:center;">
    <img src="/src/main/resources/static/img/relational_modeling.png" title="Relational Modeling" alt="Relational Modeling" width="480px" />
</div>

**3.** Deploy: no geral a ideia era fazer o deploy do serviço em um ambiente nuvem para que tudo ficasse escalável e disponível para os revisores. Já havia trabalhado com o Heroku e AWS, mas entre esses dois decidi pelo Heroku por ser totalmente gratuito nesse caso e já ter feito exatamente esse processo com ele e o Spring.

No fim, por ser um projeto simples foi escolhido o modelo tradicional de **Design Patterns** utilizando conceitos de _MVC_, _Solid_ e _clean code_ (estrutura de pastas).

<div style="display:flex;align-items:center;">
    <img src="/src/main/resources/static/img/architecture.png" title="Architecture" alt="architecture" width="480px" />
</div>

## 💡 Estórias de usuário

Para que ficasse mais claro e simples no commit as estórias foram definidas como **nome_do_projeto-número_da_estória**, por exemplo: APICARS-08. Sabendo disso, após analisar o desafio foram definidas as seguintes estórias de usuário:

**1.** ESTÓRIAS RELACIONADAS COM USUÁRIO NÃO AUTENTICADO:

- APICARS-00: EU COMO usuário QUERO um sistema que tenha usuário e seus carros PARA gerênciar esses indivíduos.
- APICARS-01: EU COMO novo usuário QUERO me cadastrar no sistema PARA ter acesso completo ao sistema. (POST)
- APICARS-02: EU COMO usuário não autenticado QUERO listar os usuários do sistema PARA ver quem está cadastrado. (GET)
- APICARS-03: EU COMO usuário não autenticado QUERO buscar um usuário pelo seu id PARA ver as suas informações. (GET)
- APICARS-04: EU COMO usuário não autenticado QUERO remover um usuário pelo seu id PARA excluir suas informações. (DELETE)
- APICARS-05: EU COMO usuário não autenticado QUERO editar um usuário pelo seu id PARA atualizar alguma informação do usuário. (PUT)

**2.** ESTÓRIAS RELACIONADAS COM USUÁRIO AUTENTICADO:

- APICARS-06: EU COMO usuário já cadastrado QUERO me logar no sistema PARA utilizar todas as funcionalidades do mesmo. (POST)
- APICARS-07: EU COMO usuário logado QUERO listar todos os meus carros PARA gerencia-los. (GET ou POST)
- APICARS-08: EU COMO usuário logado QUERO cadastrar um novo carro PARA que ele vá para a lista dos meus carros. (POST)
- APICARS-09: EU COMO usuário logado QUERO buscar um carro pelo seu id PARA QUE ver as suas informações. (GET)
- APICARS-10: EU COMO usuário logado QUERO remover um carro pelo seu id PARA QUE excluir suas informações. (DELETE)
- APICARS-11: EU COMO usuário logado QUERO editar um carro pelo seu id PARA QUE atualizar alguma informação do carro. (PUT)

**OBS.:** Dessa maneira as branchs terão nomes como: **APICARS-número_estória_o_que_será_feito -> APICARS-01_USER_SIGNUP.**

## 📝 Pré-requisitos

Para contribuir com o projeto é necessário os seguintes requisitos:

- GIT,
- Java 11,
- PostgreSQL 12 e PgAdmin,
- Heroku CLI,
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
- Lombok.

## 📝 Autor

Por **Thiago Lourenço** dá uma olhadinha no [LinkedIn](https://www.linkedin.com/in/thiiagolourenco) e no meu [Medium](https://thiiagolourenco.medium.com/) ✌🏽 
