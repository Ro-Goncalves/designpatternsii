package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoQuarterState implements State {
    private static final long serialVersionUID = 2L;
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You insert a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        log.info("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        log.info("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        log.info("You ned to play first");
    }

    @Override
    public String toString() {
        return "waiting for quarter";
    }
    
}
