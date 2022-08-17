<template>
    <div id="issue-box">
        <div id="top-box">
            <p id="issue-title">{{issue.name}}</p>
            <p id="desc">{{issue.description}}</p>
        </div>
        <div id="bottom-box">
            <span id="tags"> 
                <span id="tag" v-for="tag in issue.tagList" :key="tag.tagId">{{tag.tagName + ' '}}</span>
            </span>
            <router-link id="detail-link" :to="{name: 'issue', params: {id: issue.issueId}}" tag="button">{{ issue.userVoted ? 'Results' : 'Vote'}}</router-link>
            <!-- <p id="exp" v-if="active && issue.expiration != null">{{'Closes on ' + formatDate(new Date(issue.expiration))}}</p> -->
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
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 0px;
        width: 343px;
        height: auto;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        box-shadow: 3px 3px 13px 2px rgba(0, 0, 0, 0.09);
        border-radius: 12px;
        flex: none;
        order: 0;
        align-self: stretch;
        flex-grow: 0;
        border: none;
    }

    
    #top-box {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding-left: 16px;
        padding-top: 20px;
        padding-bottom: 20px;
        gap: 16px;
        max-width: 343px;
        max-height: 97px;
        flex: none;
        order: 0;
        align-self: stretch;
        flex-grow: 0;
    }
    
    #detail-link {
        justify-content: center;
        align-items: center;
        align-self: center;
        padding: 12px 16px;
        width: 83px;
        height: 40px;
        background: #467BF5;
        border-radius: 8px;
        margin-right: 10px;
    }
    #desc {
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        line-height: 16px;
        letter-spacing: 0.01em;
        color: #71727A;    
    }

    #bottom-box {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 100%;
        max-height: 58px;
        
        border-bottom-right-radius: 16px;
        border-bottom-left-radius: 16px;
        
        background-color: #fff;
        
    }

    #results {
        grid-area: results;
    }
    #tags {
        margin-left: 8px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        height: 58px;
        border-radius: 16px;
        gap: 4px;
        overflow-x: auto;
        
    }
    #exp {
        grid-area: exp;
        margin: 0px;
    }

    #issue-title {
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 900;
        font-size: 20px;
        line-height: 21px;
        margin: 0px;
        color: #1F2024;
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
    #tag {
        height: 10px;
        text-align: center;
        line-height: 10px;
        padding: 4px 5px;
        border-radius: 12px;
        background-color: #edf2fe;
    }

</style>