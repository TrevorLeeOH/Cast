package com.techelevator.dao;

import com.techelevator.model.Issue;

import java.util.List;

public interface IssueDao {
    List<Issue> getAllIssues();
    List<Issue> getIssuesByUser(int userId);
    List<Issue> getIssuesByTag(int tagId);

    Issue getIssueByIssueId(int issueId);

    Issue createIssue(String name);

    Issue deleteIssueByName(String name);
    Issue deleteIssueById(int issueId);

    Issue updateIssueByName(String name);
    Issue updateIssueById(String issueId);



}
