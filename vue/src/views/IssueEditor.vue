<template>
  <div>
      <h1 class="edit-issue">Edit Issue</h1>
        <form id="issue-edit-form" v-on:submit.prevent="saveChanges">
            <label class="edit-title" for="name">Issue Name: </label>
            <input class="form-control" type="text" id="edit-name" v-model="issue.name">
            <label class="edit-title" for="desc">Issue Description: </label>
            <textarea class="form-control" id="edit-desc" cols="30" rows="10" v-model="issue.description"></textarea>
            <label class="edit-title" for="exp">Issue Expires: </label>
            <input class="form-control" type="date" id="edit-exp" v-model="issue.expiration">
            <h3 class="tag-header">Tags:</h3>
            <div id="tag-box">
                <label class="tag" v-for="tag in tags" :key="tag.tagId" :for="tag.tagName"> <input type="checkbox" :id="tag.tagName" :value="tag" v-model="issue.tagList"> {{tag.tagName}} 
                    <!-- <input type="checkbox" :id="tag.tagName" :value="tag" v-model="issue.tagList"> -->
                </label>
            </div>
            <button class="Button-Primary" type="submit">Save Changes</button>
            <button v-if="$store.state.user.authorities.some(role => role.name == 'ROLE_ADMIN')" @click="deleteIssue">Delete Issue</button>    
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
            tags: []
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
            TagService.getTags().then(response => {
               if (response.status == 200) {
                   this.tags = response.data;
               }
           });
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
                optionH: this.issue.optionList.length > 7 ? this.issue.optionList[7] : null,
                tags: this.issue.tagList
            };         
            IssueService.updateIssue(issueToSave).then(response => {
                if (response.status == 200) {
                    alert('Issue Saved!');
                } else {
                    alert('Failed to save! - response status: ' + response.status);
                }
            });
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
        this.getTags();
    }
}
</script>

<style scoped>

.edit-issue {
    display: flex;
    font-family: 'museo-sans';
    justify-content: center;
    font-weight: 900;
}

    #issue-edit-form {
        padding: 10px;
    }
    #desc {
        height: 300px;
    }

    .edit-title {
        font-family: 'museo-sans';
        font-size: 20;
        font-weight: 700;
        
    }

    #edit-name {
        height: 20px;
        margin: 10px;
        width: 300px;
    }

    #edit-desc {
        height: 100px;
        font-family: 'museo-sans';
        margin: 10px;
        width: 300px;
    }

    #edit-exp {
        height: 15px;
        font-family: 'museo-sans';
        margin: 10px;
        width: 300px;
    }

    .tag-header {
         font-family: 'museo-sans';
        font-size: 15;
        font-weight: 700;
    }



</style>