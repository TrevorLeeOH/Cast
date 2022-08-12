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
            IssueService.getActiveIssues().then(response => {
                console.log(response.status);
                console.log(response.data);
                if (response.status == 200) {
                    let allIssues = response.data;
                    this.issues = allIssues.filter(i => i.expiration == null || i.expiration > Date.now());
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