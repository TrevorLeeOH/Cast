//import axios from 'axios';

import axios from "axios";

export default {

    getClosedIssues() {
      return axios.get('/issues');
    },

    getActiveIssues() {
      return axios.get('/issues');
    },

    getIssue(id) {
      return axios.get('/issues/id/' + id);
    },

    createIssue(issue) {
      return axios.post('/issues/create', issue);
    },

    updateIssue(issue) {
      return axios.put('/issues/issue-id/' + issue.issue_id, issue);
    },

    deleteIssue(issueId) {
      
      return issueId;
    },


    



}