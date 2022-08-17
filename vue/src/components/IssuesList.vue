<template>
  <div class="issues-list">
      <form @submit.prevent="">
            <label for="tag-selector">Search By Tag: </label>
            
            <div id="tag-box">
                <label class="tag" v-for="tag in tags" :key="tag.tagId" :for="tag.tagName">{{tag.tagName + " (" + getNumberOfIssuesForTag(tag.tagId) + ")"}}
                    <input type="checkbox" :id="tag.tagName" :value="tag.tagId" v-model="tagFilter">
                </label>
            </div>
            <button @click="tagFilter = []">Clear All Tags</button>
            <div id="name-description-filter">
                <label class="Title" id="name-label" for="name">Search By Name: </label>
                <input type="text" id="name" v-model="nameFilter">
                <label class="Title" id="desc-label" for="desc">Search By Description: </label>
                <input type="text" id="desc" v-model="descFilter">
            </div>
      </form>
      <div id="issue-list-box">
          <issue-overview class="issue" :issue="issue" :active="active" v-for="issue in filteredIssuesList" :key="issue.issue_id"></issue-overview>
      </div>
      
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
                    return issue.tagList.some(tag => {
                        return this.tagFilter.includes(tag.tagId);
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
                if (curr.tagList.some(t => t.id === tagId)) {
                    sum += 1;
                }
                return sum;
            }, 0);
        }
    }
}
</script>

<style scoped>

    .issues-list {
        max-height: 100%;
        max-width: 100%;
        overflow-y: auto;
        overflow-x: hidden;
    }

    

    .issue {
        font-size: 1.0rem;
        border-style: solid;
        border-width: 1px;
        border-color: black;
    }

    #tag-box {
        height: 42px;
        width: 100%;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        align-self: center;
        gap: 10px;
        overflow-x: auto;
        overflow-y: hidden;
        border: 1px solid blue;
        border-radius: 12px;
        white-space: nowrap;
    }
    
    #issue-list-box {
       display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 16px;
        gap: 16px;
        

    }
    #name-description-filter {
        display: grid;
        grid-template-columns: 1fr, 1fr;
        grid-template-areas: "name-label desc-label" "name desc";
    }
    #name {
        grid-area: name;
        height: 20px;
    }
    #desc {
        grid-area: desc;
        height: 20px;
    }
    #name-label {
        grid-area: name-label;
    }
    #desc-label {
        grid-area: desc-label;
    }

</style>