package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Amplifier {
    private String description;
    private Tuner tuner;
    private StreamingPlayer streamingPlayer;

    public Amplifier(String description) {
        this.description = description;
    }

    public void on(){
        log.info(description + " on");
    }

    public void off(){
        log.info(description + " off");
    }

    public void setStereoSound(){
        log.info(description + " stereo mode on");
    }

    public void setSurroundSound(){
        log.info(description + " surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolume(int level){
        log.info(description + " setting volume to " + level);
    }

    public void setTuner(Tuner tuner) {
        log.info(description + " setting tuner to " + tuner);
        this.tuner = tuner;
    }

    public void setStreamingPlayer(StreamingPlayer streamingPlayer) {
        log.info(description + " setting StreamingPlayer to " + streamingPlayer);
        this.streamingPlayer = streamingPlayer;
    }

    @Override
    public String toString() {
        return "Amplifier [description=" + description + "]";
    }

}
