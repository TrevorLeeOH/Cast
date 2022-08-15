package com.techelevator.model;

public class Tag {
    public Object[] getTagId;
    public int[] getTagName;
    String tagName;
    int tagId;

    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName(String tagName) {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagId(int tagId) {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }


}
