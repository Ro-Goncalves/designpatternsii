package br.com.rogon.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.DomainException;
import br.com.rogon.alura.loja.orcamento.Orcamento;

public class Finalizado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		throw new DomainException("Orcamento finalizado nao pode ter desconto extra!");
	}

	@Override
	public String toString() {
		return "Finalizado";
	}

}
