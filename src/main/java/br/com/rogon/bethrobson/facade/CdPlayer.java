package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CdPlayer {
    private String description;
    private Integer currentTrack;
    private Amplifier amplifier;
    private String title;

    public CdPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void eject(){
        this.title = null;
        log.info(description + " eject");
    }

    public void play(String title){
        this.title = title;
        this.currentTrack = 0;
        log.info(description + " playing " + title);
    }

    public void play(Integer track){
        if(this.title.isEmpty()){
            log.info(description + " can't play track " + currentTrack + ", no cd inserted");
        } else {
            this.currentTrack = track;
            log.info(description + " playing track " + currentTrack);
        }
    }

    public void stop(){
        currentTrack = 0;
        log.info(description + " stopped " + title);
    }

    public void pause(){
        log.info(description + " paused " + title);
    }

    @Override
    public String toString() {
        return "CdPlayer [description=" + description + "]";
    }
    
}
