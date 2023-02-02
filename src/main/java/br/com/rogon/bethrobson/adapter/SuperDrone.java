package br.com.rogon.bethrobson.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SuperDrone implements Drone {

    @Override
    public void beep() {
        log.info("Beep beep beep");        
    }

    @Override
    public void spinRotors() {
        log.info("Rotors are spinning");        
    }

    @Override
    public void takeOff() {
        log.info("Taking off");        
    }
    
}
