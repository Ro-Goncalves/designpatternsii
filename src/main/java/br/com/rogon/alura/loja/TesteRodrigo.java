package br.com.rogon.alura.loja;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.rogon.alura.loja.orcamento.ItemOrcamento;

public class TesteRodrigo {
    public static void main(String[] args) {
        List<ItemOrcamento> itens = List.of(
            new ItemOrcamento(BigDecimal.TEN),
            new ItemOrcamento(BigDecimal.ONE),
            new ItemOrcamento(BigDecimal.TEN)
        );

        Optional<BigDecimal> valor = itens.stream()
             .map(item -> item.getValor())
             .reduce((a, b) -> a.add(b));

        System.out.println(valor.get());
    }
}