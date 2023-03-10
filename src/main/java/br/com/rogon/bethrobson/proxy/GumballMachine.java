package br.com.rogon.bethrobson.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GumballMachine {
    private State soldOutState;
    private State noQuarterState;
    private State haQuarterState;
    private State soldState;
    private State winnerState;

    State state = soldOutState;
    int count = 0;
    String location;

    public GumballMachine(String location, int count){
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        haQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = count;
        if(count > 0){
            state = noQuarterState;
        }
        this.location = location;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        log.info("A Gumball comes rolling out the slot...");
        if(count != 0){
            count -= 1;
        }
    }

    public int getCount() {
        return count;
    }

    public void refill(int count){
        this.count = count;
        state = noQuarterState;
    }

    public State getState() {
        return state;
    }

    public String getLocation() {
        return location;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return haQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }    

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\njava-enable Standing Gumball Model #2023");
        result.append("\nInventory: " + count + " Gumball");
        if(count != 1){
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }

    

}
