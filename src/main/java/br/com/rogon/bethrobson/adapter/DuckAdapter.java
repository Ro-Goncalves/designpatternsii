package br.com.rogon.bethrobson.adapter;

import java.util.Random;

public class DuckAdapter implements Turkey {
    Duck duck;
    Integer rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random().nextInt(5);
    }

    @Override
    public void gobble() {
        duck.quack();        
    }

    @Override
    public void fly() {
        if(isFly()){
            duck.fly();
        }        
    }

    @Override
    public Boolean isFly() {
        return rand == 0 ? true : false;
    }
    
}
