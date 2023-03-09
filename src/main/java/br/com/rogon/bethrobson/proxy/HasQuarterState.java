package br.com.rogon.bethrobson.proxy;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HasQuarterState implements State {
    private static final long serialVersionUID = 2l;
    
    private Random randomWinner = new Random(System.currentTimeMillis());
    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        log.info("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        log.info("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        log.info("You turned...");
        int winner = randomWinner.nextInt(10);
        if(winner == 0){
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        log.info("No Gumball dispensed");
    }

    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
    
}
