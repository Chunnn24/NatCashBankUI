package com.example.natcashbank;

public class ItemMenu {

    private int resourceId;
    private String text;
    public ItemMenu(int resourceId, String text) {
        this.resourceId = resourceId;
        this.text = text;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
