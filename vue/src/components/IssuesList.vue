<template>
  <div>
      <form @submit.prevent="">
            <label for="tag">Search By Tag: </label>
            <div id="tag-box">
                <button @click="tagFilter = []">Clear All Tags</button>
                <label class="tag" v-for="tag in tags" :key="tag.id" :for="tag.name">{{tag.name + " (" + getNumberOfIssuesForTag(tag.id) + ")"}} 
                    <input type="checkbox" :id="tag.name" :value="tag.id" v-model="tagFilter">
                </label>
            </div>
            
            <label for="name">Search By Name: </label>
            <input type="text" id="name" v-model="nameFilter">
            <label for="desc">Search By Description: </label>
            <input type="text" id="desc" v-model="descFilter">
      </form>
      <issue-overview class="issue" :issue="issue" :active="active" v-for="issue in filteredIssuesList" :key="issue.issue_id"></issue-overview>
  </div>
</template>

<script>
import IssueOverview from '@/components/IssueOverview.vue';

export default {
    components: {
        IssueOverview
    },
    props: ['issues', 'tags', 'active'],
    data() {
        return {
            nameFilter: '',
            descFilter: '',
            tagFilter: []
        }
    },
    computed: {
        filteredIssuesList() {
            let filteredIssues = this.issues
            if (this.tagFilter.length > 0) {
                filteredIssues = filteredIssues.filter(issue => {                
                    return issue.tags.some(tag => {
                        return this.tagFilter.includes(tag.id);
                    });
                });
            }
            if (this.nameFilter != '') {
                filteredIssues = filteredIssues.filter(issue => {
                    return issue.name.toLowerCase().includes(this.nameFilter.toLowerCase());
                });
            }
            if (this.descFilter != '') {
                filteredIssues = filteredIssues.filter(issue => {
                    return issue.description.toLowerCase().includes(this.descFilter.toLowerCase());
                });
            }
            return filteredIssues
        }
    },
    methods: {
        getNumberOfIssuesForTag(tagId) {
            return this.issues.reduce((sum, curr) => {
                if (curr.tags.some(t => t.id === tagId)) {
                    sum += 1;
                }
                return sum;
            }, 0);
        }
    }
}
</script>

<style>
    .issue {
        font-size: 1.0rem;
        border-style: solid;
        border-width: 1px;
        border-color: black;
    }

    #tag-box {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    

    #tag {
        flex-grow: 1;
        border-style: solid;
        border-width: 1px;
    }
</style>