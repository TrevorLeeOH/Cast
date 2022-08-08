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

