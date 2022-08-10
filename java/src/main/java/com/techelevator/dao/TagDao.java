package com.techelevator.dao;

import com.techelevator.model.Tag;

import java.util.List;

public interface TagDao {
    Tag createTag(String tagName);
    Tag updateTag(String tagName);
    Tag deleteTag(String tagName);

    List<Tag> getTagsForIssue(int issueId);


}
