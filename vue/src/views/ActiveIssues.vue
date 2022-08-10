 <template>
  <div>
      <h1>Active Issues</h1>
      <issues-list :issues="getIssues()" :tags="getTags()" :active="true"></issues-list>
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

    methods: {
        getIssues() {
            return IssueService.getActiveIssues();
        },
        getTags() {
            return TagService.getTags();
        }
    }
}
</script>

<style>

</style>