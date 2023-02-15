package br.com.rogon.iluwatar.composite;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class AppTeste {
    @Test
    void shuoldExecutedApplicationWithoutException(){
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
