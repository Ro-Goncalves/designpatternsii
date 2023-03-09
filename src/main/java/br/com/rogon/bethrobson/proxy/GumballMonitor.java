package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GumballMonitor {   
    private GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    public void report(){
        log.info("Gumball Machine: {}", machine.getLocation());
        log.info("Current inventory: {} gumballs", machine.getCount());
        log.info("Current state: {}", machine.getState());
    }
}
