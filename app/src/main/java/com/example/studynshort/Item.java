package com.example.studynshort;

import java.util.List;

public class Item {
    private String itemTitle;
    private List<SubItem> subItemList;

    private boolean isExpandable;

    public Item(String itemTitle, List<SubItem> subItemList) {
        this.itemTitle = itemTitle;
        this.subItemList = subItemList;
        isExpandable = false;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public List<SubItem> getSubItemList() {
        return subItemList;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setSubItemList(List<SubItem> subItemList) {
        this.subItemList = subItemList;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
