package br.com.rogon.iluwatar.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WizardTest {
    @Test
    void testToString(){
        List.of("Gandalf", "Dumbledore", "Oz", "Merlin")
            .forEach(name -> assertEquals(
                "Wizard [name=" + name + "]", new Wizard(name).toString()));
    }
}
