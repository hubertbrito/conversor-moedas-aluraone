# conversor-de-moedas-curso-aluraone

##Conversor de Moedas em Java
Olá! Eu sou um desenvolvedor iniciante e criei este projeto de conversor de moedas em Java para o desafio do  curso Alura One. Vou compartilhar com você como fiz isso, as dificuldades que enfrentei.
##Motivação
Eu queria criar um aplicativo simples que permitisse aos usuários converter valores entre diferentes moedas. Para isso usei uma API de taxas de câmbio exchangerate-api.com para implementar um conversor em Java. Para tornar o aplicativo de conversão de moedas mais aberto e flexível, utilizei as seguintes estratégias:
####Em vez de limitar o aplicativo a algumas moedas específicas, permiti que o usuário digitasse qualquer sigla de moeda.
####O programa compara a sigla inserida pelo usuário com as siglas disponíveis na API.
##Tecnologias Utilizadas
####Java: Linguagem de programação.
####HttpUrlConnection: Classe Java para fazer requisições HTTP.
####API de Taxas de Câmbio: Fonte de dados para obter as taxas de conversão.
##Como Fiz
###Obtendo os Dados da API:
Comecei criando uma classe chamada ConexaoApi. Essa classe é responsável por fazer uma conexão com a API de taxas de câmbio.
Usei a classe HttpURLConnection para enviar uma requisição GET para a URL da API.
A resposta da API foi lida e transformada em uma string.
##Analisando os Dados:
Criei uma classe chamada ConversorMoedas para lidar com a conversão.
No construtor dessa classe, instanciei a classe ConexaoApi para obter os dados da API.
Os dados retornados pela API foram analisados como um objeto JSON usando o JsonParser.
A variável taxasCambio contém as taxas de câmbio entre diferentes moedas.
##Realizando a Conversão:
Implementei o método converterMoeda() na classe ConversorMoedas.
Esse método recebe um valor, a moeda de origem e a moeda de destino.
Ele calcula a conversão com base nas taxas de câmbio obtidas da API.
##Dificuldades Enfrentadas
Como iniciante, enfrentei algumas dificuldades durante o desenvolvimento:
Entender a Estrutura do JSON:
Analisar os dados retornados pela API foi um desafio. Tive que estudar a estrutura do JSON para extrair as informações corretas.
##Tratamento de Erros:
Lidar com exceções, como quando a moeda de origem ou destino não era encontrada, foi complicado. Tive que implementar tratamentos adequados.
##Escolha entre HttpUrlConnection e HttpClient:
Optei pelo HttpUrlConnection porque era uma classe nativa do Java e suficiente para o meu projeto. No entanto, pesquisei sobre o HttpClient também.

##Como Executar
Clone este repositório.
Compile o código Java.
Execute o arquivo gerado
Você precisará da biblioteca Gson para analisar os dados JSON e adicioná-la como dependência em seu projeto.

