package br.com.rogon.alura.loja.orcamento;

import java.util.Map;

import br.com.rogon.alura.loja.DomainException;
import br.com.rogon.alura.loja.http.HttpAdapter;

public class RegistroOrcamento {
    
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
