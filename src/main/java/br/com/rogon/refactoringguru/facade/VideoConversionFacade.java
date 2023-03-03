package br.com.rogon.refactoringguru.facade;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format){
        log.info("Conversion Strated.");

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);

        Codec destinationCodec = 
            format.equals("mp4") ? new MPEG4CompressionCodec() : new OggCompressionCode();

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermedialResult = BitrateReader.convert(buffer, destinationCodec);
        File result = new AudioMixer().fix(intermedialResult);
        
        log.info("Conversion completed.");
        
        return result;
    }
}
