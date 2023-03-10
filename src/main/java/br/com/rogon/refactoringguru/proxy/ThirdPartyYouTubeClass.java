package br.com.rogon.refactoringguru.proxy;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    private int random(int min, int max){
        return min + (int) (Math.random() * ((max - min) +1));
    }

    private void experienceNetworkLatency(){
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage() + " - " + e.getCause());
            }
        }
    }

    private void connectToServer(String server){
        log.info("Connection to {} ...", server);
        experienceNetworkLatency();
        log.info("Connected!");
    }

    private HashMap<String, Video> getRandomVideos(){
        log.info("Downloading populars...");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<>();
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        log.info("Done!");
        return hmap;
    }

    private Video getSomeVideo(String videoId){
        log.info("Downloading video...");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        log.info("Done!");
        return video;
    }
    
}
