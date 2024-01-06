package com.example.ASP_News;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private String totalResults;
    private ArrayList<jsonClass> articles;

    public mainNews(String status, String totalResults, ArrayList<jsonClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<jsonClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<jsonClass> articles) {
        this.articles = articles;
    }
}
