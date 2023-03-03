package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Screen {
    private String description;

    public Screen(String description) {
        this.description = description;
    }

    public void up(){
        log.info(description + " going up");
    }

    public void down(){
        log.info(description + " goind down");
    }

    @Override
    public String toString() {
        return "Screen [description=" + description + "]";
    }
}
