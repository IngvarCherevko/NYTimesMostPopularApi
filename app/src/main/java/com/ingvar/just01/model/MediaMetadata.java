package com.ingvar.just01.model;


public class MediaMetadata {

    private String url;
    private String format;
    private int height;
    private int width;

    public MediaMetadata() {
    }

    public MediaMetadata(String url, String format, int height, int width) {
        this.url = url;
        this.format = format;

        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
