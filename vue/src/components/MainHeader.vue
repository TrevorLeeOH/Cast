<template>

  
  <div class="navbar" id="myNavBar">
    
    <router-link v-if="$store.state.currentTab === 'home'" class="Tab" :to="{ name: 'home' }">
      <div class="Fill"><img id="star" src="@/assets/StarIconSelected.png"></div>
      <p class="Tab-name Tab-name-selected" tag="li">Home</p>
    </router-link>
    <router-link v-else class="Tab" v-bind:to="{ name: 'home' }">
      <div class="Fill"><img id="star" src="@/assets/StarIcon.png"></div>
      <p class="Tab-name" tag="li">Home</p>
    </router-link>

    <router-link v-if="$store.state.currentTab === 'active-issues'" class="Tab" :to="{ name: 'active-issues'}">
      <div class="Fill"><img id="star" src="@/assets/CheckBoxIconSelected.png"></div>
      <p class="Tab-name Tab-name-selected" tag="li">Vote Now!</p>
    </router-link>
    <router-link v-else class="Tab" v-bind:to="{ name: 'active-issues' }">
      <div class="Fill"><img id="star" src="@/assets/CheckBoxIcon.png"></div>
      <p class="Tab-name" tag="li">Vote Now!</p>
    </router-link>

    <router-link v-if="$store.state.currentTab === 'closed-issues'" class="Tab" :to="{ name: 'closed-issues'}">
      <div class="Fill"><img id="star" src="@/assets/LightningIconSelected.png"></div>
      <p class="Tab-name Tab-name-selected" tag="li">Poll Results</p>
    </router-link>
    <router-link v-else class="Tab" v-bind:to="{ name: 'closed-issues' }">
      <div class="Fill"><img id="star" src="@/assets/LightningIcon.png"></div>
      <p class="Tab-name" tag="li">Poll Results</p>
    </router-link>

    <router-link v-if="$store.state.currentTab === 'logout' || $store.state.currentTab === 'login'" class="Tab" :to="{ name: ($store.state.token ? 'logout' : 'login') }">
      <div class="Fill"><img id="star" src="@/assets/ProfileIconSelected.png"></div>
      <p class="Tab-name Tab-name-selected" tag="li">{{$store.state.token ? 'Logout' : 'Login'}}</p>
    </router-link>
    <router-link v-else class="Tab" v-bind:to="{ name: ($store.state.token ? 'logout' : 'login') }">
      <div class="Fill"><img id="star" src="@/assets/ProfileIcon.png"></div>
      <p class="Tab-name" tag="li">{{$store.state.token ? 'Logout' : 'Login'}}</p>
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
    }
    
    // var x = document.getElementById("myNavbar");
    // if (x.className === "navbar") {
    //   x.className += "responsive";
    // } else {
    //   x.className = "navbar";
    // }
  }
}
</script>

<style>

.navbar {
  width: 375px;
  height: 58px;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  padding-top: 24px;
  background-color: #fff;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
  box-shadow: 3px -3px 13px 2px rgba(0, 0, 0, 0.09);
}

.Tab {
  
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 6px;
  padding: 0;
  opacity: 0.9;
}

.Tab-name {
  height: 14px;
  opacity: 0.9;
  font-family: 'museo-sans';
  font-size: 12px;
  font-weight: 500;
  line-height: 14px;
  letter-spacing: 0.18px;
  white-space: nowrap;
  text-align: center;
  color: #71727a;
  margin: 0px;
}
.Tab-name-selected {
  font-weight: 600;
  color: #1F2024;
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