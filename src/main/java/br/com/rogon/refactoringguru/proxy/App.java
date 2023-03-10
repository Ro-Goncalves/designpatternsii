package br.com.rogon.refactoringguru.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        YouYubeDownloader naiveDownloader = 
            new YouYubeDownloader(new ThirdPartyYouTubeClass());

        YouYubeDownloader smartDownloader = 
            new YouYubeDownloader(new YouTubeCacheProxy(new ThirdPartyYouTubeClass()));

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        log.info("Time saved by caching proxy: {} ms", naive - smart);

    }

    private static long test(YouYubeDownloader downloader){
        long startTime = System.currentTimeMillis();

        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");

        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        log.info("Time elapsed: {} ms", estimatedTime);

        return estimatedTime;
    }       
}
