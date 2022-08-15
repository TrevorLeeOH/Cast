<template>
  <div v-if="issue != {}">
      <h1>{{issue.name}}</h1>
      <p>{{issue.description}}</p>
      <div>
          <div v-for="(option, index) in issue.optionList" :key="option">
              <span class="option-label">{{option}}</span>
              <span v-if="voted" class="vote-bar" :style="'width: ' + getVotePercentage(issue.resultsList[index]) * 1000 + 'px'">{{issue.resultsList[index]}}</span>
              <select v-else id="rank" v-model="vote[index]">
                  <option v-for="index in issue.optionList.length" :key="index" :value="index">{{index}}</option>
              </select>
          </div>
          <button v-if="!voted" @click="castBallot">Cast Ballot</button>
      </div>
  </div>
</template>

<script>
import IssueService from '@/services/IssueService.js';
import VoteService from '@/services/VoteService.js';

export default {
    data() {
        return {
            issue: {},
            voted: true,
            vote: []
        }
    },
    created() {
        this.getIssue();
    },
    methods: {
        getIssue() {
            IssueService.getIssue(this.$route.params.id).then(response => {
                if (response.status == 200) {
                    this.issue = response.data;
                    this.vote = new Array(this.issue.optionList.length);
                } else {
                    alert("Failed to load issue");
                }
            });
        },
        getVotePercentage(votes) {
            let sum = this.issue.resultsList.reduce((prev, curr) => {
                return prev + curr;
            }, 0);
            return votes / sum;
        },
        castBallot() {
            for (let i = 1; i <= this.issue.optionList.length; i++) {
                if (!this.vote.includes(i)) {
                    alert("Invalid Input, please fill out all options and use each rank only once for each option");
                    return;
                }
            }

            let voteDTO = {
                issueId: this.issue.issueId,
                userId: this.$store.state.user.id,
                points: this.vote
            }
            VoteService.createVote(voteDTO).then(response => {
                console.log(response);
            })

            //call create vote on vote service
            //refresh issue
            alert("Vote Submitted!");
            //this.$router.push({name: 'active-issues'});
        }
    }
    

}
</script>

<style>
    
    .vote-bar {
        background-color: rgb(77, 152, 236);
        display: inline-block;
    }
    .option-label {
        display: inline-block;
        width: 200px;
    }
</style>