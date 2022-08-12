<template>
  <div>
      <h1>Closed Issues</h1>
      <issues-list :issues="issues" :tags="tags" :active="false"></issues-list>
  </div>
</template>

<script>
import IssuesList from '@/components/IssuesList.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    name: 'closed-issues',
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
            IssueService.getClosedIssues().then(response => {
                if (response.status == 200) {
                    let allIssues = response.data;
                    this.issues = allIssues.filter(i => i.expiration != null && i.expiration < Date.now());
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

</style>