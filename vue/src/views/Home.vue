<template>
  <div class="home">
    <div id="home-content">
      <div class="Content2">        

        <span class="Tag-Line">Revealing The Complexity of Public Opinion</span>
        <p></p>
        <span class="Rank">Ranked choice polls allow our users to express the full breadth of their thoughts and opinions on a wide variety of topics.</span>
      <!-- <router-link class="sign-up-button" :to="{name: 'register'}"> Sign Up
       </router-link> -->
      
      </div>
    
      <header id="cast-ballot">
        <span class="cast-your-ballot"> Cast Your Ballot</span>
        <router-link :to="{name: 'active-issues'}" class="See-more">See more</router-link>
      </header>
      <issue-overview :issue="issue" :active="true"></issue-overview>
      
      <!--
      <issues-list id="home-issues" :issues="issues" :tags="tags" :active="true"></issues-list>
      !-->
      <!-- <header id="poll-results">
        <span class="cast-your-ballot">Poll Results</span>
      </header> -->
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
          issue: {}
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
    }
}
</script>

<style>

.home {
  max-width: 375px;
  left: 0px;
  top: 170px;
  background: #FFFFFF;
  border-radius: 12px;
}

#header-logo {
    width: 120px;
  height: auto;
  flex-grow: 0;
  padding: 0 0 0px;
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
    align-items: flex-start;
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
  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 24px;
  font-weight: 900;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.48px;
  text-align: left;
  color: #000;
}

.Content2 {
  height: 326.6px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 24px;
  padding: 24px 24px;
}


</style>