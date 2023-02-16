package br.com.rogon.alura.loja.pedido.acoes;

import br.com.rogon.alura.loja.pedido.Pedido;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDePedido implements AcaoAposGerarPedido {

    @Override
    public void executarAcao(Pedido pedido) {
        log.debug("Pedido foi gerado: " + pedido.toString());
        
    }
    
}
