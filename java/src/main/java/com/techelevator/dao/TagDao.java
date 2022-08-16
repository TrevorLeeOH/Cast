package com.techelevator.dao;

import com.techelevator.model.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getAllTags();

    Tag createTag(String tagName);

    List<Tag> getTagsForIssue(int issueId);

    void updateTags(Tag updatedTag);

    Tag assignTag(int issueId);

    public void updateTagsForIssue(int issue_id, Tag[] tags);
    public void deleteTagsForIssue(int issueId);
    public boolean tagExists(String tagName);
    public void addTagToIssue(int tagId, int issueId);


}
