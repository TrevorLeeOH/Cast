package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class JdbcIssueDao implements IssueDao {

    private final double FIRST_CHOICE_MULTIPLIER = 1.0;

    private final JdbcTemplate jdbcTemplate;
    private final TagDao tagDao;
    private final VoteDao voteDao;
    private final UserDao userDao;

    public JdbcIssueDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        tagDao = new JdbcTagDao(jdbcTemplate);
        voteDao = new JdbcVoteDao(jdbcTemplate);
        this.userDao = userDao;
    }

    @Override
    public List<IssueOverviewDTO> getAllIssues(Principal principal) {
        List<IssueOverviewDTO> allIssues = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM issues;");
        while (results.next()) {
            allIssues.add(mapRowToIssueOverviewDTO(results, principal));
        }
        return allIssues;
    }

    @Override
    public List<IssueOverviewDTO> getIssuesByUser(int userId) {
        List<IssueOverviewDTO> issuesByUser = new ArrayList<>();
        String sql = "SELECT * FROM issues WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            IssueOverviewDTO issue = mapRowToIssueOverviewDTO(results, null);
            issuesByUser.add(issue);
        }
        return issuesByUser;
    }

    @Override
    public List<IssueOverviewDTO> getIssuesByTag(int tagId) {
        List<IssueOverviewDTO> issuesByTag = new ArrayList<>();
        String sql = "SELECT * FROM issues JOIN tags_issues AT issue_id WHERE tag_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tagId);
        while (results.next()) {
            IssueOverviewDTO issue = mapRowToIssueOverviewDTO(results, null);
            issuesByTag.add(issue);
        }
        return issuesByTag;
    }

    @Override
    public IssueDetailsDTO getIssueByIssueId(int issueId, Principal principal) {
        IssueDetailsDTO issue = null;
        String sql = "SELECT * FROM issues WHERE issue_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, issueId);
        if (results.next()) {
            issue = mapRowToIssueDetailsDTO(results, principal);
        }
        return issue;
    }



    @Override
    public void createIssue(IssueUpdateDTO issue) {
        String sql = "INSERT INTO issues (issue_name, description, user_id, expiration_date, option_a, option_b, option_c, option_d, option_e, option_f, " +
                "option_g, option_h)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING issue_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, issue.getName(), issue.getDescription(), issue.getUserId(), issue.getExpiration(), issue.getOptionA(), issue.getOptionB(),
                issue.getOptionC(), issue.getOptionD(), issue.getOptionE(), issue.getOptionF(), issue.getOptionG(), issue.getOptionH());
        tagDao.updateTagsForIssue(newId, issue.getTags());
    }




    @Override
    public void deleteIssueByName(String name) {
        String sql = "DELETE FROM issues WHERE name = ?;";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public void deleteIssueById(int issueId) {
        tagDao.deleteTagsForIssue(issueId);
        voteDao.deleteVotesForIssue(issueId);
        String sql = "DELETE FROM issues WHERE issue_id = ?";
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
    public void updateIssueById(IssueUpdateDTO updatedIssue) {
        String sql = "UPDATE issues SET issue_name = ?, description = ?, expiration_date = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, option_e = ?, " +
                "option_f = ?, option_g = ?, option_h = ? WHERE issue_id = ?;";
        jdbcTemplate.update(sql, updatedIssue.getName(), updatedIssue.getDescription(),updatedIssue.getExpiration(), updatedIssue.getOptionA(), updatedIssue.getOptionB(), updatedIssue.getOptionC(), updatedIssue.getOptionD(),
                updatedIssue.getOptionE(), updatedIssue.getOptionF(), updatedIssue.getOptionG(), updatedIssue.getOptionH(), updatedIssue.getIssueId());
        tagDao.updateTagsForIssue(updatedIssue.getIssueId(), updatedIssue.getTags());
    }


    private IssueOverviewDTO mapRowToIssueOverviewDTO(SqlRowSet results, Principal principal) {
        IssueOverviewDTO issue = new IssueOverviewDTO();
        issue.setIssueId(results.getInt("issue_id"));
        issue.setName(results.getString("issue_name"));
        issue.setDescription(results.getString("description"));
        if (results.getDate("expiration_date") != null) {
            issue.setExpiration(results.getDate("expiration_date").toLocalDate());
        } else {
            issue.setExpiration(null);
        }
        issue.setAuthor(userDao.getUserById(results.getInt("user_id")));
        issue.setTagList(tagDao.getTagsForIssue(issue.getIssueId()));
        issue.setOptionList(mapOptions(results));
        if (principal != null) {
            issue.setUserVoted(voteDao.userVoted(userDao.findIdByUsername(principal.getName()), issue.getIssueId()));
        }

        return issue;
    }

    private IssueDetailsDTO mapRowToIssueDetailsDTO(SqlRowSet results, Principal principal) {
        IssueDetailsDTO issue = new IssueDetailsDTO();
        issue.setIssueId(results.getInt("issue_id"));
        issue.setName(results.getString("issue_name"));
        issue.setDescription(results.getString("description"));
        if (results.getDate("expiration_date") != null) {
            issue.setExpiration(results.getDate("expiration_date").toLocalDate());
        } else {
            issue.setExpiration(null);
        }
        issue.setAuthor(userDao.getUserById(results.getInt("user_id")));
        issue.setTagList(tagDao.getTagsForIssue(issue.getIssueId()));
        issue.setOptionList(mapOptions(results));
        issue.setResultsList(mapResults(issue.getIssueId()));
        if (principal != null) {
            issue.setUserVoted(voteDao.userVoted(userDao.findIdByUsername(principal.getName()), issue.getIssueId()));
        }

        return issue;
    }

    private List<String> mapOptions(SqlRowSet results) {
        List<String> options = new ArrayList<>();
        options.add(results.getString("option_a"));
        options.add(results.getString("option_b"));
        options.add(results.getString("option_c"));
        if (results.getString("option_d") != null) {
            options.add(results.getString("option_d"));
        }
        if (results.getString("option_e") != null) {
            options.add(results.getString("option_e"));
        }
        if (results.getString("option_f") != null) {
            options.add(results.getString("option_f"));
        }
        if (results.getString("option_g") != null) {
            options.add(results.getString("option_g"));
        }
        if (results.getString("option_h") != null) {
            options.add(results.getString("option_h"));
        }
        return options;
    }

    private List<Integer> mapResults(int issueId) {
        int allVotes = 0;
        int firstVotes = 0;
        int winner = 0;
        List<Vote> votesList = voteDao.getVotesByIssueId(issueId);
        if (votesList.size() == 0) {
            return new ArrayList<Integer>();
        }
        Integer[] pointsArray = new Integer[votesList.get(0).getPoints().size()];
        Arrays.fill(pointsArray, 0);
        for (Vote vote : votesList) {
            for (int i = 0; i < vote.getPoints().size(); i++) {
                allVotes ++;
                if (vote.getPoints().get(i) == 1) {
                    pointsArray[i] += (int) Math.round(((vote.getPoints().size() + 1) - vote.getPoints().get(i)) * FIRST_CHOICE_MULTIPLIER);
                firstVotes ++;
                } else {
                    pointsArray[i] += (vote.getPoints().size() + 1) - vote.getPoints().get(i);
                }
            }
            if (firstVotes > allVotes/2){
                winner ++;
            }
        }
        return Arrays.asList(pointsArray);
    }

   /* private Issue mapRowToIssue(SqlRowSet results) {
        Issue issue = new Issue();
        User user = new User();
        issue.setIssueId(results.getInt("issue_id"));
        issue.setName(results.getString("issue_name"));
        issue.setDescription(results.getString("description"));
        if (results.getDate("expiration_date") != null) {
            issue.setExpiration(results.getDate("expiration_date").toLocalDate());
        } else {
            issue.setExpiration(null);
        }
        issue.setTagList(tagDao.getTagsForIssue(issue.getIssueId()));
        user.setUsername(userDao.findUsernameById(user.getId()));

        List<String> options = new ArrayList<>();
        options.add(results.getString("option_a"));
        options.add(results.getString("option_b"));
        options.add(results.getString("option_c"));
        if (results.getString("option_d") != null) {
            options.add(results.getString("option_d"));
        }
        if (results.getString("option_e") != null) {
            options.add(results.getString("option_d"));
        }
        if (results.getString("option_f") != null) {
            options.add(results.getString("option_d"));
        }
        if (results.getString("option_g") != null) {
            options.add(results.getString("option_d"));
        }
        if (results.getString("option_h") != null) {
            options.add(results.getString("option_d"));
        }
        issue.setOptionList(options);

        return issue;
    }*/
}
