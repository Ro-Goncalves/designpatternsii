package br.com.rogon.iluwatar.facade;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/*
 * É um dos subsistemas de GoldMine
 */
@Slf4j
public abstract class DwarvenMineWorker {

    public void goToSleep(){
        log.info("{} goes to sleep.", name());
    }

    public void wakeUp(){
        log.info("{} wakes up.", name());
    }

    public void goHome(){
        log.info("{} goes home.", name());
    }

    public void goToMine(){
        log.info("{} goes to the mine.", name());
    }

    private void action(Action action){
        switch (action) {
            case GO_TO_SLEEP:
                goToSleep();
                break;
            case WAKE_UP:
                wakeUp();
                break;
            case GO_HOME:
                goHome();
                break;
            case GO_TO_MINE:
                goToMine();
                break;
            case WORK:
                work();
                break;
            default:
                log.info("Undefined action");
                break;
        }
    }

    public void action(Action... actions){
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK
    }
    
}
