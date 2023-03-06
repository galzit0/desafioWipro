# Descrição do projeto
Este projeto tem como objetivo realizar consultas de endereços utilizando a API ViaCep. 
A consulta é realizada através do envio do CEP via método POST e retorna um objeto 
com as informações do endereço, além de calcular o frete com base no estado informado.

### Pré-requisitos
* JDK 11 ou superior
* Maven 3.6.3 ou superior
* IDE de sua preferência

### Como executar
* Clone o repositório para a sua máquina local
* Abra a IDE de sua preferência e importe o projeto como um projeto Maven.
* Inicie a aplicação a partir da classe DesafioWiproApplication.
* Utilize uma ferramenta de sua preferência (como o Postman) para realizar requisições para a API. 
O endpoint para realizar a consulta de endereço é POST /v1/consulta-endereco. Também podemos utilizar o 
Swagger com o endereço <http://localhost:8080/swagger-ui/index.html>.

### Exemplo de requisição
~~~json
{
"cep": "01311-000"
}
~~~
### Exemplo de resposta
~~~json
{
"cep": "01311-000",
"rua": "Avenida Paulista",
"complemento": "complemento teste",
"bairro": "Bela Vista",
"cidade": "São Paulo",
"estado": "SP",
"frete": 7.85
}
~~~
### Autor
* Nome: Gabriel Pequeno
* E-mail: gabriel.icaroandrade@gmail.com
* GitHub: <https://github.com/galzit0>
