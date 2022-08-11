package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Vote {
    private int voteA;
    private int voteB;
    private int voteC;
    private int voteD;
    private int voteE;
    private int voteF;
    private int voteG;
    private int voteH;
    private String[] rankedOptions;
    private List<Vote> results = new ArrayList<>();
    private int points;
    private boolean isWinner;
    private int vote;
    private int issueId;

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

    private int userId;

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    private String option;

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public int getVoteA() {
        return voteA;
    }

    public void setVoteA(int voteA) {
        this.voteA = voteA;
    }

    public int getVoteB() {
        return voteB;
    }

    public void setVoteB(int voteB) {
        this.voteB = voteB;
    }

    public int getVoteC() {
        return voteC;
    }

    public void setVoteC(int voteC) {
        this.voteC = voteC;
    }

    public int getVoteD() {
        return voteD;
    }

    public void setVoteD(int voteD) {
        this.voteD = voteD;
    }

    public int getVoteE() {
        return voteE;
    }

    public void setVoteE(int voteE) {
        this.voteE = voteE;
    }

    public int getVoteF() {
        return voteF;
    }

    public void setVoteF(int voteF) {
        this.voteF = voteF;
    }

    public int getVoteG() {
        return voteG;
    }

    public void setVoteG(int voteG) {
        this.voteG = voteG;
    }

    public int getVoteH() {
        return voteH;
    }

    public void setVoteH(int voteH) {
        this.voteH = voteH;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Vote> getResults() {
        return results;
    }

    public void setResults(List<Vote> results) {
        this.results = results;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
















}




