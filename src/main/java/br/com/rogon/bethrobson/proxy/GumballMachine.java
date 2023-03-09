package br.com.rogon.bethrobson.proxy;

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
        noQuarterState = new 
    }

    public void releaseBall() {
    }

    public int getCount() {
        return 0;
    }

    public Object getSoldOutState() {
        return null;
    }

    public void setState(Object soldOutState) {
    }

    public Object getNoQuarterState() {
        return null;
    }

    public Object getLocation() {
        return null;
    }

    public Object getState() {
        return null;
    }

    public Object getWinnerState() {
        return null;
    }

    public Object getSoldState() {
        return null;
    }

    public Object getHasQuarterState() {
        return null;
    }

}
