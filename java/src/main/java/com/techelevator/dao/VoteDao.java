package com.techelevator.dao;


import com.techelevator.model.Vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface VoteDao {



    getVotesByUserId(int userId);

    List<Vote> updateResults();





}
