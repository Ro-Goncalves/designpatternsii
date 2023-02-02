package br.com.rogon.bethrobson.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DuckTestDrive {
    public static void main(String[] args) {
        Duck duck = new MallarDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        Drone drone = new SuperDrone();
        Duck droneAdapter = new DroneAdapter(drone);

        log.info("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        log.info("The Duck says...");
        duck.quack();
        duck.fly();

        log.info("The TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();

        log.info("The DroneAdapter says...");
        droneAdapter.quack();
        droneAdapter.fly();
        
    }
}
