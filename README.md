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

Os dados são mantidos em um banco de dados NoSQL em memória mas configurados para também persistir em disco, obtendo assim maior velocidade no processamento dos mesmos e alta disponibilidade.

## Tecnologias

* Oracle Java 8
* Apache Maven
* Spring Framework
* Redis

## Construção e Distribuição (Maven)

A API roda em um Container WEB Java embutido, portanto não necessita de instalação de nenhum container ou servidor de aplicação. Entretando é necessário ter o Redis (com a configuração padrão) instalado na máquina.

Para construir e iniciar a aplicação execute o seguinte comando na pasta raiz:

```
mvn clean package && java -jar target/xy-inc-products-api.jar
```

## Construção e Distribuição (Docker)

Para não depender de configuração de infraestrutura também é possivel utilizar o script do Docker para construção e utilização da API.

O script se encontra na pasta ```docker```.

Para executá-lo rode o comando abaixo no terminal do Docker:

```
docker run ...
```

## Testes

Para