//import axios from 'axios';

const issues = [
    {
      issue_id: 1,
      issue_name: 'murder',
      description: 'What is your opinion on murder?',
      expiration: new Date(2022, 5, 20, 12, 0),
      tags: [
        {
          id: 1,
          name: 'crime'
        },
        {
          id: 8,
          name: 'tag8'
        }
      ],
        user_voted: true,
        author: {
        user_id: 1,
        username: 'Trevor'
      }
    },
    {
      issue_id: 2,
      issue_name: 'ice cream',
      description: 'What is your opinion on ice cream?',
      expiration: new Date(2022, 9, 22, 10, 0),
      tags: [
        {
          id: 2,
          name: 'food'
        }
      ],
      user_voted: false,
      author: {
        user_id: 1,
        username: 'Trevor'
      }
    },
    {
      issue_id: 3,
      issue_name: 'World Peace',
      description: 'What is your opinion on world peace?',
      expiration: new Date(2022, 7, 8, 1, 1),
      tags: [
        {
          id: 7,
          name: 'tag7'
        }
      ],
      user_voted: false,
      author: {
        user_id: 2,
        username: 'Matt'
      }
    },
    {
      issue_id: 4,
      issue_name: 'issue4',
      description: 'What is your opinion on issue4?',
      expiration: new Date(2022, 1, 1, 1, 20),
      tags: [
        {
          id: 4,
          name: 'tag4'
        }
      ],
      user_voted: false,
      author: {
        user_id: 3,
        username: 'Zac'
      }
    },
    {
      issue_id: 5,
      issue_name: 'issue5',
      description: 'What is your opinion on issue5?',
      expiration: new Date(2022, 9, 22, 10, 0),
      tags: [
        {
          id: 5,
          name: 'tag5'
        }
      ],
      user_voted: false,
      author: {
        user_id: 4,
        username: 'Carrie'
      }
    }
  ];


export default {

    getClosedIssues() {
      //return axios.get('/closed-issues');
      return issues.filter(issue => {
        return issue.expiration <= Date.now();
      });
    },

    getActiveIssues() {
      //return axios.get('/active-issues');
      return issues.filter(issue => {
        return issue.expiration > Date.now();
      })
    },

    getIssue(id) {
      return issues.find(issue => {
          return issue.issue_id === id;
      });
    },

    createIssue(issue) {
      return issue;
    },

    updateIssue(issue) {
      for (let i = 0; i < issues.length; i++) {
        if (issues[i].issue_id === issue.issue_id) {
          issues[i] = issue;
          return true;
        }
      }

      return false;
    },

    deleteIssue(issueId) {
      for (let i = 0; i < issues.length; i++) {
        if (issues[i].issue_id === issueId) {
          issues.splice(i, 1);
          return true;
        }
      }
      return false;
    },

}