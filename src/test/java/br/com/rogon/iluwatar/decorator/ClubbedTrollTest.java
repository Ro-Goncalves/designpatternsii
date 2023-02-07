package br.com.rogon.iluwatar.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rogon.iluwatar.util.InMemoryAppender;

public class ClubbedTrollTest {

    private InMemoryAppender appender;

    @BeforeEach
    void setUp(){
        appender = new InMemoryAppender(ClubbedTroll.class);
    }

    @AfterEach
    void tearDown(){
        appender.stop();
    }

    @Test
    void testClubbedTroll(){
        final var simpleTroll = spy(new SimpleTroll());
        final var clubbed = new ClubbedTroll(simpleTroll);

        assertEquals(20, clubbed.getAttackPower());
        verify(simpleTroll, times(1)).getAttackPower();

        //Quando Clubbed ataca, delega para Simple
        clubbed.attack();
        verify(simpleTroll, times(1)).attack();
        assertEquals("The troll swings at you with a club!", appender.getLastMessage());

        clubbed.fleeBattle();
        verify(simpleTroll, times(1)).fleeBattle();

        verifyNoMoreInteractions(simpleTroll);
    }
    
}
