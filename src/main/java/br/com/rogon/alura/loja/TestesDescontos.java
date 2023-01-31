package br.com.rogon.alura.loja;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestesDescontos {

	public static void main(String[] args) {
		Orcamento primeiro = new Orcamento(new BigDecimal("200"), 6);
		Orcamento segundo = new Orcamento(new BigDecimal("1000"), 2);
		Orcamento terceiro = new Orcamento(new BigDecimal("500"), 1);

		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		log.info(calculadora.calcular(primeiro).toString());
		log.info(calculadora.calcular(segundo).toString());
		log.info(calculadora.calcular(terceiro).toString());
	}

}
