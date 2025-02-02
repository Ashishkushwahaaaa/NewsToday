package com.ashish.newstoday;

import java.util.ArrayList;

public class NewsModal {
    private int totalResult;
    private String Status;
    private ArrayList<Articles> articles;

    NewsModal(int totalResult, String Status, ArrayList<Articles> articles){
        this.totalResult = totalResult;
        this.Status = Status;
        this.articles = articles;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }
}
