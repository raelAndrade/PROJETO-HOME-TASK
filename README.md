# PROJETO HOME TASK - EMBRACE

### Acesso ao banco de dados em memoria
* [Console H2](http://localhost:8080/h2-console)

### Documentação API


### Produtos - Endpoints

```js
@GET todos

curl -X GET \
  http://localhost:8080/api/v1/produtos \
  -H 'cache-control: no-cache' \
  -H 'postman-token: a4907191-77b2-8889-dddb-bbfc27502d8e'
```

```js
@GET por id

curl -X GET \
  http://localhost:8080/api/v1/produtos/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 87213beb-8015-0703-ee6b-b6a5fbce2b12'
```

```js
@POST

curl -X POST \
  http://localhost:8080/api/v1/produtos \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 701a2cac-89d1-ba58-1dcd-72c3a57c8d8e' \
  -d '{
	"nome": "CBERS4 - Infravermelho",
	"descricao": "Imagem Infravermelho gerada a partir do produto CBERS 4"
}'
```

```js
@PUT

curl -X PUT \
  http://localhost:8080/api/v1/produtos \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 17e18cc1-577c-bfc0-c87c-a72afaf49c1e' \
  -d '{
    "id": 1,
    "nome": "CBERS4 - Infravermelho",
    "descricao": "Imagem Infravermelho gerada a partir do produto CBERS 4 - Necessário detalhar melhor"
}'
```

```js
@DELETE

curl -X DELETE \
  http://localhost:8080/api/v1/produtos/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: b464c9b1-0feb-ccb3-896d-b71620248861'
```
