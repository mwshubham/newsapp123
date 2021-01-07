package com.example.newsapps.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
      @SerializedName("status")
      @Expose
      private String status;
      @SerializedName("totalResults")
      @Expose
      private int totalResults;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getAaticle() {
        return aaticle;
    }

    public void setAaticle(List<Articles> aaticle) {
        this.aaticle = aaticle;
    }

    @SerializedName("articles")
      @Expose
      private List<Articles> aaticle;

}
