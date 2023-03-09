package br.com.rogon.iluwatar.proxy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void shouldExecuteApplicationWithoutException(){
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
