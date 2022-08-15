<template>
    <div id="issue-box">
        <div id="issue-image"></div>
        <div class="frame-23">
        <div id="title">
            <h2 id="issue-title">{{issue.name}}</h2>
            <p id="issue-author" :class="{'user-author': $store.state.user.user_id === issue.author.username}">{{'by ' + issue.author.username}}</p>
        </div>
        <router-link id="detail-link" :to="{name: 'issue', params: {id: issue.issueId}}" tag="button">View Issue</router-link>
        <p id="desc">{{issue.description}}</p>
        <div id="tags">
            Tags: 
            <span v-for="tag in issue.tagList" :key="tag.id">{{tag.name + ' '}}</span>
        </div>
        
        <p id="exp" v-if="active && issue.expiration != null">{{'Closes on ' + formatDate(new Date(issue.expiration))}}</p>
    </div>
    </div>
</template>

<script>
export default {
    props: ['issue', 'active'],
    methods: {
        
        formatDate(date) {
            const dateOptions = {
                month: 'short',
                day: 'numeric',
                year: 'numeric',
            }
            return date.toLocaleDateString('en-US', dateOptions);
        }
    }
}
</script>

<style>
    .vote-bar {
        background-color: lightblue;
    }

    .user-vote {
        color: rgb(35, 184, 35);
    }

    #issue-box {
        height: auto;
        width: 263px;
        align-self: center;
        flex-grow: 0;
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        align-items: center;
        padding: 16px;
        border-radius: 16px;
        background-color: #f8f9fe;
        margin-top: 10px;
        margin-left: auto;
        margin-right: auto;
}
    

    #title {
        grid-area: title;
    }
    #detail-link {
        grid-area: detail-link;
    }
    #desc {
        grid-area: desc;
    }
    #results {
        grid-area: results;
    }
    #tags {
        grid-area: tags;
    }
    #exp {
        grid-area: exp;
        margin: 0px;
    }

    #issue-title {
        margin: 0px;
    }
    #issue-author {
        margin: 0px;
    }
    .user-author {
        color: rgb(19, 201, 19);
    }

#issue_image {
  width: auto;
  height: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 10px;
  padding: 40px;
  background-color: #edf2fe;
}
</style>