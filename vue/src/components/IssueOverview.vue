<template>
    <div id="issue-box">
        <div id="top-box">
            <p id="issue-title">{{issue.name}}</p>
            <p id="issue-desc">{{issue.description}}</p>
        </div>
        <div id="bottom-box">
            <span id="tags">
                <div id="tag" v-for="tag in issue.tagList" :key="tag.tagId">
                    <div id="tag-icon"></div>
                    <p id="tag-text">{{tag.tagName}}</p>
                </div>
            </span>
            <router-link id="detail-link" :to="{name: 'issue', params: {id: issue.issueId}}" tag="button">
                <p id="detail-link-text">Vote</p>
                <img id="detail-link-icon" src="@/assets/VoteButtonIcon.png" alt="">
                
            </router-link>
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
        padding-right: 16px;
        padding-top: 20px;
        padding-bottom: 20px;
        gap: 4px;
        width: 311px;
        height: 41px;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        
    }
    #bottom-box {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        width: 343px;
        height: 58px;
        
        border-bottom-right-radius: 16px;
        border-bottom-left-radius: 16px;
        
        background-color: #fff;
        
    }
    
    #detail-link {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        padding: 12px 16px;
        gap: 8px;
        width: 83px;
        height: 40px;
        background: #467BF5;
        border-radius: 8px;
        margin-right: 10px;
    }
    #detail-link-text {
        width: 31px;
        height: 17px;
        font-family: 'museo-sans';
        font-weight: 500;
        font-size: 14px;
        line-height: 17px;
        color: #FFFFFF;
        margin: 0px;
    }
    #detail-link-icon {
        width: 12px;
        height: 12px;
        
    }


    #issue-title {
        width: 311px;
        height: 21px;
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 900;
        font-size: 18px;
        line-height: 21px;
        letter-spacing: 0.005em;
        margin: 0px;
        color: #1F2024;
    }

    #issue-desc {
        width: 311px;
        height: 32px;
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        line-height: 16px;
        letter-spacing: 0.01em;
        color: #71727A;
        text-overflow: ellipsis;
        overflow-x: hidden;
        margin: 0px;
        white-space: nowrap;
        
    }

    

    #results {
        grid-area: results;
    }
    
    #exp {
        grid-area: exp;
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
    #tags {
        margin-left: 8px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        height: 58px;
        border-radius: 16px;
        gap: 4px;
        overflow-x: scroll;
        
    }
    #tag {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        gap: 4px;
        padding: 4px 5px;
        height: 20px;
        background: linear-gradient(0deg, rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)), #467BF5;
        border-radius: 12px;
    }
    #tag-icon {
        width: 12px;
        height: 12px;
        background-color: #467BF5;
        border-radius: 6px;
    }
    #tag-text {
        font-family: 'museo-sans';
        font-weight: 600;
        font-size: 10px;
        line-height: 12px;
        text-align: center;
        letter-spacing: 0.05em;
        text-transform: uppercase;
        color: #467BF5;
    }

</style>