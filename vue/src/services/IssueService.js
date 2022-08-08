//import axios from 'axios';

const closedIssues = [
    {
      issue_id: 1,
      name: 'murder',
      description: 'What is your opinion on murder?',
      tags: [1],
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
      ]
    },
    {
      issue_id: 2,
      name: 'ice cream',
      description: 'What is your opinion on ice cream?',
      tags: [2],
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
      ]
    }
  ];

export default {

    getClosedIssues() {
        return closedIssues;
    },

    getOpenIssues() {
        return [];
    },

    getIssue(id) {
        return closedIssues.find(issue => {
            return issue.issue_id === id;
        });
    }



  

}