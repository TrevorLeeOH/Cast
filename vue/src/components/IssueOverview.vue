<template>
    <div id="issue-box">
        <div id="top-box">
            <div id="content">
                <div id="title">
                    <p id="issue-title">{{issue.name}}</p>
                    <!-- <p id="issue-author" :class="{'user-author': $store.state.user.user_id === issue.author.username}">{{'by ' + issue.author.username}}</p> -->
                </div>
                <p id="desc">{{issue.description}}</p>
            </div>
        </div>
        <div id="bottom-box">
             <div id="tags"> 
                 <div id="tag">
                    <span v-for="tag in issue.tagList" :key="tag.id">{{tag.name + ' '}}</span>
                 </div>
                 <router-link id="detail-link" :to="{name: 'issue', params: {id: issue.issueId}}" tag="button">Vote</router-link>
            </div>
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
        flex-direction: row;
        align-items: center;
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

    #content {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        padding: 0px;
        gap: 4px;
        width: 311px;
        height: 57px;
        flex: none;
        order: 0;
        align-self: stretch;
        flex-grow: 1;
    }

    #title {
        width: 311px;
        height: 21px;

        /* Heading/H2 */

        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 900;
        font-size: 20px;
        line-height: 21px;
        /* identical to box height, or 117% */

        letter-spacing: 0.005em;

        /* Neutral/Dark/Darkest */

        color: #1F2024;


        /* Inside auto layout */

        flex: none;
        order: 0;
        align-self: stretch;
        flex-grow: 0;
    }
    #detail-link {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        align-self: center;
        padding: 12px 16px;
        gap: 8px;

        width: 83px;
        height: 40px;

        /* Highlight/Darkest */

        background: #467BF5;
        border-radius: 8px;

        /* Inside auto layout */

        flex: none;
        order: 1;
        flex-grow: 0;
        
        }
    #desc {
    
        width: 311px;
        height: 32px;
        font-family: 'museo-sans';
        font-style: normal;
        font-weight: 400;
        font-size: 14px;
        line-height: 16px;
        letter-spacing: 0.01em;
        color: #71727A;
        flex: none;
        order: 1;
        align-self: stretch;
        flex-grow: 0;
        overflow: hidden;
        }

    #bottom-box {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: flex-start;
        max-width: 343px;
        max-height: 58px;
        border-radius: 16px;
        border-top-left-radius: 0px;
        border-top-right-radius: 0px;
        flex: none;
        order: 1;
        align-self: stretch;
        flex-grow: 0;
        background-color: #fff;
        
    }

    #results {
        grid-area: results;
    }
    #tags {
        display: flex;
        flex-direction: row;
        justify-content: center;
        gap: 160px;
        align-items: center;
        width: 343px;
        height: 58px;
        border-radius: 16px;
        flex: none;
        order: 1;
        align-self: stretch;
        flex-grow: 0;
        
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
#tag {
width: 55px;
  height: 10px;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  padding: 4px 5px;
  border-radius: 12px;
  background-color: #edf2fe;
  align-self: flex-start;
  margin-top: 8px;
}

</style>