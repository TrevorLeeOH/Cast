package com.techelevator.dao;

import com.techelevator.model.Issue;

import java.util.List;

public interface IssueDao {
    List<Issue> getAllIssues();
    List<Issue> getIssuesByUser(int userId);
    List<Issue> getIssuesByTag(int tagId);

    Issue getIssueByIssueId(int issueId);

    Issue createIssue(Issue issue);

    void deleteIssueByName(String name);
    void deleteIssueById(int issueId);

    void updateIssueByName(Issue updatedIssue);
    void updateIssueById(Issue updatedIssue);



}
