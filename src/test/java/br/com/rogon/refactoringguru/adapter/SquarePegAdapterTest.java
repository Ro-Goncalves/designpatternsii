package br.com.rogon.refactoringguru.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SquarePegAdapterTest {
    
    /*
     * Um Pino Quadrado (SquarePeg) deveria caber 
     * dentro de um Buraco Redondo (RoundHole) com 
     * raio maior ou igual a metade do diametro do
     * Pino Quadrado
     */
    @Test
    void squarePegFitsRoundHole(){
        var roundHole = new RoundHole(Double.parseDouble("10"));
        var squarePeg = new SquarePeg(Double.parseDouble("10"));
        var squarePegAdapter = new SquarePegAdapter(squarePeg);        
        
        assertTrue(() -> roundHole.fits(squarePegAdapter));
    }

    /*
     * Um Pino Quadrado (SquarePeg) não deveria caber 
     * dentro de um Buraco Redondo (RoundHole) com 
     * raio menor do que o diametro do Pino Quadrado
     */
    @Test
    void squarePegNotFitsRoundHole(){
        var roundHole = new RoundHole(Double.parseDouble("10"));
        var squarePeg = new SquarePeg(Double.parseDouble("20"));
        var squarePegAdapter = new SquarePegAdapter(squarePeg);        
        
        assertFalse(() -> roundHole.fits(squarePegAdapter));

    }
}
