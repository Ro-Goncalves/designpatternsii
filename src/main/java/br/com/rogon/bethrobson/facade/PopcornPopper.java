package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PopcornPopper {
    private String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void pop(){
        log.info(description + " popping popcorn!");
    }

    @Override
    public String toString() {
        return "PopcornPopper [description=" + description + "]";
    }

    
}
