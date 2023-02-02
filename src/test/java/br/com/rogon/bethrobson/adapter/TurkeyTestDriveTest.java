package br.com.rogon.bethrobson.adapter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/**
 * Verifica se o teste roda sem erros
 */
public class TurkeyTestDriveTest {

    /**
     * Verifica o método main
     */
    @Test
    void deveriaExecutarAplicacaoSemExcecao(){
        assertDoesNotThrow(() -> TurkeyTestDrive.main(new String[]{}));
    }
    
}
