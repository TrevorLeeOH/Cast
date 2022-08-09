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
      userVote: 1
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
      userVote: null
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
      userVote: null
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
      userVote: null
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
      userVote: 0
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
      return issue;
    },

    deleteIssue(issueId) {
      return issueId;
    }

}