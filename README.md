# API REST para Manipulação de Dados de Produtos

## Arquitetura

A API foi desenvolvida em uma arquitetura REST para permitir uma fácil integração a outros sistemas e também visando escalabilidade, manutenibilidade e extensibilidade.

A arquitetura está projetada para possibilitar uma fácil evolução do seu projeto e a utilização de qualquer tipo de implementação de persistência de dados.

## Tecnologias

* Oracle Java 8
* Apache Maven
* Spring Framework

## Construção e Distribuição (Maven)

A API roda em um Container WEB Java (Tomcat) e um banco de dados (HSQLDB) embutidos, portanto não necessita de instalação de nenhum container ou banco de dados.

Para construir e distribuir a aplicação execute o seguinte comando na pasta ```products-api```:

```
mvn clean package && java -jar target/products-api.jar
```

## Utilização

###### Acesso

Após a construção e distribuição da aplicação a API estará disponível para acesso no seguinte endereço:

```
http://localhost:8080/products-api/
```

###### Estrutura do Produto

Atributo | Tipo
-------- | -------------
name | string
description | string
price | decimal
category | string

Formato JSON:

```
{
    "name" : "test name",
    "description" : "test description",
    "price" : "100.00",
    "category" : "test category"
}
```

###### Recursos

Método HTTP | URI           | Descrição          | Produz | Consome
----------- | ------------- | ------------------ | ------ | --------
GET | /products | Lista todos os produtos | JSON | JSON
GET | /products/{id} | Busca um produto por id | JSON | JSON
POST | /products | Cria um novo produto | JSON | JSON
PUT | /products/{id} | Edita um produto | JSON | JSON
DELETE | /products/{id} | Deleta um produto | JSON | JSON

## Testes

Para executar a suite de testes execute o seguinte comando:

```
mvn clean test
```