<template>
  <div>
      <h2>Cast✓</h2>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'active-issues' }">Vote Now!</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'closed-issues' }">Closed Polls</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'register' }">Create Account</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token = 'true'">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'true'">Logout</router-link> &nbsp;|&nbsp;
  </div>
</template>

<script>

</script>

<style>

</style>