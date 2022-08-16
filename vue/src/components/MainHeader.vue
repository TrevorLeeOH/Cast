<template>

  
  <div class="navbar" id="myNavBar">
    
      <!-- <a><img src="..\assets\CAST_logo-02.png" alt="logo"></a> -->
      <router-link class="Tab" v-bind:to="{ name: 'home' }">
        <div class="Fill"><img id="star" src="..\assets\Star Icon.png"></div>
        <span class="Tab-name" tag="li" v-bind:to="{ name: 'home' }"><a> Home </a></span>
      </router-link>
     
     
     <router-link class="Tab" v-bind:to="{ name: 'active-issues' }">
       <div class="Fill"><img id="check_icon" src="..\assets\Check Box Icon.png"></div>
      <span class="Tab-name" tag="li">Vote Now!</span>
     </router-link>
    
    <router-link class="Tab" v-bind:to="{ name: 'closed-issues' }">
      <div class="Fill"><img id="lightning_icon" src="..\assets\Lightning Icon.png"></div>
      <span class="Tab-name" tag="li">Poll Results</span>
    </router-link>
   
    <router-link class="Tab"  v-bind:to="{ name: 'register' }">
      <div class="Fill"><img id="profile_icon" src="..\assets\Profile Icon.png"></div>
      <span class="Tab-name" tag="li">Profile</span>
    </router-link>
    
      <!-- <router-link class="Tab-name" tag="li" v-bind:to="{ name: 'login' }" v-if="$store.state.token = 'true'">Login</router-link>
      <router-link class="Tab-name" tag="li" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'true'">Logout</router-link>
   -->
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
  width: 375px;
  height: 88px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: stretch;
  gap: 4px;
  position: relative;
  bottom: 0px;
  top: 200px;
  padding: 0px;
  opacity: 0.9;
  background-color: #fff;
}

.Tab {
  height: 40px;
  flex: 1;
  min-width: 25%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 6px;
  padding: 0;
  opacity: 0.9;
}

.Tab-name {
  width: 35px;
  height: 14px;
  flex-grow: 0;
  opacity: 0.9;
  font-family: 'museo-sans';
  font-size: 12px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.17;
  letter-spacing: 0.18px;
  text-align: center;
  color: #71727a;
  list-style-type: none;
}

.Fill {
  width: 20px;
  height: 19.1px;
  opacity: 0.9;
  background-color: #fff;
}



.navbar a{
  width: 35px;
  height: 14px;
  flex-grow: 0;
  opacity: 0.9;
  font-family: 'museo-sans';
  font-size: 12px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.17;
  letter-spacing: 0.18px;
  text-align: center;
  color: #71727a;
  text-decoration: none;
  
}
  
/* 
.navbar li{
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 10px;
} */
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

#logo {
  width: 50px;
  height: auto;
}

#star {
   width: 20px;
  height: 20px;
  flex-grow: 0;
  object-fit: contain;
  opacity: 0.9;

}

</style>