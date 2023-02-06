package br.com.rogon.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.orcamento.Orcamento;

public class ICMS extends Imposto {

	public ICMS(Imposto outro) {
		super(outro);
	}

	@Override
	public BigDecimal realizarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}

}
