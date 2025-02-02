package com.ashish.newstoday;

public class Articles {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String contents;

    Articles(String title, String description, String url, String urlToImage, String contents){
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
