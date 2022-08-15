<template>
  <div id="issue-box" v-if="issue != {}">
      <div id="name-description">
          <h1 id="issue-name">{{issue.name}}</h1>
          <p id="issue-description">{{issue.description}}</p>
      </div>
      
      <div id="options-box">
          <div @click="selectDeselect(index)" :class="vote[index] != null ? 'selected-option' : 'unselected-option'" v-for="(option, index) in issue.optionList" :key="option">
              <div v-if="vote[index] != null" class="selected-option-icon">
                  <p class="selected-option-number">{{vote[index] != null ? vote[index] : 'O'}}</p>
              </div>
              
              <span class="option-label">{{option}}</span>


              <!--
                  <span v-if="voted" class="vote-bar" :style="'width: ' + getVotePercentage(issue.resultsList[index]) * 1000 + 'px'">{{issue.resultsList[index]}}</span>
            !-->
              
          </div>
          <button class="Button-Primary" v-if="!voted" @click="castBallot">Cast Ballot</button>
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
            voted: false,
            vote: []
        }
    },
    created() {
        this.getIssue();
    },
    methods: {

        selectDeselect(index) {
            console.log('index = ' + index);
            
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
    #issue-box {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 18px;
        gap: 32px;
        

    }
    #name-description {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
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
        font-weight: 700;
        font-size: 24px;
        line-height: 29px;
        letter-spacing: 0.02em;
    }
    #issue-description {
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 400;
        font-size: 16px;
        line-height: 20px;
    }
    #options-box {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 0px;
        gap: 16px;

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
        width: 300px;
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
</style>