package com.techelevator.model;

public class Tag {
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

    public int getTagId(int tag_id) {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }


}
