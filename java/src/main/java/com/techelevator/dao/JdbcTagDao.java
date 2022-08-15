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
    public Tag createTag(String tagName) {
        String sql = "INSERT INTO tags (tag_name)" +
                "VALUES (?) RETURNING tag_id";
        int tagId = jdbcTemplate.queryForObject(sql, Integer.class, tagName);
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
        jdbcTemplate.update(sql, updatedTag.getTagId, updatedTag.getTagName);
    }

    private Tag mapRowToTag(SqlRowSet results) {
        Tag tag = new Tag();
        tag.getTagId(results.getInt("tag_id"));
        tag.getTagName(results.getString("tag_name"));
        return tag;

    }
}
