package com.techelevator.controller;


import com.techelevator.dao.TagDao;
import com.techelevator.model.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("permitAll")
@RequestMapping("/tag")
public class TagController {
    private TagDao tagDao;

    public TagController(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @RequestMapping(path = "/{issueId}", method = RequestMethod.GET)
    public List<Tag> tagById(@PathVariable int issueId){
        return tagDao.getTagsForIssue(issueId);
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/new",  method = RequestMethod.POST)
    public void tagByName(@Valid @RequestBody Tag tag) {
        tagDao.createTag(String.valueOf(tag));
    }

}
