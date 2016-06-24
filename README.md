# API REST para Manipulação de Dados de Produtos

## Definição

A API foi definida e documentada para melhor entendimento da sua utilização através da linguagem de modelagem RAML (RESTful API Modeling Language).

Para consultar a definição acesse o arquivo ```products.raml``` utilizando a ferramenta de sua preferência.

## Arquitetura

A API foi desenvolvida em uma arquitetura REST para permitir uma fácil integração a outros sistemas e também visando escalabilidade, manutenibilidade e extensibilidade.

A arquitetura está projetada para possibilitar uma fácil evolução do seu projeto e a utilização de qualquer tipo de implementação de persistência de dados.

Visando testabilidade e praticidade na evolução, o projeto possui configuração para cobertura de testes unitários para serviços, repositórios de dados e serviços WEB com massa de dados independente permitindo alterações e refatorações seguras respaldadas nos testes.

## Tecnologias

* Oracle Java 8
* Apache Maven
* Spring Framework
* HSQLDB

## Construção e Distribuição (Maven)

A API roda em um Container WEB Java (Tomcat) e um banco de dados (HSQLDB) embutidos, portanto não necessita de instalação de nenhum container ou banco de dados.

É necessário apenas ter o *Oracle JDK 8+* e *Apache Maven 3+* instalados e configurados no PATH da máquina.

Para construir e distribuir a aplicação execute o seguinte comando na pasta ```products-api```:

```
mvn clean package && java -jar target/products-api.jar
```

## Utilização

###### Acesso

Após a construção e distribuição da aplicação a API estará disponível para acesso no seguinte endereço:

```
http://localhost:8080/products/
```

###### Estrutura do Produto

Atributo | Tipo
-------- | -------------
id | integer
name | string
description | string
price | number
category | string

Formato JSON:

```
{
    "id" : 1,
	"name" : "test name",
    "description" : "test description",
    "price" : 100.00,
    "category" : "test category"
}
```

###### Recursos

Método HTTP | URI           | Descrição          | Produz | Consome
----------- | ------------- | ------------------ | ------ | --------
GET | /products | Lista todos os produtos | application/json | application/json
GET | /products/{id} | Busca um produto por id | application/json | application/json
POST | /products | Cria um novo produto | application/json | application/json
PUT | /products/{id} | Edita um produto | application/json | application/json
DELETE | /products/{id} | Deleta um produto | application/json | application/json

## Testes

Para executar a suite de testes execute o seguinte comando:

```
mvn clean test
```