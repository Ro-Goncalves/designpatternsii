package br.com.rogon.iluwatar.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rogon.iluwatar.util.InMemoryAppender;

public class SimpleTrollTest {
    
    private InMemoryAppender appender;

    @BeforeEach
    void setUp(){
        appender = new InMemoryAppender(SimpleTroll.class);
    }

    @AfterEach
    void tearDown(){
        appender.stop();
    }

    @Test
    void testTrollActions(){
        final var troll = new SimpleTroll();
        assertEquals(10, troll.getAttackPower());

        troll.attack();
        assertEquals("The troll tries to grab you!", appender.getLastMessage());

        troll.fleeBattle();
        assertEquals("The troll shrieks in horror and runs away!", appender.getLastMessage());

        assertEquals(2, appender.getLogSize());
    }
    
}
