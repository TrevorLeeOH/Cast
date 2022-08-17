package com.techelevator.dao;

import com.techelevator.model.Issue;
import com.techelevator.model.Vote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.rowset.JdbcRowSet;
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

    @Override
    public List<Vote> getVotesByIssueId(int issue_id) {
        List<Vote> votes = new ArrayList<>();
        String sql = "SELECT * FROM votes WHERE issue_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, issue_id);

        while (results.next()) {
            votes.add(mapRowToVote(results));
        }
        return votes;
    }

    @Override
    public boolean createVote(Vote vote) {
        String sql = "INSERT INTO votes (user_id, issue_id, option_a, option_b, option_c, option_d, option_e, option_f, option_g, option_h) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int optionA = vote.getPoints().get(0);
        int optionB = vote.getPoints().get(1);
        int optionC = vote.getPoints().get(2);

        int optionD = vote.getPoints().size() > 3 ? vote.getPoints().get(3) : -1;
        int optionE = vote.getPoints().size() > 4 ? vote.getPoints().get(4) : -1;
        int optionF = vote.getPoints().size() > 5 ? vote.getPoints().get(5) : -1;
        int optionG = vote.getPoints().size() > 6 ? vote.getPoints().get(6) : -1;
        int optionH = vote.getPoints().size() > 7 ? vote.getPoints().get(7) : -1;

        return jdbcTemplate.update(sql, vote.getUserId(), vote.getIssueId(), optionA, optionB, optionC, optionD, optionE, optionF, optionG, optionH) == 1;
    }

    @Override
    public boolean userVoted(int userId, int issueId) {
        String sql = "SELECT count(*) from votes WHERE user_id = ? AND issue_id = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, userId, issueId) > 0;
    }

    public void deleteVotesForIssue(int issueId) {
        String sql = "DELETE FROM votes WHERE issue_id = ?;";
        jdbcTemplate.update(sql, issueId);
    }

    private Vote mapRowToVote(SqlRowSet results) {
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
        return vote;
    }


}

