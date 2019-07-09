# PROJETO HOME TASK - EMBRACE

### Definições escolhidas

* A aplicação consiste no modelo MVC, na qual, encontrar-se todas funcionalidades para atender as requisições HTTP, delegar as responsabilidades para outros componentes e 
preparar a resposta a ser dada.
 
* Aplicar boas práticas de programação para obter melhor legibilidade do código e fácil manutenção.
	* Endentação.
	* Organização dos pacotes.
	* Utilização de ferramenta para documentar a API.
	* Convenções nos nomes para classes, métodos e variavéis.

* Aplicar encapsulamento nas classes de abstrações.(Produto e Imagem), isso permite maior segurança dos dados.

* Versão do Spring Boot: 2.1.6 (que inclui várias correções de bugs e atualizações de dependências, 
já a versão 1.5 terá a sua vida finalizada a partir de agosto).

* Versão do Java: 8

* Versão do Maven: 3.1.1

* Banco de dados em memória: H2 (O H2 é um banco de dados em memória mais popular e o spring boot 
tem uma integração muito boa com ele e só fica ativo durante o tempo de execução da aplicação).

### Maven - Comando para inicializar a aplicação

./mvnw spring-boot:run

### Maven - Comando para executar Test

./mvnw test

### Acesso ao banco de dados em memoria
* [Console H2](http://localhost:8080/h2-console)

OBS: Caso o console apresente o seguinte erro de conexão: "Database "mem:teste" not found, and IFEXISTS=true, so we cant auto-create it [90146-199] 90146/90146 (Help)" -
Inserir o seguinte parêmetro no campo JDBC URL: "jdbc:h2:mem:testdb".

### Persistir dados em tempo de execução - ( Opcional )

* Caso deseja persistir dados no banco de dados automaticamente durante a execução da aplicação, 
descomentar as linhas de insert que está no script 'src/main/resources/data.sql'. 

### Documentação API

http://localhost:8080/swagger-ui.html

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

### Imagens - Endpoints

```js
@GET todos

curl -X GET \
  http://localhost:8080/api/v1/imagens \
  -H 'cache-control: no-cache' \
  -H 'postman-token: accec767-5ca7-ad01-6f72-dd84deffca41'

```

```js
@GET por id

curl -X GET \
  http://localhost:8080/api/v1/imagens/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: c6dd3774-47f4-bdaa-f4f7-f30d02293df5'

```

```js
@POST

curl -X POST \
  http://localhost:8080/api/v1/imagens \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: fa45b099-7611-a281-983f-fba6dd29d62c' \
  -d '{
	"nome": "Infravermelho",
	"localizacaoImagem": "/store/cbers/",
	"produto": {
		"id": 1
	}
}'

```

```js
@PUT

curl -X PUT \
  http://localhost:8080/api/v1/imagens \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 388e5c7a-df5e-713f-6398-4b5d93e9a21e' \
  -d '{
	"nome": "Infravermelho - Alterado",
	"localizacaoImagem": "/store/cbers/"
}'

```

```js
@DELETE

curl -X DELETE \
  http://localhost:8080/api/v1/imagens/2 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 83234c73-b161-35a9-c635-8f1368b02539'

```