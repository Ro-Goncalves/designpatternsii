package br.com.rogon.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.rogon.alura.loja.orcamento.ItemOrcamento;
import br.com.rogon.alura.loja.pedido.GeraPedido;
import br.com.rogon.alura.loja.pedido.GeraPedidoHandler;
import br.com.rogon.alura.loja.pedido.acoes.CriarPedidoNoBanco;
import br.com.rogon.alura.loja.pedido.acoes.EnviarPedidoPorEmail;
import br.com.rogon.alura.loja.pedido.acoes.LogDePedido;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Ana da Silva";
		List<ItemOrcamento> itens = List.of(
			new ItemOrcamento(new BigDecimal("745.99")),
			new ItemOrcamento(new BigDecimal("745.99")),
			new ItemOrcamento(new BigDecimal("745.99"))
		);
		
		
		GeraPedido gerador = new GeraPedido(cliente, itens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
				new EnviarPedidoPorEmail(),
				new CriarPedidoNoBanco(),
				new LogDePedido()));
		handler.executar(gerador);
	}

}
