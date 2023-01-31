package br.com.rogon.alura.loja.pedido.acoes;

import br.com.rogon.alura.loja.pedido.Pedido;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CriarPedidoNoBanco implements AcaoAposGerarPedido {

	public void executarAcao(Pedido pedido) {
		log.info("Salvando pedido no banco de dados...");
	}

}
