package br.com.rogon.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
	}

}
