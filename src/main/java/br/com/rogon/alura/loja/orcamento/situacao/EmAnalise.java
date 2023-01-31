package br.com.rogon.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.DomainException;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmAnalise extends SituacaoOrcamento {

	@Override
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}

	@Override
	public void aprovar(Orcamento orcamento) throws DomainException {
		orcamento.setSituacao(new Aprovado());
		log.info("O orcamento foi -> Aprovado");
	}
	
	@Override
	public void reprovar(Orcamento orcamento) throws DomainException {
		orcamento.setSituacao(new Reprovado());
		log.info("O orcamento foi -> Reprovado");
	}

	@Override
	public String toString() {
		return "EmAnalise";
	}

}
