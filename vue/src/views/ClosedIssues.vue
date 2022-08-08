<template>
  <div>
      <h1>Closed Issues</h1>
      <closed-issues-list :issues="getIssues()" :tags="getTags()"></closed-issues-list>
  </div>
</template>

<script>
import ClosedIssuesList from '@/components/ClosedIssuesList.vue';
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    name: 'closed-issues',
    components: {
        ClosedIssuesList,
    },

    methods: {
        getIssues() {
            return IssueService.getClosedIssues();
        },
        getTags() {
            return TagService.getTags();
        }
    }
}
</script>

<style>

</style>