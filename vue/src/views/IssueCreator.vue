<template>
  <form v-on:submit.prevent="">
        <label for="name">Issue Name: </label>
        <input type="text" id="name" v-model="issue.name">
        <label for="desc">Issue Description: </label>
        <textarea id="desc" cols="30" rows="10" v-model="issue.description"></textarea>
        <label for="exp">Issue Expires: </label>
        <input type="date" id="exp" v-model="issue.expiration">

        
        <div>
            <h3>Options:</h3>
            <div v-for="(option, index) in issue.options" :key="index">
                <input size="100" type="text" v-model="issue.options[index]">
                <button @click="removeOption(index)">x</button>
            </div>
            <button v-if="issue.options.length < 8" @click="addOption">Add Option</button>
        </div>

        <h3>Tags:</h3>
        <div id="tag-box">
            <label class="tag" v-for="tag in tags" :key="tag.id" :for="tag.name">{{tag.name}} 
                <input type="checkbox" :id="tag.name" :value="tag" v-model="issue.tags">
            </label>
            <div v-for="(tag, index) in issue.newTags" :key="index">
                <label class="tag"  :for="tag"></label>
                <input :id="tag" type="text" v-model="issue.newTags[index]">
                <button @click="removeTag(index)">x</button>
            </div>
            <button @click="addTag()">Add Tag</button>
        </div>
        <button type="submit" @click="saveChanges">Submit Issue</button>
        
    </form>
</template>

<script>
import IssueService from '@/services/IssueService.js';
import TagService from '@/services/TagService.js';

export default {

    data() {
        return {
            issue: {
                name: '',
                description: '',
                expiration: '',
                options: [],
                tags: [],
                newTags: []
            },
            tags: [],
            
        }
    },
    methods: {
        addOption() {
            this.issue.options.push('');
        },
        removeOption(index) {
            this.issue.options.splice(index, 1);
        },
        addTag() {
            this.issue.newTags.push('');
        },
        removeTag(index) {
            this.issue.newTags.splice(index, 1);
        },
        submitIssue() {
            IssueService.createIssue(this.issue).then(response => {
                if (response.status == 200) {
                    alert('Issue Saved!');
                } else {
                    alert('Failed to save! - response status: ' + response.status);
                }
            })
        },
        
        getTags() {
            this.tags = TagService.getTags();
        },
    },
    created() {
        this.getTags();
        this.issue.userId = this.$store.state.user.id;
    }

}
</script>

<style>
    
</style>