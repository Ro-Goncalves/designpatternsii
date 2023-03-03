package br.com.rogon.refactoringguru.facade;

public class App {
    public static void main(String[] args) {
        var converter = new VideoConversionFacade();
        converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
