<template>
  <div v-if="issue != {}">
      <h1>{{issue.name}}</h1>
      <p>{{issue.description}}</p>
      <div>
          <div v-for="(option, index) in issue.options" :key="option">
              <span class="option-label">{{option}}</span>
              <span v-if="voted" class="vote-bar" :style="'width: ' + getVotePercentage(issue.results[index]) * 1000 + 'px'">{{issue.results[index]}}</span>
              <select v-else id="rank" v-model="vote[index]">
                  <option v-for="index in issue.options.length" :key="index" :value="index">{{index}}</option>
              </select>
          </div>
          <button @click="castBallot">Cast Ballot</button>
      </div>
  </div>
</template>

<script>
import IssueService from '@/services/IssueService.js';

export default {
    data() {
        return {
            issue: {},
            voted: false,
            vote: []
        }
    },
    created() {
        IssueService.getIssue(this.$route.params.id).then(issue => {
            this.issue = issue;
            this.vote = new Array(issue.options.length);
        });
    },
    methods: {
        getVotePercentage(votes) {
            let sum = this.issue.results.reduce((prev, curr) => {
                return prev + curr;
            }, 0);
            return votes / sum;
        },
        castBallot() {
            for (let i = 1; i <= this.issue.options.length; i++) {
                if (!this.vote.includes(i)) {
                    alert("Invalid Input, please fill out all options and use each rank only once for each option");
                    return;
                }
            }
            //call create vote on vote service
            //refresh issue
            alert("Vote Submitted!");
            this.$router.push({name: 'active-issues'});
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
        width: 100px;
    }
</style>