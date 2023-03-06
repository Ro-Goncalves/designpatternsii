package br.com.rogon.alura.loja;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.orcamento.ItemOrcamento;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import br.com.rogon.alura.loja.orcamento.OrcamentoProxy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestesComposicao {
    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        novo.adicionarItem(antigo);

        OrcamentoProxy orcamentoProxy = new OrcamentoProxy(novo);

        log.info("Valor novo orcamento: " + orcamentoProxy.getValor());
        log.info("Valor novo orcamento: " + orcamentoProxy.getValor());

    }
}
