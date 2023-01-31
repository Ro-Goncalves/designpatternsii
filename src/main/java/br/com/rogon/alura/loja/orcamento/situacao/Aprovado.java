package br.com.rogon.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.DomainException;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Aprovado extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.02"));
	}

	@Override
	public void finalizar(Orcamento orcamento) throws DomainException {
		orcamento.setSituacao(new Finalizado());
		log.info("O orcamento foi -> Finalizado");
	}

	@Override
	public String toString() {
		return "Aprovado";
	}

}
