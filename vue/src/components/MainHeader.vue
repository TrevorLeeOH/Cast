<template>

  
  <div class="navbar" id="myNavBar">
    
      <a><img src="..\assets\CAST_logo-02.png" alt="logo"></a>
      <router-link tag="li" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link tag="li" v-bind:to="{ name: 'active-issues' }">Vote Now!</router-link>
      <router-link tag="li" v-bind:to="{ name: 'closed-issues' }">Closed Polls</router-link>
      <router-link tag="li" v-bind:to="{ name: 'register' }">Create Account</router-link>
      <router-link tag="li" v-bind:to="{ name: 'login' }" v-if="$store.state.token = 'true'">Login</router-link>
      <router-link tag="li" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'true'">Logout</router-link>
  </div>
</template>

<script>
export default {


methods: { 
  myFunction() {
  var x = document.getElementById("myNavbar");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
  // var x = document.getElementById("myNavbar");
  // if (x.className === "navbar") {
  //   x.className += "responsive";
  // } else {
  //   x.className = "navbar";
  // }
}
}
}
</script>

<style>

.navbar {
  display: flex;
  background-color: #000000;
  overflow: hidden;
}

.navbar a{
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar li{
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 10px;
}
.navbar .icon {
  display: none;
}

/* @media screen and (max-width: 600px) {
  
  .navbar li {display: none;}
  .navbar .icon {
    float: right;
    display: block;
  }
} */

/* @media screen and (max-width: 600px) {
  .navbar {position: relative;}
  .navbar.responsive img {
    position: absolute;
    right: 0;
    top: 0;
  }
  .navbar.responsive li {
    display: flex;
    flex-direction: column;
    text-align: left;
  }
} */

img {
  width: 50px;
  height: auto;
}

</style>