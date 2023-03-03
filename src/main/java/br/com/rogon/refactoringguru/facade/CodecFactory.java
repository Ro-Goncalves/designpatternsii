package br.com.rogon.refactoringguru.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodecFactory {
    public static Codec extract(VideoFile file){
        String type = file.getCodecType();
        if(type.equals("mp4")){
            log.info("Extracting mpg audio...");
            return new MPEG4CompressionCodec();
        } else {
            log.info("Extracting ogg audio...");
            return new OggCompressionCode();
        }
    }
}
