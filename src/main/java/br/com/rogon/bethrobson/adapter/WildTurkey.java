package br.com.rogon.bethrobson.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        log.info("Gobble gobble");        
    }

    @Override
    public void fly() {
        log.info("I'm flying a short distance");        
    }

    @Override
    public Boolean isFly() {        
        return true;
    }
    
    
}
