<template>
    <div id="issue-box">
        <div id="title">
            <h2>{{issue.name}}</h2>
            <router-link :to="{name: 'issue-editor', params: {id: issue.issue_id}}" v-if="$store.state.user.user_id === issue.author.user_id">Edit</router-link>
            <h3>{{'by ' + issue.author.username}}</h3>
        </div>
        <button id="voted" v-if="active && issue.userVote != null" disabled>Voted!</button>
        <button id="voted" v-else-if="active">Cast Vote</button>
        <p id="desc">{{issue.description}}</p>
        <ul id="results">
            <li v-for="(result, index) in issue.results" :key="result.answer">
                <p :class="{ 'user-vote': index === issue.userVote}">{{result.answer}}</p>
                <p v-if="!active || issue.userVote != null">{{'Votes: ' + result.votes}}</p>
                <!--
                <div class="vote-bar" :width="200">{{result.answer + getVotePercentage(result.votes)}}</div>
                -->
            </li>
        </ul>
        <div id="tags">
            Tags: 
            <span v-for="tag in issue.tags" :key="tag.id">{{tag.name + ' '}}</span>
        </div>
        
        <p id="exp" v-if="active">{{'Closes on ' + formatDate(issue.expiration)}}</p>
    </div>
</template>

<script>
export default {
    props: ['issue', 'active'],
    methods: {
        getVotePercentage(votes) {
            let sum = this.issue.results.reduce((prev, curr) => {
                return prev + curr.votes;
            }, 0);
            return votes / sum;
        },
        formatDate(date) {
            const dateOptions = {
                month: 'short',
                day: 'numeric',
                year: 'numeric',
            }
            const timeOptions = {
                hour: '2-digit',
                minute: '2-digit'
            }
            return date.toLocaleDateString('en-US', dateOptions) + " at " + date.toLocaleTimeString('en-US', timeOptions);
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
        grid-template-areas: "title . voted"
                            "desc results results"
                            "tags . exp";
        align-items: center;
    }

    #title {
        grid-area: title;
    }
    #voted {
        grid-area: voted;
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
    }
</style>