<template>
  <div id="vote-box" v-if="issue != {}">
      <div id="name-description">
          <h1 id="issue-name">{{issue.name}}</h1>
          <p id="issue-description">{{issue.description}}</p>
      </div>
      <div v-if="!issue.userVoted && (issue.expiration == null || new Date(issue.expiration) > Date.now())" id="options-box">
          <div  @click="selectDeselect(index)" :class="vote[index] != null ? 'selected-option' : 'unselected-option'" v-for="(option, index) in issue.optionList" :key="option">
              <div v-if="vote[index] != null" class="selected-option-icon">
                  <p class="selected-option-number">{{vote[index] != null ? vote[index] : 'O'}}</p>
              </div>
              <span class="option-label">{{option}}</span>
          </div>
          <button class="Button-Primary" @click="castBallot">Cast Ballot</button>
      </div>
      <div v-else id="options-box">
          <div class="option-results" v-for="(option, index) in issue.optionList" :key="option">
              <div class="result-bar" :style="'width: ' + getVotePercentage(issue.resultsList[index]) * 100 + '%'">
                  <span class="option-label">{{option}}</span>  
              </div>
              <span class="vote-count">{{issue.resultsList.length > 0 ? issue.resultsList[index] : 0}}</span>
          </div>
      </div>
      <router-link v-if="issue.author.id === $store.state.user.id || $store.state.user.authorities.some(role => role.name == 'ROLE_ADMIN')" :to="{name: 'issue-editor', params: {id: issue.issueId}}">
          Edit Issue
      </router-link>
  </div>
</template>

<script>
import IssueService from '@/services/IssueService.js';
import VoteService from '@/services/VoteService.js';

export default {
    data() {
        return {
            issue: {
                author: {
                    id: -1
                },
                issueId: -1
            },
            vote: []
        }
    },
    created() {
        this.getIssue();
    },
    methods: {
        selectDeselect(index) {            
            if (this.vote[index] == null) {
                let newValue = 1 + this.vote.reduce((prev, curr) => {
                    return Math.max(prev, curr != null ? curr : 0);
                }, 0);
                this.vote.splice(index, 1, newValue)
            } else {
                this.vote = this.vote.map(val => {
                    return val != null && val > this.vote[index] ? val - 1 : val;
                });
                this.vote[index] = null;
            }
        },
        getIssue() {
            IssueService.getIssue(this.$route.params.id).then(response => {
                if (response.status == 200) {
                    this.issue = response.data;
                    this.vote = new Array(this.issue.optionList.length).fill(null);
                } else {
                    alert("Failed to load issue");
                }
            });
        },
        getVotePercentage(votes) {
            if (this.issue.resultsList.length == 0) {
                return 0;
            }
            let sum = this.issue.resultsList.reduce((prev, curr) => {
                return prev + curr;
            }, 0);
            return votes / sum;
        },
        castBallot() {
            if (this.vote.includes(null)) {
                alert("Please rank all options");
                return;
            }

            let voteDTO = {
                issueId: this.issue.issueId,
                userId: this.$store.state.user.id,
                points: this.vote
            }
            VoteService.createVote(voteDTO).then(response => {
                if (response.status === 200) {
                    alert("Vote Submitted!");
                    this.getIssue();
                } else {
                    alert("Failed to submit vote!");
                }
            })
        }
    }
    

}
</script>

<style>
    #vote-box {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 8px;
        gap: 32px;
        margin: 8px;
        width: 342px;
        justify-content: flex-start;
        align-items: flex-start;
        padding: 24px;
        margin-top: 30px;
        max-height: 640px;
    }
    #name-description {
        display: flex;
        flex-direction: column;
        align-content: center;
        padding: 0px;
        gap: 16px;
        
        /*
        width: 327px;
        height: 114px;
        */

    }
    #issue-name {
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 900;
        font-size: 24px;
        line-height: 29px;
        letter-spacing: 0.48px;
        color: #1f2024;
        margin-bottom: 0%;
        
    }
    #issue-description {
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 300;
        font-size: 16px;
        line-height: 20px;
        margin-top: 0%;
        color: #71727A;
    }
    #options-box {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        width: 100%;
        padding: 0px;
        gap: 12px;

    }
    .selected-option {
        display: flex;
        flex-direction: row;
        align-items: center;
        padding: 16px;
        gap: 16px;
        border-radius: 12px;
        width: 300px;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        cursor: pointer;
        
    }
    .unselected-option {
        display: flex;
        flex-direction: row;
        align-items: center;
        padding: 16px;
        gap: 16px;
        border-radius: 12px;
        width: 294px;
        border: 0.5px solid #C5C6CC;
        cursor: pointer;
    }
    .issue-option {
        display: flex;
        flex-direction: row;
        align-items: center;
        padding: 16px;
        gap: 16px;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        border-radius: 12px;
        
    }
    .selected-option-number {
        font-style: normal;
        font-weight: 600;
        font-size: 10px;
        line-height: 12px;
        text-align: center;
        color: white;
    }
    .selected-option-icon {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 20px;
        height: 20px;

        background: #467BF5;
        border-radius: 20px;
    }
    .unselected-option-icon {

        width: 20px;
        height: 20px;
        background: #467BF5;
        border-radius: 20px;
    }

    .vote-bar {
        background-color: rgb(77, 152, 236);
        display: inline-block;
    }
    .option-label {
        display: inline-block;
        width: 200px;
    }
    .option-results {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        
        gap: 16px;
        border-radius: 12px;
        width: 300px;
        border: 0.5px solid #C5C6CC;
        
    }
    .result-bar {
        display: flex;
        flex-direction: row;
        border-radius: 12px;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        padding: 16px;
        
    }
    .vote-count {
        margin-right: 6px;
    }
</style>