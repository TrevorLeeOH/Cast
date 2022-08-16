<template>
  <form id="create-issue-form" v-on:submit.prevent="">
        <div id="name-desc-exp-inputs">
            <label class="Title" for="name">Issue Name: </label>
            <input class="form-control" type="text" id="name" v-model="issue.name">
            <label class="Title" for="desc">Issue Description: </label>
            <textarea class="form-control" id="desc" cols="30" rows="10" v-model="issue.description"></textarea>
            <label class="Title" for="exp">Issue Expires: </label>
            <input type="date" id="exp" v-model="issue.expiration"> 
        </div>
        

        
        <div id="options-form-list">
            <h3>Options:</h3>
            <div class="option-field" v-for="(option, index) in issue.options" :key="index">
                <input class="option-input" type="text" v-model="issue.options[index]">
                <button @click="removeOption(index)">x</button>
            </div>
            <button v-if="issue.options.length < 8" @click="addOption">Add Option</button>
        </div>

        <h3>Tags:</h3>
        <div id="tag-box">
            <label class="tag" v-for="tag in tags" :key="tag.id" :for="tag.name">{{tag.name}} 
                <input type="checkbox" :id="tag.name" :value="tag" v-model="issue.tags">
            </label>
            <div id="new-tag-box">
                <div class="new-tag-field" v-for="(tag, index) in issue.newTags" :key="index">
                    <label class="tag"  :for="tag"></label>
                    <input :id="tag" type="text" v-model="issue.newTags[index]">
                    <button @click="removeTag(index)">x</button>
                </div>
            </div>
            
            <button @click="addTag()">Add Tag</button>
        </div>
        <button type="submit" @click="submitIssue">Submit Issue</button>
        
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
    #create-issue-form {
        display: flex;
        height: 666px;
        padding: 12px;
        overflow-y: auto;
    }
    #name-desc-exp-inputs {
        display: flex;
        flex-direction: column;
        gap: 4px;
        width: 100%;
    }
    .option-field {
        display: flex;
        flex-direction: row;
    }
    .option-input {
        width: 308px;
    }
    #options-form-list {
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
    }
</style>