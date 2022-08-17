<template>
  <div id="login" class="text-center">
    <form id="login-form" @submit.prevent="login">
      <h1 id="login-header">Welcome!</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="user-pass-frame">
        <input type="text" class="user-pass-input" placeholder="Username" v-model="user.username" required autofocus/>
      </div>
      <div class="user-pass-frame">
        <input type="password" class="user-pass-input" placeholder="Password" v-model="user.password" required/>
      </div>
      
      <router-link id="register-link" :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit" id="sign-in-button">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({name: 'home'});
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
  #login-header {
    font-family: 'museo-sans';
    font-style: normal;
    font-weight: 1000;
    font-size: 24px;
    line-height: 29px;
    align-items: center;
    letter-spacing: 0.02em;
    color: #000000;
  }
  #login-form {
    display: flex;
    flex-direction: column;
    gap: 24px;
    padding: 40px 24px;
    

  }
  .user-pass-frame {
    display: flex;
    align-items: center;
    height: 48px;
    color: #8F9098;
    border: 1px solid #C5C6CC;
    border-radius: 12px;
    padding-left: 12px;
  }
  .user-pass-input {
    font-family: 'museo-sans';
    font-weight: 400;
    font-size: 18px;
    line-height: 18px;
    border: none;
    width: 290px;
  }
  #register-link {
    font-family: 'museo-sans';
    font-weight: 600;
    font-size: 14px;
    line-height: 17px;
    text-decoration: none;
    color: #467BF5;
  }

  #sign-in-button {
    border-radius: 8px;
    font-family: 'museo-sans';
    font-style: normal;
    font-weight: 600;
    font-size: 14px;
    line-height: 17px;
    color: #FFFFFF;
    height: 48px;
  }
  .alert-danger {
    color: red;
  }
  
 
</style>