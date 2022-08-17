<template>
  <div class="issues-list">
      <form id="issue-search-form" @submit.prevent="">
            <div id="filter" @click="showTagFilter = !showTagFilter">
                <img id="filter-icon" src="@/assets/Filter Icon.png" alt="">
                <p id="filter-title">Filter</p>
            </div>                
            <div id="tag-filter" v-if="showTagFilter">
                <button id="clear-tags" @click="tagFilter = []">Clear All</button>
                <div id="tag-list">
                    <label class="tag" v-for="tag in tags" :key="tag.tagId" :for="tag.tagName">{{tag.tagName + " (" + getNumberOfIssuesForTag(tag.tagId) + ")"}}
                        <input type="checkbox" :id="tag.tagName" :value="tag.tagId" v-model="tagFilter">
                    </label>
                </div>
            </div>
            
            <div id="name-description-filter">
                <label class="Title" id="name-label" for="name">Search By Name: </label>
                <input type="text" id="name" v-model="nameFilter">
                <label class="Title" id="desc-label" for="desc">Search By Description: </label>
                <input type="text" id="desc" v-model="descFilter">
            </div>
      </form>
      <div id="issue-list-box">
          <issue-overview :issue="issue" :active="active" v-for="issue in filteredIssuesList" :key="issue.issue_id"></issue-overview>
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
            tagFilter: [],
            showTagFilter: false
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
                if (curr.tagList.some(t => t.tagId === tagId)) {
                    sum += 1;
                }
                return sum;
            }, 0);
        }
    }
}
</script>

<style scoped>

    #issue-search-form {
        padding: 16px;
    }

    .issues-list {
        height: 100%;
        width: 100%;
    }

    #tag-list {
        
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-self: center;
        gap: 6px;
        overflow-x: auto;
        overflow-y: hidden;
        white-space: nowrap;
    }
    
    #issue-list-box {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 16px;
        gap: 16px;
        height: 75%;
        overflow-y: scroll;
        overflow-x: hidden;
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
    #clear-tags {
        border-radius: 8px;
        background: none;
        color: rgb(32, 120, 221);
        text-decoration: underline;
    }
    #tag-filter {
        display: flex;
        flex-direction: row;
        align-items: center;
        white-space: nowrap;
        border: 1px solid blue;
        border-radius: 12px;
    }
    #search-by-tag {
        display: flex;
        flex-direction: row;
        background: none;
        color: black;
        align-items: center;
        border-radius: 8px;
        border: 0.5px solid #C5C6CC;
        border-radius: 12px;
    }
    
    #filter {
        width: 50px;
        height: 20px;
        flex-grow: 0;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        gap: 12px;
        padding: 8px 12px;
        border-radius: 12px;
        border: solid 0.5px; color: #c5c6cc;
    }

    #filter-icon {
        width: 12px;
        height: 12px;
        flex-grow: 0;
        object-fit: contain;
    }

    #filter-title {
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