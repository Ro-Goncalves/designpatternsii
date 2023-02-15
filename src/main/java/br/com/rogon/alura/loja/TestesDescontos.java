package br.com.rogon.alura.loja;

import java.math.BigDecimal;
import java.util.List;

import br.com.rogon.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.rogon.alura.loja.orcamento.ItemOrcamento;
import br.com.rogon.alura.loja.orcamento.Orcamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestesDescontos {

	public static void main(String[] args) {
		List<ItemOrcamento> itens = List.of(
			new ItemOrcamento(new BigDecimal("200")),
			new ItemOrcamento(new BigDecimal("1000")),
			new ItemOrcamento(new BigDecimal("500"))
		);

		Orcamento primeiro = new Orcamento();
		for (int i = 0; i < 6; i++) {
			primeiro.adicionarItem(itens.get(0));
		}

		Orcamento segundo = new Orcamento();
		for (int i = 0; i < 2; i++) {
			segundo.adicionarItem(itens.get(1));
		}

		Orcamento terceiro = new Orcamento();		
		terceiro.adicionarItem(itens.get(2));		

		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		log.info(calculadora.calcular(primeiro).toString());
		log.info(calculadora.calcular(segundo).toString());
		log.info(calculadora.calcular(terceiro).toString());
	}

}
