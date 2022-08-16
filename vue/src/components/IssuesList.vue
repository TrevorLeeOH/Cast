<template>
  <div class="issues-list">
      <!-- <form @submit.prevent="">
            <label>Search By Tag: </label>
            <div id="tag-box">
                <label class="tag" v-for="tag in tags" :key="tag.id" :for="tag.name">{{tag.name + " (" + getNumberOfIssuesForTag(tag.id) + ")"}}
                    <input type="checkbox" :id="tag.name" :value="tag.id" v-model="tagFilter">
                </label>
            </div>
            <button @click="tagFilter = []">Clear All Tags</button>
            <div id="name-description-filter">
                <label id="name-label" for="name">Search By Name: </label>
                <input type="text" id="name" v-model="nameFilter">
                <label id="desc-label" for="desc">Search By Description: </label>
                <input type="text" id="desc" v-model="descFilter">
            </div>
      </form> -->
      <div id="issue-list-box">
          <div id="another-box">
          <issue-overview class="issue" :issue="issue" :active="active" v-for="issue in filteredIssuesList" :key="issue.issue_id"></issue-overview>
          </div>
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
    max-width: 375px;
    margin-right: 0px;
}

    form {
        margin: 0px;
        margin-bottom: 24px;
        height: auto;
    }

    .issue {
        font-size: 1.0rem;
        border-style: solid;
        border-width: 1px;
        border-color: black;
    }

    #tag-box {
        height: 32px;
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
        padding: 8px 16px 0px;
        gap: 40px;

        max-width: 375px;
        height: 521px;
        overflow-y: scroll;


        /* Inside auto layout */

        flex: none;
        order: 4;
        flex-grow: 1;
    }
    #name-description-filter {
        display: grid;
        grid-template-columns: 1fr, 1fr;
        grid-template-areas: "name-label desc-label" "name desc";

    }
    #name {
        grid-area: name;
    }
    #desc {
        grid-area: desc;
    }
    #name-label {
        grid-area: name-label;
    }
    #desc-label {
        grid-area: desc-label;
    }

    #another-box {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 0px;
        gap: 16px;

        width: 343px;
        height: 668px;


        /* Inside auto layout */

        flex: none;
        order: 0;
        align-self: stretch;
        flex-grow: 0;
            }
</style>