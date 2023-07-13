package com.example.natcashbank;

public class ItemINews {
    private int imgINew;
    private String txtINew;



    public ItemINews(int imgINew, String txtINew) {
        this.imgINew = imgINew;
        this.txtINew = txtINew;
    }


    public int getImgINew() {
        return imgINew;
    }

    public void setImgINew(int imgINew) {
        this.imgINew = imgINew;
    }

    public String getTxtINew() {
        return txtINew;
    }

    public void setTxtINew(String txtINew) {
        this.txtINew = txtINew;
    }
}
