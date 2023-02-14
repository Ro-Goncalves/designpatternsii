package br.com.rogon.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.rogon.alura.loja.orcamento.Orcamento;
import br.com.rogon.alura.loja.pedido.acoes.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoesAposGerarPedido;
	
	// injecao de dependencias para servicos de infra
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoesAposGerarPedidos) {
		acoesAposGerarPedido = acoesAposGerarPedidos;
	}

	public void executar(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento();
		geraPedido.getItens().forEach(
			item -> orcamento.adicionarItem(item)
		);
		
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);

		this.acoesAposGerarPedido.forEach(a -> a.executarAcao(pedido));
	}
	
}
