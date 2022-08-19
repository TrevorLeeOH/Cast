 <template>
    <div id="active-issues">
      <h1 id="active-issues-header">Vote</h1>
      <div id="active-issues-list">
        <issues-list :issues="issues" :tags="tags" :active="true"></issues-list>
      </div>
    </div>
</template>

<script>
import IssuesList from '@/components/IssuesList.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
  name: 'active-issues',
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
      TagService.getTags().then(response => {
        if (response.status == 200) {
          this.tags = response.data;
        }
      });
    }
  },
  created() {
    this.getIssues();
    this.getTags();
  }
}
</script>

<style>
#active-issues {
  background: #fff;
}

  #active-issues-list {
    height: 610px;
  }

  #vote-top {
    display: flex;
    justify-content: flex-end;
    width: 300px;
    gap: 95px;
  }

  #active-issues-header {
    text-align: center;
    font-family: 'museo-sans';
    font-weight: 800;
    margin-bottom: 5px;
  }

  #search-icon {
    height: 20px;
    margin-top: 20px;
    
  }

  .Frame-104 {
    width: 100%;
    height: 59px;
    align-self: stretch;
    flex-grow: 0;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    gap: 10px;
    padding: 10px;
  }


  .Section-1 {
    height: 25px;
    flex-grow: 1;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    padding: 8px 12px;
    border-radius: 12px;
    background-color: #fff;
  }

  .Section-2 {
    height: 25px;
    flex-grow: 1;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    padding: 8px 12px;
    border-radius: 12px;
  }

  .Section-3 {
    height: 25px;
    flex-grow: 1;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
    padding: 8px 12px;
    border-radius: 12px;
  }

  .Content-Switcher {
    
    height: 30px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 4px;
    border-radius: 16px;
    background-color: #f8f9fe;
  }

  section {
    width: 70px;
    height: 15px;
    flex-grow: 0;
    font-family: 'museo-sans';
    font-size: 12px;
    font-weight: bold;
    font-stretch: normal;
    font-style: normal;
    line-height: normal;
    letter-spacing: normal;
    text-align: center;
    color: #71727a;
  }

  .Divider {
    width: 1px;
    height: 10px;
    flex-grow: 0;
    background-color: var(--neutral-light-darkest);
  }

  .Filtering {
    width: 325px;
    height: 52px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    gap: 16px;
    padding: 8px 16px;
  }

  .Filter {
    width: 50px;
    height: 20px;
    flex-grow: 0;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    gap: 12px;
    padding: 8px 12px;
    border-radius: 12px;
    border: solid 0.5px; color: #c5c6cc;
  }

  .filter-icon {
      width: 12px;
      height: 12px;
      flex-grow: 0;
      object-fit: contain;
  }

  .filter-title {
    width: 34px;
    height: 16px;
    flex-grow: 0;
    font-family: 'museo-sans';
    font-size: 14px;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1.14;
    letter-spacing: 0.14px;
    text-align: left;
    color: #1f2024;
  }

</style>