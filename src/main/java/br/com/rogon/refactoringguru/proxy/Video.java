package br.com.rogon.refactoringguru.proxy;

import lombok.Getter;

@Getter
public class Video {
    private String id;
    private String title;
    private String data;

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }

    @Override
    public String toString() {
        return "Video [id=" + id + ", title=" + title + ", data=" + data + "]";
    }

}
