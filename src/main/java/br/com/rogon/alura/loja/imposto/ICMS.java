package br.com.rogon.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.orcamento.Orcamento;

public class ICMS implements Imposto {

	public BigDecimal calcular(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}

}
