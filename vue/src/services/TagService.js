//import axios from 'axios';

const tags = [
    {
        id: 1,
        name: 'crimes'
    },
    {
        id: 2,
        name: 'food'
    },
    {
        id: 3,
        name: 'environment'
    }
]

export default {
    getTags() {
        return tags;
    }
}