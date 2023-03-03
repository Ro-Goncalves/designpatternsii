package br.com.rogon.refactoringguru.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec){
        log.info("Reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec){
        log.info("Writing file...");
        return buffer;
    }
}
