package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Projector {
    private String description;
    private StreamingPlayer streamingPlayer;

    public Projector(String description, StreamingPlayer streamingPlayer) {
        this.description = description;
        this.streamingPlayer = streamingPlayer;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void wideScreenMode(){
        log.info(description + " in widescreen mode (19x9 aspect ratio)");
    }

    public void tvMode(){
        log.info(description + " in tv mode (4x3 aspect ratio)");
    }

    @Override
    public String toString() {
        return "Projector [description=" + description + "]";
    }
}
