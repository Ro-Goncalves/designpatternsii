package br.com.rogon.bethrobson.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MallarDuck implements Duck {

    @Override
    public void quack() {
        log.info("Quack");        
    }

    @Override
    public void fly() {
        log.info("I'm flying");
    }
    
}
