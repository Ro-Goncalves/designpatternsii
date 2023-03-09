package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldOutState implements State {
    private final static long serialVersionUID = 2L;
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        log.info("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        log.info("You turned, but thre are no Gumballs");
    }

    @Override
    public void dispense() {
        log.info("No Gumball dispensed");
    }

    @Override
    public String toString() {
        return "sold out";
    }
    
}
