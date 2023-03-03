package br.com.rogon.bethrobson.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        Amplifier amplifier = new Amplifier("Amplifier");
        Tuner tuner = new Tuner("AM/FM", amplifier);
        StreamingPlayer streamingPlayer = new StreamingPlayer("Streaming Player", amplifier);
        CdPlayer cdPlayer = new CdPlayer("CD Player", amplifier);
        Projector projector = new Projector("Projector", streamingPlayer);
        TheaterLights theaterLights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popcornPopper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater = 
            new HomeTheaterFacade(amplifier, tuner, streamingPlayer, 
                projector, theaterLights, screen, popcornPopper);

        log.info("Watching Movie");
        homeTheater.watchMovie("Raiders of the lost Ark");
        log.info("Ending Movie");
        homeTheater.endMovie();
        
    }
}
