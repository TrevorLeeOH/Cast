<template>
    <div id="create-issue-box">
        <form id="create-issue-form" v-on:submit.prevent="">
            <h1 id="create-issue-header">Create Issue</h1>
            <div id="name-desc-exp-inputs">
                <label class="edit-title" for="name-input">Issue Name: </label>
                <input class="form-control" type="text" id="name-input" v-model="issue.name">
                <label class="edit-title" for="desc-input">Issue Description: </label>
                <textarea class="form-control" id="desc-input" cols="30" rows="10" v-model="issue.description"></textarea>
                <label class="edit-title" for="exp-input">Issue Expires: </label>
                <input type="date" class="form-control" id="exp-input" v-model="issue.expiration"> 
            </div>
            <div id="options-form-list">
                <h3 class="edit-title">Options:</h3>
                <div class="option-field" v-for="(option, index) in issue.options" :key="index">
                    <input class="form-control option-input" type="text" v-model="issue.options[index]">
                    <button class="x-button" @click="removeOption(index)">x</button>
                </div>
                <button id="add-option-button" v-if="issue.options.length < 8" @click="addOption">Add Option</button>
            </div>
            <div id="tag-form-list">
                <h3 class="edit-title">Tags:</h3>
                <div id="tag-list">
                    <label class="tag" v-for="tag in tags" :key="tag.tagId" :for="tag.tagName">{{tag.tagName}} 
                        <input type="checkbox" :id="tag.tagName" :value="tag" v-model="issue.tags">
                    </label>
                </div>
                <div id="new-tag-box">
                    <div class="new-tag-field" v-for="(tag, index) in issue.newTags" :key="index">
                        <label class="tag"  :for="tag"></label>
                        <input :id="tag" class="form-control tag-input" type="text" v-model="issue.newTags[index]">
                        <button class="x-button" @click="removeTag(index)">x</button>
                    </div>
                </div>
                <button id="add-tag-button" @click="addTag()">Add Tag</button>
            </div>
            <button id="submit-issue-button" type="submit" @click="submitIssue">Submit Issue</button>
            
        </form>
    </div>
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
            let tags = this.issue.tags;
            this.issue.newTags.forEach(tag => {
                tags.push(
                    {
                        tagId: -1,
                        tagName: tag
                    }
                );
            });

            let issueToSave = {
                userId: this.$store.state.user.id,
                name: this.issue.name,
                description: this.issue.description,
                expiration: this.issue.expiration,
                optionA: this.issue.options[0],
                optionB: this.issue.options[1],
                optionC: this.issue.options[2],
                optionD: this.issue.options.length > 3 ? this.issue.options[3] : null,
                optionE: this.issue.options.length > 4 ? this.issue.options[4] : null,
                optionF: this.issue.options.length > 5 ? this.issue.options[5] : null,
                optionG: this.issue.options.length > 6 ? this.issue.options[6] : null,
                optionH: this.issue.options.length > 7 ? this.issue.options[7] : null,
                tags: tags
            }

            
            IssueService.createIssue(issueToSave).then(response => {
                if (response.status == 200) {
                    alert('Issue Saved!');
                    this.issue = {
                        name: '',
                        description: '',
                        expiration: '',
                        options: [],
                        tags: [],
                        newTags: []
                    }
                } else {
                    alert('Failed to save! - response status: ' + response.status);
                }
            })
        },
        
        getTags() {
            TagService.getTags().then(response => {
               if (response.status == 200) {
                   this.tags = response.data;
               }
           });
        },
    },
    created() {
        this.getTags();
        this.issue.userId = this.$store.state.user.id;
    }

}
</script>

<style>
    #create-issue-box {
        overflow-y: auto;       
    }
    #create-issue-form {
        display: flex;
        flex-direction: column;
        height: 666px;
        padding: 12px;
        gap: 6px;
    }
    #create-issue-header {
        display: flex;
        font-family: 'museo-sans';
        justify-content: center;
        font-weight: 900;
    }
    #name-desc-exp-inputs {
        display: flex;
        flex-direction: column;
        gap: 6px;
        width: 100%;
    }
    .option-field {
        display: flex;
        flex-direction: row;
        align-items: center;
    }
    #options-form-list {
        display: flex;
        flex-direction: column;
        gap: 6px;
    }
    #tag-form-list {
        display: flex;
        flex-direction: column;
        gap: 6px;
    }
    #new-tag-box {
        display: flex;
        flex-direction: column;
        gap: 6px;
    }
    .new-tag-field {
        display: flex;
        flex-direction: row;
        align-items: center;
    }
    .edit-title {
        font-family: 'museo-sans';
        font-size: 16px;
        font-weight: 700;
        margin: 0px;
    }
    #name-input {
        font-family: 'museo-sans';
        height: 20px;
        margin: 10px;
        width: 300px;
    }
    #desc-input {
        font-family: 'museo-sans';
        height: 100px;
        margin: 10px;
        width: 300px;
    }
    #exp-input {
        font-family: 'museo-sans';
        height: 20px;
        margin: 10px;
        width: 300px;
    }
    .option-input {
        font-family: 'museo-sans';
        height: 10px;
        margin-left: 10px;
        margin-right: 10px;
        width: 300px;
    }
    #add-option-button {
        align-self: center;
        border-radius: 8px;
        width: 200px;
    }
    .tag-input {
        font-family: 'museo-sans';
        height: 0px;
        margin-left: 10px;
        margin-right: 10px;
        width: 100px;
    }
    .x-button { /* please make this look better than it does now haha */
        border-radius: 4px;
        height: px;
        background: none;
        border: 1px solid gray;
        color: red;
    }
    #add-tag-button {
        align-self: center;
        border-radius: 8px;
        width: 200px;
    }
    #submit-issue-button {
        border-radius: 8px;
        width: 327px;
        height: 48px;
        margin-top: 16px;
    }
</style>