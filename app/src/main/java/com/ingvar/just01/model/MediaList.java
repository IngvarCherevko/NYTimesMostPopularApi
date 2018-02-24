package com.ingvar.just01.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaList {
    @SerializedName("media-metadata")
    private List<MediaMetadata> mediaMetadataList = null;

    public MediaList() {
    }

    public MediaList(List<MediaMetadata> mediaMetadataList) {
        this.mediaMetadataList = mediaMetadataList;
    }

    public List<MediaMetadata> getMediaMetadataList() {
        return mediaMetadataList;
    }

    public void setMediaMetadataList(List<MediaMetadata> mediaMetadataList) {
        this.mediaMetadataList = mediaMetadataList;
    }
}
