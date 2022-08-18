<template>
  <register></register>
</template>

<script>
import Register from '../components/Register.vue'
export default {
     components: { Register },

}
</script>

<style scoped>



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


/* .Sign-up {
  width: 375px;
  height: 812px;
  padding: 0 0 238px;
  background-color: #fff;
} */

.Login-options {
  width: 327px;
  height: 475px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  gap: 24px;
  margin: 44px 0 7px;
  padding: 24px;
}

.sign-up {
  width: 327px;
  height: 22px;
  flex-grow: 0;
  font-family: 'museo-sans-display';
  font-size: 18px;
  font-weight: 600;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.08px;
  text-align: left;
  color: #1f2024;
}

.Create-an-account-to-start-voting {
  width: 327px;
  height: 16px;
  flex-grow: 0;
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

.Button-Primary {
display: flex;
flex-direction: row;
justify-content: center;
align-items: center;
padding: 12px 16px;
gap: 8px;

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


</style>