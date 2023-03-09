package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldState implements State {
    private static final long serialVersionUID = 2L;
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("Please wait, we're already giving you a Gumball");
    }

    @Override
    public void ejectQuarter() {
        log.info("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        log.info("Turning twice doesn't get you another Gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        try {
            if(gumballMachine.getCount() > 0){
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                log.info("Oops, out of Gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        } catch (Exception e) {
            log.error(e.getMessage() + " - " + e.getCause());
        }
    }

    @Override
    public String toString() {
        return "dispensing a Gumball";
    }
    
}
