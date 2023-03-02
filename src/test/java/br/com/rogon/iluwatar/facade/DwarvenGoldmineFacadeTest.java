package br.com.rogon.iluwatar.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rogon.iluwatar.util.InMemoryAppender;

public class DwarvenGoldmineFacadeTest {
    private InMemoryAppender appender;

    @BeforeEach
    void setUp(){
        appender = new InMemoryAppender();
    }

    @AfterEach
    void tearDown(){
        appender.start();
    }

    @Test
    void testFullWorkDay(){
        final var  goldMine = new DwarvenGoldmineFacade();

        //Bora acordar cambada
        goldMine.startNewDay();
        
        //wake up
        assertTrue(appender.logContains("Dwarf gold digger wakes up."));
        assertTrue(appender.logContains("Dwarf cart operator wakes up."));
        assertTrue(appender.logContains("Dwarven tunnel digger wakes up."));

        //go to the mine
        assertTrue(appender.logContains("Dwarf gold digger goes to the mine."));
        assertTrue(appender.logContains("Dwarf cart operator goes to the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to the mine."));

        //Não deve existir outras ações
        assertEquals(6, appender.getLogSize());

        //work
        goldMine.digOutGold();
        assertTrue(appender.logContains("Dwarf gold digger digs for gold."));
        assertTrue(appender.logContains("Dwarf cart operator moves gold chunks out of the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger creates another promising tunnel."));

        //Não deve existir outras ações
        assertEquals(9, appender.getLogSize());

        //Podem ir para casa
        goldMine.endDay();

        //go to the home
        assertTrue(appender.logContains("Dwarf gold digger goes home."));
        assertTrue(appender.logContains("Dwarf cart operator goes home."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes home."));

        //go to slepp
        assertTrue(appender.logContains("Dwarf gold digger goes to sleep."));
        assertTrue(appender.logContains("Dwarf cart operator goes to sleep."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to sleep."));

        //Não deve existir outras ações
        assertEquals(15, appender.getLogSize());
    }
}
