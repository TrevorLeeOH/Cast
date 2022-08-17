<template>
  <div class="home">
    <header>
      <img id="header-logo" src="..\assets\CAST_logo-02.png"/>
      <img id="avatar" src="..\assets\Avatar@2x.png"/>
    </header>
    <div id="home-content">
      <header id="cast-ballot">
        <span class="cast-your-ballot"> Cast Your Ballot</span>
        <span class="See-more">See more</span>
      </header>
      <issues-list id="home-issues" :issues="issues" :tags="tags" :active="true"></issues-list>

      <header id="poll-results">
        <span class="cast-your-ballot">Poll Results</span>
      </header>
    </div>

    
  </div>
</template>

<script>
import IssuesList from '@/components/IssuesList.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    name: 'home',
    data() {
        return {
            issues: [],
            tags: []
        }
    },
    components: {
        IssuesList,
    },

    methods: {
        getIssues() {
            IssueService.getActiveIssues().then(response => {
                if (response.status == 200) {
                    let allIssues = response.data;
                    this.issues = allIssues.filter(i => i.expiration == null || new Date(i.expiration) > Date.now());
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
  height: 812px;
  left: 0px;
  top: 170px;
  background: #FFFFFF;
  border-radius: 12px;
}

header {
  max-width: 375px;
  height: 80px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin: 35.4px 0px 0.5px 0;
  padding: 16px;
  border: solid 1px #e8e9f1;
  background-color: #fff;
  border-top: none;
 
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
    height: 669px;
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
  margin-top: 15px;
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

</style>