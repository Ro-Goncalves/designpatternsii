package br.com.rogon.iluwatar.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Proxy que controla o acesso à {@link IvoryTower}
 */ 
@Slf4j
public class WizardTowerProxy implements WizardTower {

    private static final Integer NUM_WIZARDS_ALLOWED = 3;

    private Integer numWizards;

    private final WizardTower tower;

    public WizardTowerProxy(WizardTower tower){
        this.tower = tower;
        numWizards = 0;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards < NUM_WIZARDS_ALLOWED){
            tower.enter(wizard);
            numWizards++;
        } else {
            log.info("{} is not allowed to enter!", wizard);
        }
    }
    
}
