package br.com.rogon.iluwatar.decorator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class AppTest {
    
    @Test
    void shouldExecuteApplicationWithotExeception(){
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
