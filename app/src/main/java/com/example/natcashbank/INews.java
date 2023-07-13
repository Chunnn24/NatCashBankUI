package com.example.natcashbank;

import java.util.List;

public class INews {
    private String Promotion;
    private List<ItemINews> iNewsList;

    public INews(String promotion, List<ItemINews> iNewsList) {
        Promotion = promotion;
        this.iNewsList = iNewsList;
    }

    public String getPromotion() {
        return Promotion;
    }

    public void setPromotion(String promotion) {
        Promotion = promotion;
    }

    public List<ItemINews> getiNewsList() {
        return iNewsList;
    }

    public void setiNewsList(List<ItemINews> iNewsList) {
        this.iNewsList = iNewsList;
    }
}
