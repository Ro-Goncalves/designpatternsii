package br.com.rogon.iluwatar.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rogon.iluwatar.util.InMemoryAppender;

public class IvoryTowerTest {
    
    private InMemoryAppender appender;

    @BeforeEach
    void setUp(){
        appender = new InMemoryAppender(IvoryTower.class);
    }

    @AfterEach
    void tearDown(){
        appender.stop();
    }

    @Test
    void testeEnter(){
        final var wizards = List.of(
            new Wizard("Gandalf"),
            new Wizard("Dumbledore"),
            new Wizard("Oz"),
            new Wizard("Merlin")
        );

        var tower = new IvoryTower();
        wizards.forEach(tower::enter);

        assertTrue(appender.logContains("Wizard [name=Gandalf] enters the tower."));
        assertTrue(appender.logContains("Wizard [name=Dumbledore] enters the tower."));
        assertTrue(appender.logContains("Wizard [name=Oz] enters the tower."));
        assertTrue(appender.logContains("Wizard [name=Merlin] enters the tower."));

        assertEquals(4, appender.getLogSize());
    }
}
