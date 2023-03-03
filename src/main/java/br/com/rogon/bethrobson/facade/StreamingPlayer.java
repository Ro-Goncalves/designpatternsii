package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamingPlayer {
    private String description;
    private Integer currentChapter;
    private Amplifier amplifier;
    private String movie;

    public StreamingPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void play(String movie){
        this.movie = movie;
        currentChapter = 0;
        log.info(description + " playing: " + movie);
    }

    public void play(Integer chapter){
        if (movie.isEmpty()){
            log.info(description + " can't play chapter " + chapter + ". no movie selected");
        } else {
            currentChapter = chapter;
            log.info(description + " playing chapter " + chapter + ", of " + movie);
        }
    }

    public void stop(){
        currentChapter = 0;
        log.info(description + " stopped " + movie);
    }

    public void pause(){
        log.info(description + " paused " + movie);
    }

    public void setTwoChannelAudio(){
        log.info(description + " set two channel audio");
    }

    public void setSurroundAudio(){
        log.info(description + " set surround audio");
    }

    @Override
    public String toString() {
        return "StreamingPlayer [description=" + description + "]";
    }

}
