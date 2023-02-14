package br.com.rogon.alura.loja.pedido;

import java.math.BigDecimal;
import java.util.List;

import br.com.rogon.alura.loja.orcamento.ItemOrcamento;

public class GeraPedido {

	private String cliente;
	private List<ItemOrcamento> itens;

	public GeraPedido(String cliente, List<ItemOrcamento> itens) {
		this.cliente = cliente;
		this.itens = itens;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return itens.stream()
		            .map(item -> item.getValor())
					.reduce((a, b) -> a.add(b))
					.get();
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public List<ItemOrcamento> getItens() {
		return itens;
	}

}
