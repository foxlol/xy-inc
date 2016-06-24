# API REST para Manipulação de Dados de Produtos

## Utilização

#### Estrutura do Produto

Atributo | Tipo
-------- | -------------
id | integer
name | string
description | string
price | decimal
category | string

#### Recursos

Método HTTP | URI           | Descrição          | Produz | Consome
----------- | ------------- | ------------------ | ------ | --------
GET | /products | Lista todos os produtos | JSON | JSON
GET | /products/{id} | Busca um produto por id | JSON | JSON
POST | /products | Cria um novo produto | JSON | JSON
PUT | /products/{id} | Edita um produto | JSON | JSON
DELETE | /products/{id} | Deleta um produto | JSON | JSON

## Arquitetura

A API foi desenvolvida em uma arquitetura REST para permitir uma fácil integração a outros sistemas e também visando escalabilidade, manutenibilidade e extensibilidade.

A arquitetura está projetada para possibilitar uma fácil evolução do seu projeto e a utilização de qualquer tipo de implementação de persistência de dados.

## Tecnologias

* Oracle Java 8
* Apache Maven
* Spring Framework

## Construção e Distribuição (Maven)

A API roda em um Container WEB Java (Tomcat) e um banco de dados (HSQLDB) embutidos, portanto não necessita de instalação de nenhum container ou banco de dados.

Para construir e iniciar a aplicação execute o seguinte comando na pasta ```products-api```:

```
mvn clean package && java -jar target/products-api.jar
```

## Testes

Para executar a suite de testes execute o seguinte comando:

```
mvn clean test
```