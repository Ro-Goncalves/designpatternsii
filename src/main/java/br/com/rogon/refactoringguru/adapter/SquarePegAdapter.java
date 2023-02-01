package br.com.rogon.refactoringguru.adapter;

public class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg){
        this.peg = peg;
    }

    @Override
    public Double getRadius(){
        return Math.sqrt((Math.pow((peg.getWidth() / 2), 2) * 2));
    }

}
