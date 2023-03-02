package br.com.rogon.iluwatar.facade;

import lombok.extern.slf4j.Slf4j;

/*
 * É um dos subsistemas de GoldMine
 */
@Slf4j
public class DwarvenTunnelDigger extends DwarvenMineWorker {

    @Override
    public void work() {
        log.info("{} creates another promising tunnel.", name());
    }

    @Override
    public String name() {
        return "Dwarven tunnel digger";
    }
    
}
