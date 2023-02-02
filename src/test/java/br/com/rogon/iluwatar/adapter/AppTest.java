package br.com.rogon.iluwatar.adapter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/**
 * Testa se o adapter de exemplo roda sem erros
 */
public class AppTest {

    /**
     * Verifica se o método principal lança alguma exceção
     */

     @Test
     void deveriaExecutarAplicacaoSemExcecao(){
        assertDoesNotThrow(() -> App.main(new String[]{}));
     }
    
}
