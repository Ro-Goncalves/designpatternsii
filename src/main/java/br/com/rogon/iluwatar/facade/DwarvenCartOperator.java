package br.com.rogon.iluwatar.facade;

import lombok.extern.slf4j.Slf4j;

/*
 * É um dos subsistemas de GoldMine
 */
@Slf4j
public class DwarvenCartOperator  extends DwarvenMineWorker{@Override

    public void work() {        
        log.info("{} moves gold chunks out of the mine.", name());
    }

    @Override
    public String name() {
        return "Dwarf cart operator";
    }
    
}
