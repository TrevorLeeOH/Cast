package com.techelevator.dao;

import com.techelevator.model.Vote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
    public class JdbcVoteDao implements VoteDao {
        private final JdbcTemplate jdbcTemplate;

        public JdbcVoteDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    @Override
    public List<Vote> getVotesByIssueId(int issueId) {

        return null;
    }

    @Override
    public List<Vote> getVotesByUserId(int userId) {
        return null;
    }

    @Override
    public List<Vote> updateResults() {
        return null;
    }
}

