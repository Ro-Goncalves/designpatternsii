package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tuner {
    private String description;
    private Amplifier amplifier;
    private Double frequency;

    public Tuner(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void setFrequency(Double frequency){
        log.info(description + " setting frequency to " + frequency);
        this.frequency = frequency;
    }

    public void setAm(){
        log.info(description + " setting AM mode");
    }

    public void setFm(){
        log.info(description + " setting FM mode");
    }

    @Override
    public String toString() {
        return "Tuner [description=" + description + "]";
    }
   
}
