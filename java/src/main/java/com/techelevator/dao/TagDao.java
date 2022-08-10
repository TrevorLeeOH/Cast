package com.techelevator.dao;

import com.techelevator.model.Tag;

public interface TagDao {
    Tag createTag(String tagName);
    Tag updateTag(String tagName);
    Tag deleteTag(String tagName);


}
