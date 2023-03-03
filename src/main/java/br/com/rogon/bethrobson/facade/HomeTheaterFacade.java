package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeTheaterFacade {
    private Amplifier amplifier;
    private Tuner tuner;
    private StreamingPlayer streamingPlayer;
    private CdPlayer cdPlayer;
    private Projector projector;
    private TheaterLights theaterLights;
    private Screen screen;
    private PopcornPopper popcornPopper;

    public HomeTheaterFacade(Amplifier amplifier, 
                            Tuner tuner, 
                            StreamingPlayer streamingPlayer, 
                            Projector projector,
                            TheaterLights theaterLights, 
                            Screen screen, 
                            PopcornPopper popcornPopper) {

        this.amplifier = amplifier;
        this.tuner = tuner;
        this.streamingPlayer = streamingPlayer;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popcornPopper = popcornPopper;
    }

    public void watchMovie(String movie){
        log.info("Get ready to watch a movie...");

        popcornPopper.on();
        popcornPopper.pop();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setStreamingPlayer(streamingPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        streamingPlayer.on();
        streamingPlayer.play(movie);
    }

    public void endMovie(){
        log.info("Shutting movie theater down...");

        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amplifier.off();
        streamingPlayer.stop();
        streamingPlayer.off();
    }

    public void listenToRadio(Double frequency){
        log.info("Tuning in the airwaves...");

        tuner.on();
        tuner.setFrequency(frequency);
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setTuner(tuner);
    }

    public void endRadio(){
        log.info("Shutting down the tuner...");

        tuner.off();
        amplifier.off();
    }
    
}
