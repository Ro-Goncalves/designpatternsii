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
- [Facade](#facade)
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

Esse deu um certo trabalho em entender, foi necessário alguns dias, e banhos, pensando sobre o assunto. Cheguei a seguinte conclusão: **Composite** é utilizado para criar objetos complexos. Começamos com o esqueleto desse objeto, uma **Interface** ou **Abstract Class**, implementamos a parte mais abstrata desse objeto, ela implementas alguns dos métodos, e vamos subindo o nível de abstração até termos o objeto concreto. Da para ver isso muito fácil no exemplo do [Refactoring Guru - Composite](https://refactoring.guru/pt-br/design-patterns/composite/java/example), que foi replicado nesse diretório. Os outros dois exemplos são de objetos do nosso dia a dia, irá ajudar um certo tanto.

Agora vamos a uma definição um pouco mais formal, sair da minha cabeça e ir á literatura.

> O **Composite** permite compor objetos em uma estrutura de árvore, fazendo com que essa estrutura trabalhe como um único objeto.

Como dito, esse padrão vem nós ajudar com estruturas que se assemelham com árvores. Não sei se meu exemplo será muito bom, mas vamos lá. Imagina a ordem vinda do auto escalão do **Exércido Melância**, até que ela chegue ao baixo escalão, ela passa por várias pessoas, de várias *patentes*, o adjetivo. E pode seguir por caminhos diferente dependendo da mensagem. Conseguiu imaginar uma árvore? Pode imaginar um pé de melância, onde a mensagem saí da maior á menor, o caminho a seguir seria os *ramos*, até chegar a outra, e a outra melância. E pode até ter uma mensagem dentro da outra. Para um exemplo menos pornográfico leia as referências.

Imaginemos que essa mensagem será transportado pela saiva, ou malas com dinheiro, não não, seiva. Cada *pulso de seiva* pode transportar algumas mensagens, ou outro *pulso de seiva* com mensagens, ou mensagens e *pulso de seiva* com outras mensagens, é complicado. Uma mala pode contér dinheiro, uma outra mala com dinheiro dentro ou dinheiro e outra mala com dinheiro, às vezes esse dinheiro vai até à cueca, acontece. Esse padrão sugere que exista um intermediador entre a mensagem e o subordinado, **SEIVA**. Dessa forma quando perguntamos a mensagem qual o seu contéudo ela responde com a frase, quando perguntamos ao *puslo de seiva* ele pergunta para cada mensagem qual seu texto e os retorna, de dentro desse *pulso* existirem outros *pulsos* ele pergunta para o *pulso* que pergunta á mensagem. E assim vai.

Tudo muito complicado, muito dinheiro andando em malas por aí. O pulo do gato é que não precisamos nós preocupar com isso, ao usar esse padrão conversaremos com os objetos atráves da **Interface**, a resposta virá sem sabermos ao certo o que tem no objeto.

Para implementar essa parada toda devemos seguir um modelo. **Component** será a interface que conterá as operações comuns entre elementos simples e complexos da árvore. **Leaf** o elemento mais básico, o fim, faz o trabalho duro, pois não tem mais a quem delegá-lo, a ***mensagem***. **Composite**, pode conter a **Leaf** ou outro **Composite**, ele não sabe quem são seus filhos, trabalho com eles a partir da **Component**, ele delega o trabalho ao seu filho. O **Client** trabalho com os elementos à partir da interface, sem se importar se são objetos simples ou complexos.

Agora viria a parte que demonstro algum código ou coisa assim, não. Veja os exemplos e o que foi feito na aula da Alura, reflita sobre o que leu e viu. faça os exemplo e chegue às suas conclusões.

## Facade

E agora o **Facade**; bem, ele é um tanto quanto simples; em poucas palavras: quando a execução de alguma rotina é muito complexa, envolvendo várias classes e bibliotecas, podemos criar uma classe que fará todo esse meio de campo, assim nosso cliente só precisa utilizá-la.

Imagina só, toda vez que você for utilizar um framework ter que iniciar todos os objetos, parametrizá-los, chamá-los na ordem certa, e por ai vai. Não é legal ter esse tipo de código na camada de négocio. Imagina ter que replicar isso algumas vezes, agora imagina ter que dar manutenção.

É aí que entra a classe **Facade**, ela faz tudo isso para nós, fazendo com que a classe cliente tenha que instância-la passando pouco parâmetros.

## Proxy

E chegamos ao fim, cançados, claro, muita coisa foi vista nesse tempo, um dia ei de melhorar o que foi escrito aqui. **Proxy** é um padrão muito interessante, e possibilida muitas coisas, muitas mesmo. Ele fica no meio do objeto e o cliente, podendo executar rotinas antes ou depois das chamadas aos métodos. Isso pode ser muito bem aplicado quando trabalhamos com sistemas legados e precisamos expandi-los, ou com bibliotecas de terceiros.

Para fazermos isso precisamos criar o **Proxy** utilizando a mesma interface do objeto original, o **Proxy** delegará as chamadas ao objeto origial, e se necessário fará os tratamentos que não existiam antes, essa nova lógica pode acontecer antes ou depois da chamada.

Estruturalmente ele parece bem simples, temos nossa interface **ServiceInterface** ela é utilizada pela **Service**, seriá a biblioteca de terceiros ou classe dum sistema legado, e o **Proxy**, o cara que atualizará a **Service** para o novo cenário. Nosso cliente só precisa alterar a criação da classe de **Service** para **Proxy**, uma vez que as duas implementam a mesma interface, ou possuem os mesmos métodos e assinaturas da **Service**.

## Referências

[REFACTORING GURU - ADAPTER](https://refactoring.guru/pt-br/design-patterns/adapter)

[BETHROBSON - ADAPTER](https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/adapter)

[ILUWATAR - ADAPTER](https://github.com/iluwatar/java-design-patterns/tree/master/adapter)

[REFACTORING GURU - COMPOSITE](https://refactoring.guru/pt-br/design-patterns/composite)

[BETHROBSON - COMPOSITE](https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/composite)

[ILUWATAR - COMPOSITE](https://github.com/iluwatar/java-design-patterns/tree/master/composite)

[REFACTORING GURU - FACADE](https://refactoring.guru/pt-br/design-patterns/facade)

[BETHROBSON - FACADE](https://github.com/bethrobson/Head-First-Design-Patterns/tree/master/src/headfirst/designpatterns/facade/hometheater)

[ILUWATAR - FACADE](https://github.com/iluwatar/java-design-patterns/tree/master/facade)
