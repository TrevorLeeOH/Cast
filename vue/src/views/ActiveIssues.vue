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

</style>