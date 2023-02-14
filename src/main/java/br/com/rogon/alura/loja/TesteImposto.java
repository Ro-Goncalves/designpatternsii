package br.com.rogon.alura.loja;

import java.math.BigDecimal;

import br.com.rogon.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.rogon.alura.loja.imposto.ICMS;
import br.com.rogon.alura.loja.imposto.ISS;
import br.com.rogon.alura.loja.orcamento.ItemOrcamento;
import br.com.rogon.alura.loja.orcamento.Orcamento;

public class TesteImposto {
    public static void main(String[] args) {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("100"));
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item);
        CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();

        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ISS(new ICMS(null))));
        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ISS(null)));
        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ICMS(null)));
    }
}
