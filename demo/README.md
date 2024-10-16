
# Avaliação N2

Este projeto é um serviço web que busca ofertas de jogos digitais usando a API CheapShark.

## Como rodar o projeto

1. Compile o projeto usando Maven:
   ```bash
   mvn clean package
   ```

2. Construa a imagem Docker:
   ```bash
   docker build -t avaliacaon2 .
   ```

3. Execute o projeto com Docker Compose:
   ```bash
   docker compose up
   ```

4. A aplicação estará disponível em `http://localhost:8080`.

## Rotas

### 1. **GET /**
Retorna a lista de jogos com descontos.

**Exemplo de requisição**:
```bash
GET http://localhost:8080/
```

**Exemplo de resposta**:
```json
[
  {
    "title": "Strange Brigade - Deluxe Edition",
    "normalPrice": 79.99,
    "salePrice": 6.0,
    "storeID": "2"
  }
]
```

### 2. **POST /filter**
Filtra com o preço máximo que você quer pagar, os jogos com base no preço de SALE, não no preço normal.

**Exemplo de requisição**:
```bash
POST http://localhost:8080/filter
Content-Type: application/json
```
Corpo:
```json
{
  "maxPrice": 6.00
}
```

**Exemplo de resposta**:
```json
[
  {
    "title": "Strange Brigade - Deluxe Edition",
    "normalPrice": 79.99,
    "salePrice": 6.0,
    "storeID": "2"
  },
  {
    "title": "The Spirit and the Mouse",
    "normalPrice": 19.99,
    "salePrice": 0.0,
    "storeID": "25"
  },
  {
    "title": "Maximum Entertainment Bundle",
    "normalPrice": 92.94,
    "salePrice": 4.64,
    "storeID": "7"
  },
  {
    "title": "Warhammer: End Times - Vermintide",
    "normalPrice": 44.99,
    "salePrice": 2.24,
    "storeID": "1"
  }
]
```

### 3. **GET /sobre**
Retorna informações sobre mim.

**Exemplo de requisição**:
```bash
GET http://localhost:8080/sobre
```

**Exemplo de resposta**:
```json
{
  "projeto": "Buscador de jogos",
  "estudante": "Artur Salvador Tiscoski"
}
```
