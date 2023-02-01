package br.com.rogon.refactoringguru.adapter;

/**
 * Pinos Quadrados (SquarePegs) não são compatíveis com Buracos Redondos (RoundHoles)
 * (eles foram implementados pela equipe anterior). Precisaremos intregá-lo ao nosso 
 * programa.
 */
public class SquarePeg {
    private Double width;

    public SquarePeg(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public Double getSquare(){        
        return Math.pow(this.getWidth(), 2);
    }
}
