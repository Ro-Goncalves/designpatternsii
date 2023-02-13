# Design Patterns Em Java II: Avançando Nas Boas Práticas De Programação <!-- omit in toc -->

E seguimos a vida aprendendo novas coisas, casa vez mais saindo de *baby* para estagiário. Nesse momento eu creio já ter aprendido a falar *papai*. Àquele que não intenteram, hoje devo conhecer uma ou duas coisas sobre desenvolvimento, aquele de verdade.

Amei o curso anterior, aprendi bastante coisa e apliquei umas outras tantas. Esse conteúd é realmente impolgante e da vontade de aprender cada vez mais. Devo tomar cuidado para não ficar querem copiar tudo quanto é código que eu ache legal.

Recomendo a todos, e não *todes*, coisa i--a, a visitarem o git o **Iluwatar**, gostei muito dele. E deem uma olhada com carinho nas referências.

Do mais, rogemos à Deus para que ilumine nosssa inteligência, assim poderemos percorrer os caminhos do aprendizado com mais leveza e sem muitos problemas. Que possamos nós manter sempre na busca da Verdade, do Belo e da Perfeição.

>Pedis e lhe será dado.

## Menu <!-- omit in toc -->

- [Adapter](#adapter)
- [Decorator](#decorator)
- [Composite](#composite)
- [Facede](#facede)
- [Proxy](#proxy)
- [Referências](#referências)

## Adapter

Eeeee começou o jogo - sic, Zangado. Deixo aqui uma dica: Empolque-se, sempre, estudar é uma virtude, talvez uma das mais dificeis hoje em dia. **Adapter** é exatamente o que o nome quer dizer, adaptador, fazer com que um código se adapte a outro sem grandes dores de cabeça.

Eu gosto de utiliza-los, já tive uma discução comigo sobre como resolver um problema, isso antes de conhecer esse padrão. Esse problema era o seguinte: *O que aconteceria seu o fornecerdor alterasse alguma informação em sua API? Bem, tudo o que implementei falharia, e poderia falhar em uma pancada de lugares. Como posso resolver isso? Criar minha propria função que servirá como meio de campo, de tal forma que, minha classe chama a minha função que chama a função do fornecedor.*

Foi meio que isso o que pensei, esse é um resumo de alguns dias contemplando essa questão.

Vamos agora a uma definição um pouco mais formal. Esse é um padrão estrutural, ele permite a comunicação de objetos com interfaces incompatíveis entre si.

O problema que ele resolve é meio o que já comentei, só que no meu caso eu quero previnir que um problema aconteça, e a idealização desse padrão e fazer com que duas coisas diferentes, que fazem a mesma coisa, trabalhem juntas. Imagina que você está lendo um arquivo CSV e o utilizando como fonte de dados, e em um dado nomento o pessoal resolveu salvar essas informações em um XLSX. As biblitecas que trabalham com esses formatos de arquivos podem ser diferentes, e retornar informações duma forma diferente.

A solução seria criar um **Interface adapter** com os mesmos métodos que nossa classe cliente utiliza, criar uma classe **Concrete Adapter** que lerá o XLSX e passará as informação ao **Client** da forma que ele espera.

Meio que isso.

De forma genêrica: O **Client** contém a regra de negócio. **Client Interface** descreve como as outras classes devem interagir com o **Client**. **Service** é a biblioteca de terceiro, ou sistema legado, enfim, o Ser problemático que não se comunica direito com **Client**. **Adapter** é aquele que conhece os dois mundos, ele sabe das necessidades da **Client** e como converter a **Service** para que a relação **Service-Client** seja saudável. O **Client** deve trabalhar com o **Adapter** atráves da **Client Interface**, assim evitamos o acoplamento, e podemos adicionar vários **Adapteres** sem quebrar o código do cliente (*ou nosso fornecedor pode mudar a expecificação de sua API, o que acarretará na quebra do adaptador e não dos pontos onde utilizamos a funcionalidade alterada*).

Um pouco de código para nós.

Iremos enviar nosso orçamento a uma API, porém existem **N** formas de fazer isso em Java, e não sabemos qual a melhor. Por isso vamos seguir a regra de ouro: ***Mais vale um na mão do que dois voando***. Iremos utilizar o biblioteca `Http`.

Primeiro criaremos o **Adapter**, com o menor código que precisamos.

```java
public interface HttpAdapter {
    void post(String url, Map<String, Object> dados);
}
```

O próximo passo e a implementação do mesmo.

```java
//Aprendendo a utilizar o lombok, gostei dele.
@Slf4j
public class JavaHttpClient implements HttpAdapter{

    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            log.info("Abrindo Conexao com -> " + urlDaApi.toString());
            /*
            Comentado pois se chamar daria erro.
            URLConnection connection = urlDaApi.openConnection();
            connection.connect();
            */
            log.info("Enviando dado a API -> " + dados.toString());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisição http", e);
        }
        
    }
    
}
```

A classe que gravará essa informação fica assim:

```java
public class RegistroOrcamento {
    
    //Utilizar a interface, não classe concreta.
    private HttpAdapter httpAdapter;

    public RegistroOrcamento(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    public void registrar(Orcamento orcamento){
        if(!orcamento.isFinalizado()){
            throw new DomainException("Orçamento nao finalizado");
        }

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
            "valor", orcamento.getValor(),
            "quantidadeDeItens", orcamento.getQuantidadeItens()
        );

        httpAdapter.post(url, dados);
    }
}
```

Será que tudo deu certo?

```java
@Slf4j
public class TestesAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(BigDecimal.TEN, 1);
        orcamento.aprovar();
        orcamento.finalizar();

        log.info("Salvar o orcamento: " + orcamento.toString());
        RegistroOrcamento registro = new RegistroOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }
}
```

```console
[main] INFO br.com.rogon.alura.loja.orcamento.situacao.EmAnalise - O orcamento foi -> Aprovado
[main] INFO br.com.rogon.alura.loja.orcamento.situacao.Aprovado - O orcamento foi -> Finalizado
[main] INFO br.com.rogon.alura.loja.TestesAdapter - Salvar o orcamento: Orcamento [valor=10, quantidadeItens=1, situacao=Finalizado]
[main] INFO br.com.rogon.alura.loja.http.JavaHttpClient - Abrindo Conexao com -> http://api.externa/orcamento
[main] INFO br.com.rogon.alura.loja.http.JavaHttpClient - Enviando dado a API -> {quantidadeDeItens=1, valor=10}
```

## Decorator

Esse é um tanto quanto difícil de intender, e um outro tando para identificar onde usar. Vamos ver se tudo fica mais claro.

Esse é um padrão estrutural que permite o acoplamento de novos comportamentos a um objeto, o colocando dentro de um invólucro. Até que vendo assim parece ser simples, é tipo uma camisinha, ou um drink de café, temos o café base e podemos ir adicionando coisas nele, com isso teremos vários tipos de café.

Temos que ter algo em nossa cabeça: **extender uma classe é ruim**. No exemplo a cima, temos a classe **Cafe**, quantas outras poderiam existir para os drinks? Uma **CafeLeite**, outra **CafeChocolate**, outra **CafeLeiteChocolate**, e sabe lá Deus mais o que. Temos que pensar em *Composição*, com isso nossa classe delegará algumas coisas a outra. Veja, **I**, do SOLID, ele diz para dependermos de interfaçe, se nossa classe tiver uma referência a um interface, **DrinksCafe**, poderemos alterar o tipo de drink na classe **Cafe** simplesmente alterando a referência. Ficará mais claro, acredite.

Os *wrapper*, classes que serão decoradoras, ele é o papel de bala da classe, o embrulho. Ela tem os mesmos métodos do alvo, e pode fazer algo antes ou depois do método, o resto ela delega. Com isso conseguimos alterar o comportamento da classe; antes de entregar o café ao cliente, coloque leite.

Esse padrão funciona como uma plilha, vamos colanddo vários papeis de bala, um em cima do outro. Para mim: **Decorator** é uma pilha de **Strategy**.

Ainda está confuso, eu sei, vai piorar, pode relaxar. Vamos tentar mexer o bolo e ver se deixamos a massa mais homogênea. Teremos que ter uma interfaça **Component**, lembre-se do **I**, ela será o contrato entre os papeis de bala e a bala. O **Concret Component**, é a classe já existente, a bala. Uma outra classe, algo entre a bala e o papel, é a **Base Decorator**, ela tem um campo que referência a interface, com isso ela pode conter os componentes concretos e os decoradores, ela delega todas as operações para o objeto envolvido. E o papel, **Concrete Decorators**, eles sobrescrevem os métodos do **Base Decorator**, adicionando comportamentos antes ou depois. O **Client** pode envolver o compomente com multiplas camadas de decoradores.

>Pilha de Strategy.



## Composite

## Facede

## Proxy

## Referências

[REFACTORING GURU - ADAPTER](https://refactoring.guru/design-patterns/adapter)
