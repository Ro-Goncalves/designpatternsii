package br.com.rogon.iluwatar.facade;

import lombok.extern.slf4j.Slf4j;

/*
 * É um dos subsistemas de GoldMine
 */
@Slf4j
public class DwarvenGoldDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        log.info("{} digs for gold.", name());
    }

    @Override
    public String name() {
        return "Dwarf gold digger";
    }
    
}
