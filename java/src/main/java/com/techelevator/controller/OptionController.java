//package com.techelevator.controller;
//
//import com.techelevator.dao.OptionDao;
//import com.techelevator.model.Option;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class OptionController {
//
//    private OptionDao optionDao;
//
//
//
//    public OptionController(OptionDao optionDao) {
//        this.optionDao = optionDao;
//    }
//
//    @GetMapping(path = "/options/{issue_id}")
//    public List<Option> getOptionsForIssue(@PathVariable int issue_id){
//        return optionDao.getOptionsForIssue(issue_id);
//    }
//
//    @PostMapping(path = "options/{issue_id}")
//    public void createOptionList(@PathVariable int issue_id){
//        List<Option> optionList = new ArrayList<>();
//    }
//
//
//}
