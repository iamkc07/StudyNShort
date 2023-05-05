package com.example.studynshort;

public class SubItem {
    private int subItemImage;
    private String subItemTitle;
    private String subItemDesc;
    private String subItemUrl;
    private boolean isExpandable;

    public SubItem(int subItemImage, String subItemTitle, String subItemDesc, String subItemUrl) {
        this.subItemImage = subItemImage;
        this.subItemTitle = subItemTitle;
        this.subItemDesc = subItemDesc;
        this.subItemUrl = subItemUrl;
        isExpandable = false;
    }


    public int getSubItemImage() {
        return subItemImage;
    }

    public void setSubItemImage(int subItemImage) {
        this.subItemImage = subItemImage;
    }

    public String getSubItemUrl() {
        return subItemUrl;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public String getSubItemTitle() {
        return subItemTitle;
    }

    public void setSubItemTitle(String subItemTitle) {
        this.subItemTitle = subItemTitle;
    }

    public String getSubItemDesc() {
        return subItemDesc;
    }

    public void setSubItemDesc(String subItemDesc) {
        this.subItemDesc = subItemDesc;
    }


}
