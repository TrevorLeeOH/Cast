<template>
  <div id="app">
    
    <router-view class="router"/>
    
      <main-header class="bottom-menu">
      </main-header>
      
    
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

#app {

  flex-direction: column;
  justify-content: space-between;
  margin: auto;
  height: 812px;
  width: 375px;
  border-radius: 12px;
  border: solid 1px #202858;
  gap: 10px;
 
}

.bottom-menu {
  width: 360px;

}

.router {
  height: 730px;
  max-height: 730px;
   overflow-y: auto;

}
</style>

