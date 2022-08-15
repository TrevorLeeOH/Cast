<template>

  
  <div class="navbar" id="myNavBar">
    
      <a id="logo"><img src="@/assets/CAST_logo-02.png"/></a>
      <router-link tag="li" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link tag="li" v-bind:to="{ name: 'active-issues' }">Vote Now!</router-link>
      <router-link tag="li" v-bind:to="{ name: 'closed-issues' }">Closed Polls</router-link>
      <router-link tag="li" v-bind:to="{ name: 'register' }">Create Account</router-link>
      <router-link tag="li" v-bind:to="{ name: 'login' }" v-if="$store.state.token = 'true'">Login</router-link>
      <router-link tag="li" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'true'">Logout</router-link>
   <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
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

#logo {
  width: 10px;
  height: 10px
}

.navbar {
  background-color: #467BF5;
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
  font-size: 17px;
}
.navbar .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  
  .navbar li {display: none;}
  .navbar .icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .navbar {position: relative;}
  .navbar.responsive li.icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .navbar.responsive li {
    float: none;
    display: block;
    text-align: left;
  }
}

</style>