<template>
  <div>
      <form @submit.prevent="">
            <label for="tag">Search By Tag: </label>
            <select id="tag" v-model="tagFilter" multiple>
                <option v-for="tag in tags" :key="tag.id" :value="tag.id">{{tag.name}}</option>
            </select>
            <label for="name">Search By Name: </label>
            <input type="text" id="name" v-model="nameFilter">
            <label for="desc">Search By Description: </label>
            <input type="text" id="desc" v-model="descFilter">
      </form>
      <div class="closed-issue" v-for="issue in filteredIssuesList" :key="issue.issue_id">
          <h2>{{issue.name}}</h2>
          <p>{{issue.description}}</p>
          <ul>
              <li v-for="result in issue.results" :key="result.answer">
                  <p>{{result.answer}}</p>
                  <p>{{'Votes: ' + result.votes}}</p>
              </li>
          </ul>
          <span>Tags: </span>
          <span v-for="tagId in issue.tags" :key="tagId">{{tags.find(t => t.id === tagId).name}}</span>
      </div>
  </div>
</template>

<script>
export default {
    props: ['issues', 'tags'],
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
                    return issue.tags.some(tagId => {
                        return this.tagFilter.includes(tagId);
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
}
</script>

<style>
    .closed-issue {
        font-size: 1.0rem;
        border-style: solid;
        border-width: 1px;
        border-color: black;
    }
</style>