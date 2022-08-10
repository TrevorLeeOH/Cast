<template>
  <div>
        <form v-on:submit.prevent="saveChanges">
            <label for="name">Issue Name: </label>
            <input type="text" id="name" v-model="issue.name">
            <label for="desc">Issue Description: </label>
            <textarea id="desc" cols="30" rows="10" v-model="issue.description"></textarea>
            <label for="exp">Issue Expires: </label>
            <input type="datetime-local" id="exp" v-model="expDate">
            <h3>Tags:</h3>
            <div id="tag-box">
                <label class="tag" v-for="tag in getTags()" :key="tag.id" :for="tag.name">{{tag.name}} 
                    <input type="checkbox" :id="tag.name" :value="tag" v-model="issue.tags">
                </label>
            </div>
            <button type="submit">Save Changes</button>
            <button @click="deleteIssue">Delete Issue</button>
            
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
            expDate: ""
        }
    },
    methods: {
        getIssue() {
            return IssueService.getIssue(this.$route.params.id);
        },
        getTags() {
            return TagService.getTags();
        },
        saveChanges() {
            this.issue.expiration = new Date(this.expDate); //seems to be adding four hours to the time for some reason....
            if (IssueService.updateIssue(this.issue)) {
                alert('Issue Saved!');
            } else {
                alert('Issue failed to save!');
            }
        },
        deleteIssue(event) {
            event.preventDefault();
            if (IssueService.deleteIssue(this.issue.issue_id)) {
                alert('Issue Deleted');
            } else {
                alert('Issue failed to be deleted');
            }
        }
    },
    created() {
        this.issue = this.getIssue();
        this.expDate = this.issue.expiration.toISOString().substring(0, 16)
    }
}
</script>

<style>

</style>