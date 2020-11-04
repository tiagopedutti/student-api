# student-api
Simples API de busca de estudantes para testes.

## Observação
A API é integrada com o WebService para consulta de endereços [ViaCep](https://viacep.com.br/). O sistema torna obrigatório um cep válido para armazenar um usuário com o endereço completo (exceto número da residência)

## API

- `[GET] /students` - Busca os dados do aluno;
- `[POST] /students` - Cadastra um novo aluno;

Exemplo de corpo da requisição:
```
{
    "name": "John Doe",
    "email": "johndoe@outlook.com",
    "semester": 5,
    "zipcode": "11701090"
}
```
- `[GET] /student/{id}` - Busca um aluno pelo id;
- `[PUT] /student/{id}` - Busca um aluno pelo id e altera de acordo com os dados enviados;
Exemplo de corpo da requisição:
```
{
    "name": "Foo Bar",
    "email": "foobar@gmail.com",
    "semester": 2,
    "zipcode": "11710100"
}
```
- `[DELETE] /student/{id}` - Remove um aluno pelo id.
