<template>
  <div>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'active-issues' }">Active Polls</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'closed-issues' }">Closed Polls</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'home' }">Create Account</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token = 'true'">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != 'true'">Logout</router-link> &nbsp;|&nbsp;
  </div>
</template>

<script>

</script>

<style>

</style>