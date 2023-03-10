package br.com.rogon.bethrobson.proxy;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        int count = 0;

        List<String> game = List.of("My Machine", "50");

        if (game.size() < 2){
            log.info("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(game.get(1));
        } catch (Exception e) {
            log.error(e.getMessage() + " - " + e.getCause());
        }

        GumballMachine gumballMachine = new GumballMachine(game.get(0), count);
        GumballMonitor monito = new GumballMonitor(gumballMachine);

        log.info(gumballMachine.toString());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        log.info(gumballMachine.toString());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        log.info(gumballMachine.toString());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        log.info(gumballMachine.toString());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        log.info(gumballMachine.toString());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        log.info(gumballMachine.toString());

        monito.report();

    }
}
