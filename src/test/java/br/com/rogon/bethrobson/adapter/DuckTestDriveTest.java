package br.com.rogon.bethrobson.adapter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class DuckTestDriveTest {
    
    @Test
    void deveriaExecutarAplicacaoSemExcecao(){
        assertDoesNotThrow(() -> DuckTestDrive.main(new String[]{}));
    }
}
