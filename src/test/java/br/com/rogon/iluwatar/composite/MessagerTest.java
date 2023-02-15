package br.com.rogon.iluwatar.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessagerTest {
    private ByteArrayOutputStream stdOutBuffer = new ByteArrayOutputStream();
    private final PrintStream realStdOut = System.out;

    @BeforeEach
    void setUp(){
        this.stdOutBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOutBuffer));
    }

    @AfterEach
    void tearDown(){
        System.setOut(realStdOut);
    }

    @Test
    void testMessageFromOrcs(){
        final var messenger = new Messenger();
        testMessage(
            messenger.messageFromOrcs(),
            "Where there is a whip there is a way."
        );
    }

    @Test
    void testMessageFromElves(){
        final var messenger = new Messenger();
        testMessage(
            messenger.messageFromElves(), 
            "Much wind pours from your mouth.");
    }

    private void testMessage(final LetterComposite composedMessage, final String message){
        final var words = message.split(" ");
        assertNotNull(composedMessage);
        assertEquals(words.length, composedMessage.count());

        composedMessage.print();

        assertEquals(message, new String(this.stdOutBuffer.toByteArray()).trim());
    }
}
