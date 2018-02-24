package com.ingvar.just01.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    private String url;
    private String section;
    private String byline;
    private String title;
    @SerializedName("abstract")
    private String abstractText;
    @SerializedName("published_date")
    private String publishedDate;
    //@SerializedName("media")
    private List<MediaList> mediaList;

    public News() {
    }

    public News(String url, String section, String byline, String title, String abstractText, String publishedDate, List<MediaList> mediaList) {
        this.url = url;
        this.section = section;
        this.byline = byline;
        this.title = title;
        this.abstractText = abstractText;
        this.publishedDate = publishedDate;
        this.mediaList = mediaList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<MediaList> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<MediaList> mediaList) {
        this.mediaList = mediaList;
    }

}
