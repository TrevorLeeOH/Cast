package com.techelevator.dao;

import com.techelevator.model.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class JdbcIssueDao implements IssueDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcIssueDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public List<Issue> getAllIssues() {
        List<Issue> allIssues = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM issues;");
        while (results.next()) {
            allIssues.add(mapRowToIssue(results));
        }
        return allIssues;
    }

    @Override
    public List<Issue> getIssuesByUser(int userId) {
        List<Issue> issuesByUser = new ArrayList<>();
        String sql = "SELECT * FROM issues WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Issue issue = mapRowToIssue(results);
            issuesByUser.add(issue);
        }
        return issuesByUser;
    }

    @Override
    public List<Issue> getIssuesByTag(int tagId) {
        List<Issue> issuesByTag = new ArrayList<>();
        String sql = "SELECT * FROM issues JOIN tags_issues AT issue_id WHERE tag_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tagId);
        while (results.next()) {
            Issue issue = mapRowToIssue(results);
            issuesByTag.add(issue);
        }
        return null;
    }

    @Override
    public Issue getIssueByIssueId(int issueId) {
        Issue issue = null;
        String sql = "SELECT * FROM issues WHERE issue_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, issueId);
        if (results.next()) {
            issue = mapRowToIssue(results);
        }
        return issue;
    }



    @Override
    public Issue createIssue(Issue issue) {

        String sql = "INSERT INTO issues (issue_name, expiration_date, option_a, option_b, option_c, option_d, option_e, option_f, " +
                "option_g, option_h)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING issue_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, issue.getName(), issue.getExpiration(), issue.getOptionA(), issue.getOptionB(),
                issue.getOptionC(), issue.getOptionD(), issue.getOptionE(), issue.getOptionF(), issue.getOptionG(), issue.getOptionH());

        return getIssueByIssueId(newId);
    }




    @Override
    public Issue deleteIssueByName(String name) {
        return null;
    }

    @Override
    public Issue deleteIssueById(int issueId) {
        return null;
    }

    @Override
    public Issue updateIssueByName(String name) {
        return null;
    }

    @Override
    public Issue updateIssueById(String issueId) {
        return null;
    }

    private Issue mapRowToIssue(SqlRowSet results) {
        Issue issue = new Issue();
        issue.setIssueId(results.getInt("issue_id"));
        issue.setName(results.getString("name"));
        issue.setExpired(results.getDate("expiration_date"));
        issue.setOptionA(results.getString("option_a"));
        issue.setOptionB(results.getString("option_b"));
        issue.setOptionC(results.getString("option_c"));
        issue.setOptionD(results.getString("option_d"));
        issue.setOptionE(results.getString("option_e"));
        issue.setOptionF(results.getString("option_f"));
        issue.setOptionG(results.getString("option_g"));
        issue.setOptionH(results.getString("option_h"));


        return issue;
    }
}
