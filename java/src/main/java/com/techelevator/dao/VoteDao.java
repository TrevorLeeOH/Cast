package com.techelevator.dao;


import com.techelevator.model.Vote;

import java.util.List;

public interface VoteDao {

    List<Vote> getVotesByIssueId(int issueId);

    List<Vote> getVotesByUserId(int userId);

    List<Vote> updateResults();



}
