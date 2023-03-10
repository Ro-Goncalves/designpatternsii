package br.com.rogon.refactoringguru.proxy;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YouYubeDownloader {
    private ThirdPartyYouTubeLib api;

    public YouYubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId){
        Video video = api.getVideo(videoId);
        log.info("-------------------------------");
        log.info("Video page");
        log.info(video.toString());
        log.info("-------------------------------");
    }

    public void renderPopularVideos(){
        HashMap<String, Video> list = api.popularVideos();
        log.info("-------------------------------");
        log.info("Most popular videos on YouTube");

        list.forEach((videoId, video) -> {
            log.info(video.toString());
        });
        
        log.info("-------------------------------");
    }
    
}
