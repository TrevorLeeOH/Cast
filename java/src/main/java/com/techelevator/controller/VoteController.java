package com.techelevator.controller;

import com.techelevator.dao.VoteDao;
import com.techelevator.model.Vote;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class VoteController {

    private final VoteDao voteDao;

    public VoteController(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    @PostMapping(path = "/cast")
    public void CreateVote(@RequestBody Vote vote) {
        voteDao.createVote(vote);
    }
}
