package com.techelevator.dao;

import com.techelevator.model.Issue;
import com.techelevator.model.Vote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    private List<Integer> mapRowToVote(SqlRowSet results) {
        Vote vote = new Vote();
        vote.setUserId(results.getInt("user_id"));
        vote.setIssueId(results.getInt("issue_id"));
        List<Integer> pointsList = new ArrayList<>();
        pointsList.add(results.getInt("option_a"));
        pointsList.add(results.getInt("option_b"));
        pointsList.add(results.getInt("option_c"));
        if (results.getInt("option_d") != -1) {
            pointsList.add(results.getInt("option_d"));
        }
        if (results.getInt("option_e") != -1) {
            pointsList.add(results.getInt("option_d"));
        }
        if (results.getInt("option_f") != -1) {
            pointsList.add(results.getInt("option_d"));
        }
        if (results.getInt("option_g") != -1) {
            pointsList.add(results.getInt("option_d"));
        }
        if (results.getInt("option_h") != -1) {
            pointsList.add(results.getInt("option_d"));
        }
        vote.setPoints(pointsList);
    }

}

