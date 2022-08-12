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

@RestController
@CrossOrigin
public class IssueController {

//    @Autowired  //this brings in the IssueDao as a new object for us to use automatically
    private IssueDao issueDao;


    public IssueController(IssueDao issueDao) {
        this.issueDao = issueDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/issues")
    public List<IssueOverviewDTO> getAllIssues(){
        return issueDao.getAllIssues();
    };

    @PreAuthorize("permitAll")
    @GetMapping(path = "/issues/user/{user_id}")
    public List<IssueOverviewDTO> getIssuesByUser(@PathVariable int user_id){
        return issueDao.getIssuesByUser(user_id);
    };

    @PreAuthorize("permitAll")
    @GetMapping(path = "/issues/tag/{tag_id}")
    public List<IssueOverviewDTO> getIssuesByTag(@PathVariable int tag_id){
        return issueDao.getIssuesByTag(tag_id);
    };

    @PreAuthorize("permitAll")
    @GetMapping(path = "/issues/id/{issue_id}")
    public IssueDetailsDTO getIssueByIssueId(@PathVariable int issue_id){
        return issueDao.getIssueByIssueId(issue_id);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping(path = "/issues/create")
    public void createIssue(Issue issue) {
        issueDao.createIssue(issue);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @PutMapping(path = "/issues/issue-name/{issue_name}")
    public void updateIssueByName(Issue updatedIssue) {
        issueDao.updateIssueByName(updatedIssue);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @PutMapping(path = "/issues/issue-id/{issue_id}")
    public void updateIssueById(Issue updatedIssue) {
        issueDao.updateIssueById(updatedIssue);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @RequestMapping(path = "/issues/delete-name/{issue_name}", method = RequestMethod.DELETE)
    public void deleteIssueByName(String name) {
        issueDao.deleteIssueByName(name);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @RequestMapping(path = "/issues/delete-id/{issue_id}", method = RequestMethod.DELETE)
    public void deleteIssueById(int issueId) {
        issueDao.deleteIssueById(issueId);
    };

}
