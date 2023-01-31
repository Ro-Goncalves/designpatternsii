package br.com.rogon.alura.loja;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.http.JavaHttpClient;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import br.com.rogon.alura.loja.orcamento.RegistroOrcamento;
import lombok.extern.slf4j.Slf4j;

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
