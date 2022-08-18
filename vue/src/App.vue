<template>
  <div id="app">
    <header v-if="$store.state.currentTab != 'splash'">
      <img id="header-logo" src="@/assets/CAST_logo-02.png"/>
      <img id="avatar" src="@/assets/Avatar@2x.png"/>
    </header>
    
    <router-view :class="$store.state.currentTab != 'splash' ? 'router' : 'router router-splash'"/>
    
    <main-header></main-header>
      
    
  </div>
</template>

<script>

  import MainHeader from '@/components/MainHeader.vue'

 export default {
   name: "app",
   components: {
     MainHeader
   }
 }

</script>

<style>
@import url('https://use.typekit.net/ows0uho.css');

header {
  max-width: 375px;
  height: 60px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin: 8px 0px 0.5px 0;
  padding: 16px;
  border: solid 1px #e8e9f1;
  background-color: #fff;
  border-top: none;
  border-radius: 12px;
 
}

#app {
  justify-self: center;
  flex-direction: column;
  justify-content: space-between;
  height: 812px;
  width: 375px;
  border-radius: 12px;
  border: solid 1px #202858; 
}



.router {
  height: 627px;
  overflow-y: hidden;
  width: 375px;
  max-width: 375px;
}
.router-splash {
  height: 729px;
}

.Title {
  height: 15px;
  font-family: 'museo-sans';
  font-size: 12px;
  font-weight: bold;
  color: #2f3036;
  padding-top: 5px;
}

button {
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: bold;
  color: #fff;
  background-color: #467bf5;
  border: none;
}

.form-control {
  height: 48px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  gap: 8px;
  padding: 12px 16px;
  border-radius: 12px;
  border: solid 1px #c5c6cc;
}
</style>

