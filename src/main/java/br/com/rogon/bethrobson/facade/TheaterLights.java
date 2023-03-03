package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TheaterLights {
    private String description;

    public TheaterLights(String description) {
        this.description = description;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void dim(Integer level){
        log.info(description + " dimming to " + level + "%");
    }

    @Override
    public String toString() {
        return "TheaterLights [description=" + description + "]";
    }
}
