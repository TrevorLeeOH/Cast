<template>
  <div>
        <form v-on:submit.prevent="saveChanges">
            <label for="name">Issue Name: </label>
            <input type="text" id="name" v-model="issue.name">
            <label for="desc">Issue Description: </label>
            <textarea id="desc" cols="30" rows="10" v-model="issue.description"></textarea>
            <label for="exp">Issue Expires: </label>
            <input type="date" id="exp" v-model="issue.expiration">
            <h3>Tags:</h3>
            <div id="tag-box">
                <label class="tag" v-for="tag in getTags()" :key="tag.id" :for="tag.name">{{tag.name}} 
                    <input type="checkbox" :id="tag.name" :value="tag" v-model="issue.tags">
                </label>
            </div>
            <button class="Button-Primary" type="submit">Save Changes</button>
            <button class="Button-Primary" v-if="$store.state.user.authorities.some(role => role.name == 'ROLE_ADMIN')" @click="deleteIssue">Delete Issue</button>    
        </form>
        
    </div>
</template>

<script>
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {
    data() {
        return {
            issue: {},
        }
    },
    methods: {
        getIssue() {
            IssueService.getIssue(this.$route.params.id).then(response => {
                if (response.status == 200) {
                    this.issue = response.data;
                } else {
                    alert("Failed to load issue");
                }
            });
        },
        getTags() {
            return TagService.getTags();
        },
        saveChanges() {
            let issueToSave = {
                issueId: this.issue.issueId,
                userId: this.issue.author.id,
                name: this.issue.name,
                description: this.issue.description,
                expiration: this.issue.expiration,
                optionA: this.issue.optionList[0],
                optionB: this.issue.optionList[1],
                optionC: this.issue.optionList[2],
                optionD: this.issue.optionList.length > 3 ? this.issue.optionList[3] : null,
                optionE: this.issue.optionList.length > 4 ? this.issue.optionList[4] : null,
                optionF: this.issue.optionList.length > 5 ? this.issue.optionList[5] : null,
                optionG: this.issue.optionList.length > 6 ? this.issue.optionList[6] : null,
                optionH: this.issue.optionList.length > 7 ? this.issue.optionList[7] : null
            };         
            IssueService.updateIssue(issueToSave).then(response => {
                if (response.status == 200) {
                    alert('Issue Saved!');
                } else {
                    alert('Failed to save! - response status: ' + response.status);
                }
            })
        },
        deleteIssue(event) {
            event.preventDefault();
            IssueService.deleteIssue(this.issue.issueId).then(response => {
                if (response.status === 200) {
                    alert("Issue Deleted!")
                    this.$router.push({name: 'home'});
                } else {
                    alert("Issue Failed To Be Deleted!");
                }
            })
        }
    },
    created() {
        this.getIssue();
    }
}
</script>

<style>

</style>