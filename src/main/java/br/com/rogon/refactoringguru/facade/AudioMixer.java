package br.com.rogon.refactoringguru.facade;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AudioMixer {
    public File fix(VideoFile result){
        log.info("Fixing audio...");
        return new File("tmp");
    }
}
