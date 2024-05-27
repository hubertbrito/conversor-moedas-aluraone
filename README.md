
# Conversor de Moedas em Java

Olá! Eu sou um desenvolvedor iniciante e criei este projeto de conversor de moedas em Java para o desafio do curso Alura One. Vou compartilhar com você como fiz isso e as dificuldades que enfrentei.

## Motivação

Eu queria criar um aplicativo simples que permitisse aos usuários converter valores entre diferentes moedas. Para isso, usei a API de taxas de câmbio [exchangerate-api.com](https://www.exchangerate-api.com) para implementar um conversor em Java. Para tornar o aplicativo de conversão de moedas mais aberto e flexível, utilizei as seguintes estratégias:

- Em vez de limitar o aplicativo a algumas moedas específicas, permiti que o usuário digitasse qualquer sigla de moeda entre as 161 disponiveis na api. Porém, algumas falham, por isso tratei alguns erros com menssagens apropriadas.
- O programa compara a sigla inserida pelo usuário com as siglas disponíveis na API.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **HttpCliente HttpRequest e httpResponse**: Para criar um cliente, fazer conexão com a api e obter a resposta da requisição pelo método get.
- **API de Taxas de Câmbio**: Fonte de dados para obter as taxas de conversão.

## Como Fiz

### Obtendo os Dados da API

1. Comecei criando uma classe chamada `ConexaoApi`. Essa classe é responsável por fazer uma conexão com a API de taxas de câmbio.
2. Usei as classes `HttpCliente HttpRequest e httpResponse` para enviar uma requisição para a URL da API.
3. A resposta da API foi lida e transformada em uma string.

### Analisando os Dados

1. Criei uma classe chamada `ConversorMoedas` para lidar com a conversão.
2. No construtor dessa classe, instanciei a classe `ConexaoApi` para obter os dados da API.
3. Os dados retornados pela API foram analisados como um objeto JSON usando o `JsonParser`.
4. A variável `taxaDeCambio` contém as taxas de câmbio entre diferentes moedas.

### Realizando a Conversão

1. Implementei o método `converterMoeda()` na classe `ConversorMoedas`.
2. Esse método recebe um valor, a atual a ser convertida e a moeda a comversora que é a qual se quer o valor equivalente.
3. Ele calcula a conversão com base nas taxas de câmbio obtidas da API.

## Dificuldades Enfrentadas

### Entender a Estrutura do JSON

Analisar os dados retornados pela API foi um desafio. Tive que estudar a estrutura do JSON para extrair as informações corretas.

### Tratamento de Erros

Lidar com exceções, como quando a moeda atual a ser convertida ou a conversora não era encontrada, foi complicado. Tive que implementar tratamentos básicos que me pareceram adequados.

### Escolha entre HttpUrlConnection e HttpClient

Optei pelo `HttpClient` porque era uma classe que aprendi no curso alura one.  No entanto, pesquisei sobre HttpConection uma classe nativa do Java e suficiente para o meu projeto, mas, preferi seguir com a primeira que ja conhecia.

## Como Executar
Clone este repositório.
Compile o código Java.
Execute o arquivo gerado
Você precisará da biblioteca Gson para analisar os dados JSON e adicioná-la como dependência em seu projeto.

