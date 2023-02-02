package br.com.rogon.bethrobson.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurkeyTestDrive {
    public static void main(String[] args) {
        MallarDuck duck = new MallarDuck();
        Turkey duckAdapter = new DuckAdapter(duck);

        for (int i = 0; i < 10; i++) {
            log.info("The DuckAdapter says...");
            duckAdapter.gobble();
            duckAdapter.fly();
        }
    }
}
