package br.com.rogon.refactoringguru.adapter;

/*
 * Buracos Redondos (RoundHole) são compatíveis com Pinos Redondos (RoundPegs)
 */
public class RoundHole {
    private Double radius;

    public RoundHole(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public Boolean fits(RoundPeg peg){        
        return this.getRadius() >= peg.getRadius();
    }
}
