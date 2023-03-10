package br.com.rogon.refactoringguru.proxy;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib{
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy(ThirdPartyYouTubeLib youtubeService) {
        this.youtubeService = youtubeService;
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()){
            cachePopular = youtubeService.popularVideos();
        } else {
            log.info("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if( video == null){
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            log.info("Retrieved video {} from cache.", videoId);
        }
        return video;
    }

    public void reset(){
        cachePopular.clear();
        cacheAll.clear();
    }
    
}
