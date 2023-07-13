package com.example.natcashbank;

import android.widget.ImageButton;
import android.widget.TextView;

public class Feature {
    private  int imgFeature;
    private String txtFeature;

    public Feature(int imgFeature, String txtFeature) {
        this.imgFeature = imgFeature;
        this.txtFeature = txtFeature;
    }

    public int getImgFeature() {
        return imgFeature;
    }

    public void setImgFeature(int imgFeature) {
        this.imgFeature = imgFeature;
    }

    public String getTxtFeature() {
        return txtFeature;
    }

    public void setTxtFeature(String txtFeature) {
        this.txtFeature = txtFeature;
    }
}
