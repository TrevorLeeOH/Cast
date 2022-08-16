package com.techelevator.controller;

import com.techelevator.dao.IssueDao;
import com.techelevator.dao.TagDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Issue;
import com.techelevator.model.IssueDetailsDTO;
import com.techelevator.model.IssueOverviewDTO;
import com.techelevator.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class IssueController {

//    @Autowired  //this brings in the IssueDao as a new object for us to use automatically
    private IssueDao issueDao;
    private UserDao userDao;
    private TagDao tagDao;


    public IssueController(IssueDao issueDao, UserDao userDao, TagDao tagDao) {
        this.issueDao = issueDao;
        this.userDao = userDao;
        this.tagDao = tagDao;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ISSUER')")
    @PostMapping(path = "/issues/create")
    public void createIssue(@RequestBody Issue issue) {
        issueDao.createIssue(issue);
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ISSUER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @PutMapping(path = "/issues/issue-name/{issue_name}")
    public void updateIssueByName(Issue updatedIssue, Principal principal) {
        String username = principal.getName();
        int userId = userDao.findIdByUsername(username);
        if (userId == updatedIssue.getUserId()) {
            issueDao.updateIssueByName(updatedIssue);
            List<Tag> tempTagList = tagDao.getTagsForIssue(updatedIssue.getIssueId());
            for (Tag tag : tempTagList) {
                tagDao.updateTags(tag);
            }
        }
    };

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ISSUER')") //need to add Principal principal to jdbctemplate to specify user that created issue only
    @PutMapping(path = "/issues/issue-id/{issue_id}")
    public void updateIssueById(@RequestBody Issue updatedIssue, Principal principal) {
        String username = principal.getName();
        int userId = userDao.findIdByUsername(username);
        if (userId == updatedIssue.getUserId()) {
            issueDao.updateIssueById(updatedIssue);
        }
    };

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/issues/delete-name/{issue_name}", method = RequestMethod.DELETE)
    public void deleteIssueByName(String name) {
        issueDao.deleteIssueByName(name);
    };

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/issues/delete-id/{issue_id}", method = RequestMethod.DELETE)
    public void deleteIssueById(int issueId) {
        issueDao.deleteIssueById(issueId);
    };

}
