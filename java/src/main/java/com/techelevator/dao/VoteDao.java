package com.techelevator.dao;


import com.techelevator.model.Vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface VoteDao {

    List<Vote> getVotesByIssueId(int issue_id);

    boolean createVote(Vote vote);

    public boolean userVoted(int userId, int issueId);

    void deleteVotesForIssue(int issueId);
}
