//import axios from 'axios';

const issues = [
    {
      issue_id: 1,
      name: 'murder',
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
      results: [
        {
          answer: 'Never okay',
          votes: 10
        },
        {
          answer: 'Sometimes okay',
          votes: 3
        },
        {
          answer: 'Totally cool',
          votes: 1
        }
      ],
      userVote: 1,
      author: {
        user_id: 1,
        username: 'Trevor'
      }
    },
    {
      issue_id: 2,
      name: 'ice cream',
      description: 'What is your opinion on ice cream?',
      expiration: new Date(2022, 9, 22, 10, 0),
      tags: [
        {
          id: 2,
          name: 'food'
        }
      ],
      results: [
        {
          answer: 'love it',
          votes: 30
        },
        {
          answer: 'indifferent',
          votes: 4
        },
        {
          answer: 'hate it',
          votes: 0
        }
      ],
      userVote: null,
      author: {
        user_id: 1,
        username: 'Trevor'
      }
    },
    {
      issue_id: 3,
      name: 'World Peace',
      description: 'What is your opinion on world peace?',
      expiration: new Date(2022, 7, 8, 1, 1),
      tags: [
        {
          id: 7,
          name: 'tag7'
        }
      ],
      results: [
        {
          answer: 'love it',
          votes: 30
        },
        {
          answer: 'indifferent',
          votes: 4
        },
        {
          answer: 'hate it',
          votes: 0
        }
      ],
      userVote: null,
      author: {
        user_id: 2,
        username: 'Matt'
      }
    },
    {
      issue_id: 4,
      name: 'issue4',
      description: 'What is your opinion on issue4?',
      expiration: new Date(2022, 1, 1, 1, 20),
      tags: [
        {
          id: 4,
          name: 'tag4'
        }
      ],
      results: [
        {
          answer: 'love it',
          votes: 30
        },
        {
          answer: 'indifferent',
          votes: 4
        },
        {
          answer: 'hate it',
          votes: 0
        }
      ],
      userVote: null,
      author: {
        user_id: 3,
        username: 'Zac'
      }
    },
    {
      issue_id: 5,
      name: 'issue5',
      description: 'What is your opinion on issue5?',
      expiration: new Date(2022, 9, 22, 10, 0),
      tags: [
        {
          id: 5,
          name: 'tag5'
        }
      ],
      results: [
        {
          answer: 'love it',
          votes: 30
        },
        {
          answer: 'indifferent',
          votes: 4
        },
        {
          answer: 'hate it',
          votes: 0
        }
      ],
      userVote: 0,
      author: {
        user_id: 4,
        username: 'Carrie'
      }
    }
  ];

export default {

    getClosedIssues() {
        return issues.filter(issue => {
          return issue.expiration <= Date.now();
        });
    },

    getActiveIssues() {
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
    }

}