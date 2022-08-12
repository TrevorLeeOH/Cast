package com.techelevator.controller;

import com.techelevator.dao.IssueDao;
import com.techelevator.model.Issue;
import com.techelevator.model.IssueDetailsDTO;
import com.techelevator.model.IssueOverviewDTO;
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


    public IssueController(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    @GetMapping(path = "/issues")
    public List<IssueOverviewDTO> getAllIssues(){
        return issueDao.getAllIssues();
    };

    @GetMapping(path = "/issues/user/{user_id}")
    public List<IssueOverviewDTO> getIssuesByUser(@PathVariable int user_id){
        return issueDao.getIssuesByUser(user_id);
    };

    @GetMapping(path = "/issues/tag/{tag_id}")
    public List<IssueOverviewDTO> getIssuesByTag(@PathVariable int tag_id){
        return issueDao.getIssuesByTag(tag_id);
    };

    @GetMapping(path = "/issues/id/{issue_id}")
    public IssueDetailsDTO getIssueByIssueId(@PathVariable int issue_id){
        return issueDao.getIssueByIssueId(issue_id);
    };

    @PostMapping(path = "/issues/create")
    public void createIssue(@RequestBody Issue issue) {
        issueDao.createIssue(issue);
    };

    @PutMapping(path = "/issues/issue-name/{issue_name}")
    public void updateIssueByName(Issue updatedIssue) {
        issueDao.updateIssueByName(updatedIssue);
    };

    @PutMapping(path = "/issues/issue-id/{issue_id}")
    public void updateIssueById(@RequestBody Issue updatedIssue) { //should this be a string or int? may need to change model/jdbcdao
        issueDao.updateIssueById(updatedIssue);
    };

    @RequestMapping(path = "/issues/delete-name/{issue_name}", method = RequestMethod.DELETE)
    public void deleteIssueByName(String name) {
        issueDao.deleteIssueByName(name);
    };

    @RequestMapping(path = "/issues/delete-id/{issue_id}", method = RequestMethod.DELETE)
    public void deleteIssueById(int issueId) {
        issueDao.deleteIssueById(issueId);
    };

}
