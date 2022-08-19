<template>
  <div class="home">
    <div id="home-content">
      <img id="ballot-box" src="..\assets\Ballot_box.gif" alt="ballot box">
      <span class="Tag-Line">Cast Your Ballot</span>
      <!-- <div class="Content2">         -->
        <span class="Rank">Ranked Choice Voting gives a broader picture of what voters want.</span>
        <router-link id="vote-now-link" :to="{name: 'active-issues'}" tag="button">
                <p id="vote-now-text">Vote Now!</p>
            </router-link>
      <!-- <router-link class="sign-up-button" :to="{name: 'register'}"> Sign Up
       </router-link> -->
      
      <!-- </div> -->
    
      <header id="cast-ballot">
        <span class="cast-your-ballot">Poll of the Day</span>
        <router-link :to="{name: 'active-issues'}" class="See-more">See more</router-link>
      </header>
     
      <!-- <header id="poll-results">
        <span class="cast-your-ballot">Poll Results</span>
      </header> -->
    
        <issue-overview :issue="issue" :active="true"></issue-overview>
    </div>
 

    
  </div>
</template>

<script>
//import IssuesList from '@/components/IssuesList.vue';
import IssueOverview from '@/components/IssueOverview.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    name: 'home',
    data() {
        return {
          issue: {},

        }
    },
    components: {
      //IssuesList,
      IssueOverview
    },
  

    methods: {
        getIssues() {
            IssueService.getIssue(2).then(response => {
                if (response.status == 200) {
                    this.issue = response.data;
                } else {
                    alert("failed");
                }
            });
        },
        getTags() {
            this.tags = TagService.getTags();
        }
    },
    created() {
        this.getIssues();
        this.getTags();
    },

}

</script>

<style>

.home {
  max-width: 375px;
  left: 0px;
  top: 170px;
  background: #edf2fe;
}

#header-logo {
    width: 120px;
  height: auto;
  flex-grow: 0;
  padding: 0 0 0px;
}

#ballot-box {
    width: 200px;
  height: 200px;
  flex-grow: 0;
}

#avatar {
  width: 48px;
  height: 48px;
  flex-grow: 0;
  object-fit: contain;
  border-radius: 25px;
  background-color: #edf2fe;
  margin-right: 10px;
}

#home-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    padding-top: 16px;
    gap: 10px;
    max-width: 375px;
    height: 569px;
    left: 0px;
    top: 143.41px;
    overflow-y: scroll;
}

#cast-ballot {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: flex-end;
  padding: 0px 0px 0px 8px;
  gap: 138px;
  width: 343px;
  height: 17px;
  flex: none;
  order: 0;
  align-self: stretch;
  flex-grow: 0;
  margin-top: 0px;
  border: none;
  background-color: #edf2fe;
  }

.cast-your-ballot {

  width: auto;
  height: 17px;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 15px;
  font-weight: 800;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: normal;
  text-align: left;
  color: #71727a;

}

.See-more {
  width: 62px;
  height: 17px;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: normal;
  text-align: left;
  color: #467bf5;
}

#home-issues {
max-height: 339px;
overflow-y: scroll;
}

#poll-results {
  height: 17px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: flex-start;
  gap: 138px;
  padding: 0 0 0 8px;
  border: none;
}

.Tag-Line {
  height: 29px;
  margin: none;
  font-family: 'museo-sans';
  font-size: 24px;
  font-weight: 900;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.48px;
  text-align: left;
  padding: 0px 20px;
  color: #000;
}

.Content2 {
  height: 200px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 24px;
  padding: 24px 24px;
}

.Rank {

  flex-grow: .05;
  font-family: 'museo-sans';
  font-size: 16px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.48px;
  text-align: center;
  color: #000;
  padding: 0px 20px;
}

.Start-Now {

  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 20px;
  font-weight: 600;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.48px;
  text-align: left;
  color: #000;
}

.issue-box {
  align-self: center;
}

#vote-now-link {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        padding: 12px 16px;
        gap: 8px;
        width: 102px;
        height: 40px;
        background: #467BF5;
        border-radius: 8px;
        margin-bottom: 15px;
    }
    #vote-now-link-text {
        width: 31px;
        height: 17px;
        font-family: 'museo-sans';
        font-weight: 500;
        font-size: 14px;
        line-height: 17px;
        color: #FFFFFF;
        margin: 0px;
    }

</style>