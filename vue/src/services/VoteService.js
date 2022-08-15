import axios from 'axios';


export default {

    createVote(vote) {
        return axios.post('/cast', vote);
    }

}