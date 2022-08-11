package com.techelevator.dao;

import com.techelevator.model.Option;


import java.util.List;

public interface OptionDao {

    List<Option> getOptionsForIssue(int issueId);

}
