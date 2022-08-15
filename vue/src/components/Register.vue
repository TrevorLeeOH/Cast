<template>

  <div id="register" class="text-center">
    <div class="Sign-up">
      <link rel="stylesheet" href="https://use.typekit.net/ows0uho.css">
      <div class="Login-options">
        <div class="Text">
          <span class="sign-up">Sign up</span>
            <span class="Create-an-account-to-start-voting">
                Create an account to start voting
             </span>
        </div>
        <link rel="stylesheet" href="https://use.typekit.net/ows0uho.css">
        <form class="form-register" @submit.prevent="register">
          <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
          </div>
          <div class="Text-Field">
            <span class="Title"> Name </span>     
            <input
                    type="text"
                    id="username"
                    class="form-control"
                    placeholder="Username"
                    v-model="user.username"
                    required
                    autofocus
                  />            
            <span class="Title"> Email </span>
            <input
                  class="form-control"
                    placeholder="Email"
                    v-model="user.username"
                    required
                    autofocus
                  />
            <span class="Title"> Password </span>
            <input
                  type="password"
                  id="password"
                  class="form-control"
                  placeholder="Password"
                  v-model="user.password"
                  required
                />
            <input
                  type="password"
                  id="confirmPassword"
                  class="form-control"
                  placeholder="Confirm Password"
                  v-model="user.confirmPassword"
                  required
                /> 
            <div class="termsBox">
              <div class="Checkbox"></div>
                  <span class="Terms">
                      I've read and agree with the
                      <span class="text-style-1">Terms and Conditions</span>
                      and the
                      <span class="text-style-1">Privacy Policy</span>.
                      </span>
              </div>
            <button class="Button-Primary" type="submit">Create Account</button>
            </div>
       </form>  
      </div>
   </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
form {
  width: 327px;
  height: 309px;
  flex-grow: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  gap: 16px;
  padding: 0;
}

.Text-Field {
  width: 327px;
  height: 71px;
  flex-grow: 0;
  font-family: 'museo-sans';
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  gap: 8px;
  padding: 0;
}



.Title {
  height: 15px;
  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 12px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: normal;
  text-align: left;
  color: #2f3036;
  
}

.Button-Primary {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  padding: 12px 16px;
  gap:8px;

  width: 327px;
  height: 48px;

  background: #467BF5;
  border-radius: 8px;
  border: none;

  flex: none;
  order: 3;
  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-style: normal;
  font-weight: 600;
  font-size: 14px;
  line-height: 17px;

  color: #FFFFFF;


  flex: none;
  order: 1;
  flex-grow: 0;
}

.termsBox {
  height: 34px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  gap: 12px;
  padding: 0px
  ;
}

.Checkbox {
  width: 24px;
  height: 16px;
  flex-grow: 0;
  border-radius: 6px;
  border: solid 1.5px #c5c6cc;
}
.Terms {
  height: 34px;
  flex-grow: 1;
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.14;
  letter-spacing: 0.14px;
  text-align: left;
  color: #71727a;
  
  
}
.Terms .text-style-1 {
  font-weight: bold;
  line-height: normal;
  letter-spacing: normal;
  color: #467bf5;
}


.Text {
  height: 20px;
  flex-grow: 1;
  display: flex;
  flex-direction: row;
  font-family: 'museo-sans';
  justify-content: flex-start;
  align-items: center;
  gap: 1px;
  padding: 0;
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

.Text {
  width: 327px;
  height: 43px;
  flex-grow: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  gap: 8px;
  padding: 0;
}



</style>
