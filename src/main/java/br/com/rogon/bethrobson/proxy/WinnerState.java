package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WinnerState implements State {
    private static final long serialVersionUID = 2L;
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("Please wait, we're already giving you a Gumball");
    }

    @Override
    public void ejectQuarter() {
        log.info("Please wait, we're already giving you a Gumball");
    }

    @Override
    public void turnCrank() {
        log.info("Turning again doesn't get you another Gumball!");
    }

    @Override
    public void dispense() {
        log.info("YOU'RE A WINNER! You get two Gumballs fo your quarter");
        try {
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() == 0){
                gumballMachine.setState(gumballMachine.getSoldOutState());
            } else {
                gumballMachine.releaseBall();
                if(gumballMachine.getCount() > 0){
                    gumballMachine.setState(gumballMachine.getNoQuarterState());
                } else {                   
                    log.info("Oops, out of Gumballs!");
                    gumballMachine.setState(gumballMachine.getSoldOutState());                      
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage() + " - " + e.getCause());
        }
    }

    @Override
    public String toString(){
        return "despesing two gumballs for your quarter, because YOU'ARE A WINNER!";
    }
    
}
