package com.example.studynshort;

import java.util.List;

public class SubjectModel {

    private List<String> nestedList;
    private String itemText, txtdesp, txturl;
    int image;

    private boolean isExpandable;

    public SubjectModel(List<String> nestedList, String itemText, String txtdesp, String txturl, int image) {
        this.nestedList = nestedList;
        this.itemText = itemText;
        this.txtdesp = txtdesp;
        this.txturl = txturl;
        this.image = image;
        isExpandable = false;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public String getTxtdesp() {
        return txtdesp;
    }

    public int getImage() {
        return image;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
