package com.techelevator.controller;

import com.techelevator.dao.IssueDao;
import com.techelevator.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.techelevator.security.jwt.TokenProvider;

import java.util.List;

//@PreAuthorize("isAuthenticated()") //we don't have to pass in token by using this
@RestController
@CrossOrigin
public class IssueController {

//    @Autowired  //this brings in the IssueDao as a new object for us to use automatically
    private IssueDao issueDao;
//    private List<Issue> issueList;


    public IssueController(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    @GetMapping(path = "/issues")
    public List<Issue> getAllIssues(){
        return issueDao.getAllIssues();
    };

    @GetMapping(path = "/issues/{user_id}")
    public List<Issue> getIssuesByUser(@PathVariable int user_id){
        return issueDao.getIssuesByUser(user_id);
    };

    @GetMapping(path = "/issues/{tag_id}")
    public List<Issue> getIssuesByTag(@PathVariable int tag_id){
        return issueDao.getIssuesByTag(tag_id);
    };

    @GetMapping(path = "/issues/{issue_id}")
    public Issue getIssueByIssueId(@PathVariable int issue_id){
        return issueDao.getIssueByIssueId(issue_id);
    };

    @PostMapping(path = "/issues")
    public void createIssue(Issue issue) {
        issueDao.createIssue(issue);
    };

    @PutMapping(path = "/issues/{issue_name}")
    public void updateIssueByName(Issue updatedIssue) {
        issueDao.updateIssueByName(updatedIssue);
    };

    @PutMapping(path = "/issues/{issue_name}")
    public void updateIssueById(Issue updatedIssue) { //should this be a string or int? may need to change model/jdbcdao
        issueDao.updateIssueById(updatedIssue);
    };

    @RequestMapping(path = "/issues", method = RequestMethod.DELETE)
    public void deleteIssueByName(String name) {
        issueDao.deleteIssueByName(name);
    };

    @RequestMapping(path = "/issues", method = RequestMethod.DELETE)
    public void deleteIssueById(int issueId) {
        issueDao.deleteIssueById(issueId);
    };




    //request mapping with endpoints for CRUD
}
