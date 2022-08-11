package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Vote {
    private int issueId;
    private int userId;
    private List<Integer> points = new ArrayList<>();

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }
}




