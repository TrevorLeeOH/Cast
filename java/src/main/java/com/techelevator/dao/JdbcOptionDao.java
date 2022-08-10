package com.techelevator.dao;

import com.techelevator.model.Option;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOptionDao implements OptionDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcOptionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   

        @Override
        public List<Option> getOptionsForIssue ( int issueId){
            List<Option> option = new ArrayList<>();
            SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM issues WHERE issue_id = ?;", issueId);
            while (results.next()) {
                option.add(mapRowToOption(results));
            }


            return option;
        }

        private Option mapRowToOption (SqlRowSet results){
            Option option = new Option();
            option.getOptionA(results.getString("option_a"));
            option.getOptionB(results.getString("option_b"));
            option.getOptionC(results.getString("option_c"));
            option.getOptionD(results.getString("option_d"));
            option.getOptionE(results.getString("option_e"));
            option.getOptionF(results.getString("option_f"));
            option.getOptionG(results.getString("option_g"));
            option.getOptionH(results.getString("option_h"));

            return option;
        }

    }
