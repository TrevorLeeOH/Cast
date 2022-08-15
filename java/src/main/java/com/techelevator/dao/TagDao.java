package com.techelevator.dao;

import com.techelevator.model.Tag;

import java.util.List;

public interface TagDao {
    Tag createTag(String tagName);
    List<Tag> getTagsForIssue(int issueId);
    List<Tag> updateTags(Tag updatedTag);

}
