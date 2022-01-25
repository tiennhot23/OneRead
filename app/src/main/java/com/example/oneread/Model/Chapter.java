package com.example.oneread.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Chapter implements Serializable {

    @SerializedName("chapter_endpoint")
    @Expose
    private String chapterEndpoint;
    @SerializedName("book_endpoint")
    @Expose
    private String bookEndpoint;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("images")
    @Expose
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getChapterEndpoint() {
        return chapterEndpoint;
    }

    public void setChapterEndpoint(String chapterEndpoint) {
        this.chapterEndpoint = chapterEndpoint;
    }

    public String getBookEndpoint() {
        return bookEndpoint;
    }

    public void setBookEndpoint(String bookEndpoint) {
        this.bookEndpoint = bookEndpoint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}