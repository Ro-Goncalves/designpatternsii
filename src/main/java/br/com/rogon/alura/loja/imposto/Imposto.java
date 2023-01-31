package br.com.rogon.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.orcamento.Orcamento;

public interface Imposto {

	BigDecimal calcular(Orcamento orcamento);

}
