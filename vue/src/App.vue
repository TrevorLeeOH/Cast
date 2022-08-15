<template>
  <div id="app">
    <div id="nav">
      <main-header>
        
      </main-header>
      
    </div>
    <router-view />
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
 border-radius: 12px;
  border: solid 1px #202858;
}
</style>

