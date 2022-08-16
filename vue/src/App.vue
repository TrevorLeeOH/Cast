<template>
  <div id="app">
    <router-view />
    <div id="nav">
      <main-header>
        
      </main-header>
      
    </div>
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
 margin: auto;
  height: 812px;
  width: 375px;
  border-radius: 12px;
  border: solid 1px #202858;
  overflow-y: auto;
}
</style>

