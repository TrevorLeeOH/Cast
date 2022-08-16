package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IssueDetailsDTO {

    private int issueId;
    private User author;
    private String name;
    private String description;
    private LocalDate expiration;
    //private boolean isExpired;
    private List<Tag> tagList= new ArrayList<>();
    private List<String> optionList = new ArrayList<>();
    private List<Integer> resultsList = new ArrayList<>();
    private boolean userVoted;

    public boolean isUserVoted() {
        return userVoted;
    }

    public void setUserVoted(boolean userVoted) {
        this.userVoted = userVoted;
    }

    public List<Integer> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Integer> resultsList) {
        this.resultsList = resultsList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<String> optionList) {
        this.optionList = optionList;
    }
}
