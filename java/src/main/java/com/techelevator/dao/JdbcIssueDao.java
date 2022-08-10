package com.techelevator.dao;

import com.techelevator.model.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcIssueDao implements IssueDao {

    private final JdbcTemplate jdbcTemplate;
    private final TagDao tagDao;

    public JdbcIssueDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        tagDao = new JdbcTagDao(jdbcTemplate);
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
        return issuesByTag;
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

        String sql = "INSERT INTO issues (issue_name, description, expiration_date, option_a, option_b, option_c, option_d, option_e, option_f, " +
                "option_g, option_h)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING issue_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, issue.getName(), issue.getDescription(), issue.getExpiration(), issue.getOptionA(), issue.getOptionB(),
                issue.getOptionC(), issue.getOptionD(), issue.getOptionE(), issue.getOptionF(), issue.getOptionG(), issue.getOptionH());

        return getIssueByIssueId(newId);
    }




    @Override
    public void deleteIssueByName(String name) {
        String sql = "DELETE FROM issues WHERE name = ?;";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public void deleteIssueById(int issueId) {
        String sql = "DELETE FROM issues WHERE issueId = ?";
        jdbcTemplate.update(sql, issueId);
    }

    @Override
    public void updateIssueByName(Issue updatedIssue) {
        String sql = "UPDATE issues SET expiration_date = ?, description = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, option_e = ?, " +
                "option_f = ?, option_g = ?, option_h = ? WHERE name = ?;";
        jdbcTemplate.update(sql, updatedIssue.getExpiration(), updatedIssue.getDescription(), updatedIssue.getOptionA(), updatedIssue.getOptionB(), updatedIssue.getOptionC(), updatedIssue.getOptionD(),
                updatedIssue.getOptionE(), updatedIssue.getOptionF(), updatedIssue.getOptionG(), updatedIssue.getOptionH());

    }

    @Override
    public void updateIssueById(Issue updatedIssue) {
        String sql = "UPDATE issues SET name = ?, description = ?, expiration_date = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, option_e = ?, " +
                "option_f = ?, option_g = ?, option_h = ? WHERE issue_id = ?;";
        jdbcTemplate.update(sql, updatedIssue.getName(), updatedIssue.getDescription(),updatedIssue.getExpiration(), updatedIssue.getOptionA(), updatedIssue.getOptionB(), updatedIssue.getOptionC(), updatedIssue.getOptionD(),
                updatedIssue.getOptionE(), updatedIssue.getOptionF(), updatedIssue.getOptionG(), updatedIssue.getOptionH());
    }

    private Issue mapRowToIssue(SqlRowSet results) {
        Issue issue = new Issue();
        issue.setIssueId(results.getInt("issue_id"));
        issue.setName(results.getString("issue_name"));
        issue.setDescription(results.getString("description"));
        if (results.getDate("expiration_date") != null) {
            issue.setExpiration(results.getDate("expiration_date").toLocalDate());
        } else {
            issue.setExpiration(null);
        }

        issue.setTagList(tagDao.getTagsForIssue(issue.getIssueId()));
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
