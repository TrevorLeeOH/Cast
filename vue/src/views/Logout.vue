<template>
  <div id="logout-page">
    <div id="profile-box">
      <p id="current-profile-prompt">You are currently logged in as:</p>
      <img id="profile-image" src="@/assets/Avatar.png" alt="">
      <h1 id="profile-name">{{$store.state.user.username}}</h1>
    </div>

    <button id="logout-button" @click="logOut">Log Out</button>





  </div>
</template>

<script>
export default {


  methods: {
    logOut() {
      this.$store.commit("LOGOUT");
      this.$router.push("/login");
    }
  }

  
};
</script>

<style scoped>
  #logout-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
  }
  #logout-button {
    margin-bottom: 20px;
    background: none;
    color: red;
    text-decoration: underline;
  }
  #profile-box {
    display: flex;
    flex-direction: column;
    gap: 12px;
    align-items: center;
  }
  #profile-name {
    margin: 0px;
    font-family: 'museo-sans';
    font-weight: 900;
    font-size: 32px;
    line-height: 19px;
    text-align: center;
    color: #1F2024;
  }
  
  #current-profile-prompt {
    font-family: 'museo-sans';
    font-style: normal;
    font-weight: 800;
    font-size: 14px;
    line-height: 17px;
    margin-bottom: 0px;
    text-align: center;

    color: #1F2024;
  }
</style>