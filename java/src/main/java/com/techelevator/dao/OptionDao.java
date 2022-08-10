package com.techelevator.dao;

import com.techelevator.model.Option;
import com.techelevator.model.Tag;

import java.util.List;

public interface OptionDao {

    List<Option> getOptionsForIssue(int issueId);

}
