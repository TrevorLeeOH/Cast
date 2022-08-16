package com.techelevator.dao;

import com.techelevator.model.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTagDao implements TagDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> getAllTags() {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT * FROM tags";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            tags.add(mapRowToTag(results));
        }
        return tags;
    }

    @Override
    public Tag createTag(String tagName) {
        String sql = "INSERT INTO tags (tag_name) " +
                "VALUES (?) RETURNING tag_id";
        int tagId = jdbcTemplate.queryForObject(sql, Integer.class, tagName);
        return getTag(tagId);
    }
    
    @Override
    public Tag assignTag(int issueId) {
        String sql = "INSERT INTO tag_issues (issueId) " +
                "VALUES (?) RETURNING tag_id;";
        int tagId = jdbcTemplate.queryForObject(sql, Integer.class, issueId);
        return getTag(tagId);
    }

    public Tag getTag(int tagId) {
        Tag tag = null;
        String sql = "SELECT * FROM tags WHERE tag_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tagId);
        if (results.next()){
            tag = mapRowToTag(results);

        }
        return tag;
    }


    @Override
    public List<Tag> getTagsForIssue(int issueId) {
        List<Tag> tag = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM tags JOIN tags_issue USING(tag_id) WHERE issue_id = ?;", issueId);
        while (results.next()){
            tag.add(mapRowToTag(results));
        }
        return tag;
    }

    @Override
    public void updateTags(Tag updatedTag) {
        String sql = "UPDATE tags SET tag_id = ?, set tag_name = ? " +
                "JOIN tags_issue USING tag_id WHERE issue_id = ?; ";
        jdbcTemplate.update(sql, updatedTag.getTagId(), updatedTag.getTagName());
    }


    //Trevor: I added the following 4 methods to update tags for issue
    @Override
    public void updateTagsForIssue(int issueId, Tag[] tags) {
        deleteTagsForIssue(issueId);
        for (int i = 0; i < tags.length; i++) {
            if (!tagExists(tags[i].getTagName())) {
                tags[i] = createTag(tags[i].getTagName());
            }
            addTagToIssue(tags[i].getTagId(), issueId);
        }
    }

    @Override
    public void deleteTagsForIssue(int issueId) {
        String deleteSql = "DELETE FROM tags_issue WHERE issue_id = ?";
        jdbcTemplate.update(deleteSql, issueId);
    }

    @Override
    public boolean tagExists(String tagName) {
        String sql = "SELECT count(tag_id) from tags WHERE tag_name = ?;";
        return jdbcTemplate.queryForObject(sql, int.class, tagName) > 0;
    }

    @Override
    public void addTagToIssue(int tagId, int issueId) {
        String sql = "INSERT INTO tags_issue (tag_id, issue_id) VALUES (?, ?);";
        jdbcTemplate.update(sql, tagId, issueId);
    }



    private Tag mapRowToTag(SqlRowSet results) {
        Tag tag = new Tag();
        tag.setTagId(results.getInt("tag_id"));
        tag.setTagName(results.getString("tag_name"));
        return tag;

    }
}
