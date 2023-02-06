package br.com.rogon.refactoringguru.adapter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    void shouldExecuteWithoutException(){
        assertDoesNotThrow(() -> Demo.main(new String[]{}));
    }
    
}
