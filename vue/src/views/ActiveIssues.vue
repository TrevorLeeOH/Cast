<template>
  <div>
      <h1>Active Issues</h1>
      <issues-list :issues="issues" :tags="tags" :active="true"></issues-list>
  </div>
</template>

<script>
import IssuesList from '@/components/IssuesList.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    name: 'active-issues',
    components: {
        IssuesList,
    },
    data() {
        return {
            issues: [],
            tags: []
        }
    },

    methods: {
        getIssues() {
            //IssueService.getActiveIssues().then(response => {
           //     this.issues = response.data;
            //})
            this.issues = IssueService.getActiveIssues();
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

</style>