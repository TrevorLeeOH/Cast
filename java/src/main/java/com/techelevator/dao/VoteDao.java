package com.techelevator.dao;

import java.util.Map;

public interface VoteDao {
    Map<String, Integer> getVotesByIssue(int issueId); ///?


}
