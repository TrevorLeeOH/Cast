package com.techelevator.dao;

import com.techelevator.model.Vote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
    public class JdbcVoteDao implements VoteDao {
        private final JdbcTemplate jdbcTemplate;

        public JdbcVoteDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


    public Map<String, Integer> getVotesByIssueId = new HashMap<>();


    @Override
    public List<Vote> getVotesByUserId(int userId) {
        return null;
    }

    @Override
    public List<Vote> updateResults() {
        return null;
    }


   // someone votes - take list votes fore each option
    // assign points in that issue
    //update results
}

