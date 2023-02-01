package br.com.rogon.refactoringguru.adapter;

/*
 * Pinos Redondos (RoundPeg) são compatíveis com Buracos Redondos (RoundHole)
 */
public class RoundPeg {
    private Double radius;

    public RoundPeg(Double radius) {
        this.radius = radius;
    }

    public RoundPeg(){}

    public Double getRadius() {
        return radius;
    }    
}
