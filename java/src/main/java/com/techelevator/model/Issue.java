package com.techelevator.model;

import java.util.Date;

public class Issue {

    private int issueId;
    private String name;
    private Date expiration;


    public Issue(String name) {
        this.name = name;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
