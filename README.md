# study-springbootapi-01
Repositório de estudos de Spring Boot

E

Esta demonstração apresenta uma API REST limitada que pode representar um sistema de estoque para uma loja. O estoque contém itens, cada um com um ID, nome, preço e quantidade.

A API
---

As seguintes operações são suportadas

`GET /items`: Retorna todos os itens do estoque. Retorna um array JSON.

`GET /items/{id}`: Retorna um item específico, procurado pelo ID. Retorna um objeto JSON ou `404` se o item não existir.

`POST /items`: Cria um novo item. Deve ser fornecido um nome, preço e quantidade como um objeto JSON. Um ID será gerado automaticamente. Ex. `{"name": "My Item", "price": 12.99, "count": 11}`. Returna `201` se a criação foi bem-sucedida, bem como o novo item como um objeto JSON.

`PUT /items/{id}`: Atualiza um item existente, identificado pelo ID. Pode aceitar um novo preço, quantidade, ou ambos através de um objeto JSON. Ex. `{"price": 17.99, "count": 43}`. Retorna o item atualizado como um objeto JSON ou `404` se o item não existir.

`DELETE /items/{id}`: Apaga um item existente, retornando `200` em caso de sucesso ou `404` se o objeto não existir.

Executando o código
---

O código pode ser executado como um aplicativo Spring Boot padrão:

`./mvnw spring-boot:run`

Enviando solicitações com cURL
---

```
> curl http://localhost:8080/items

[{"id":1,"name":"Keyboard","price":29.99,"count":76},{"id":2,"name":"Mouse","price":19.99,"count":43},{"id":3,"name":"Monitor","price":79.99,"count":7},{"id":4,"name":"PC","price":749.99,"count":2},{"id":5,"name":"Headphones","price":19.99,"count":14}]
```

```
> curl http://localhost:8080/items/1

{"id":1,"name":"Keyboard","price":29.99,"count":76}
```

```
> curl -XPOST http://localhost:8080/items -H "Content-Type: application/json" -d '{"name": "Speakers", "price": 49.99, "count": 30}'

{"id":6,"name":"Speakers","price":49.99,"count":30}
```

```
> curl -XPUT http://localhost:8080/items/1 -d '{"count": 75, "price": 27.99}' -H "Content-Type: application/json"

{"id":1,"name":"Keyboard","price":27.99,"count":75}
```

Tests
---

Testes também são fornecidos para cada operação, localizada no [SpringBootApiDemoApplicationTests.java](https://github.com/evaldowolkers/study-springbootapi-01/blob/main/src/test/java/com/github/brianmmcclain/springbootapidemo/SpringBootApiDemoApplicationTests.java) file.

Por padrão, todos os testes são executados quando o código é construído com Maven (ou seja, `./mvnw clean package`). Você também pode executar os testes independentemente com `./mvnw test`.
