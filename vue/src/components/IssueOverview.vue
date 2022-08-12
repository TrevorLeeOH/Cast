<template>
    <div id="issue-box">
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
        display: grid;
        grid-template-columns: 1fr 3fr 1fr;
        grid-template-areas: "title desc detail-link"
                            "tags tags exp";
        align-items: center;
        padding: 6px;
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
</style>