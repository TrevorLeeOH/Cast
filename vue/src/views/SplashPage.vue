<template>
  <div class="splash">
    <div class="Frame-53">
      <!-- <div class="Image"> -->
        <img id="cast-gif" src="..\assets\Cast_your_vote1.gif" alt="Logo">
          <!-- <img id="logo" src="..\assets\CAST_logo-02.png" alt="logo"> -->
      <!-- </div> -->
      <div class="Content">        
          <!-- <div class="Pagination-Dots">
            <div class=".Dot"></div>
            <div class=".Dot"></div>
            <div class=".Dot"></div>
          </div> -->
        <span class="Make-your-voice-heard"> Make your voice heard!</span>
        <span class="rank">You don't fit in a box. Your vote shouldn't either!</span>
      <router-link class="sign-up-button" :to="{name: 'register'}"> Sign Up
       </router-link>
      <div class="login">
        <span class="Already-Registered-Login-now">Already Registered? 
            <router-link class="text-style-1" :to="{name: 'login'}">Login now</router-link>
        </span>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}

</script>

<style scoped>


.Frame-53 {
  
  width: 375px;
  height: 730px;
  max-height: 700px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  margin: 0.4px 0 0;
  padding: 0;
  border-radius: 12px;
  
}

.Image {
  align-self: stretch;
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 10px;
  padding: 40px;
  background-color: #edf2fe;
  height: 300px;
  
  
}
.Content {
  height: 326.6px;
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  gap: 24px;
  padding: 75px 24px 20px;
}


.Make-your-voice-heard {
  height: 29px;
  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 24px;
  font-weight: 900;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: 0.48px;
  text-align: left;
  color: #000;
}

.rank {
  height: 40px;
  align-self: stretch;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 16px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.25;
  letter-spacing: normal;
  text-align: left;
  color: #71727a;
}

.sign-up-button {
  align-self: stretch;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 8px;
  padding: 12px 16px;
  border-radius: 8px;
  background-color: #467bf5;
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  text-decoration: none;
  line-height: normal;
  letter-spacing: normal;
  text-align: left;
  color: #fff;
}

button {
  display: flex;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: normal;
  letter-spacing: normal;
  text-align: left;
  color: #fff;
  background-color: #467bf5;
  border: none;
}

.Already-Registered-Login-now {
  width: 204px;
  height: 17px;
  flex-grow: 0;
  font-family: 'museo-sans';
  font-size: 14px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.14;
  letter-spacing: 0.14px;
  text-align: center;
  color: #71727a;
}
.Already-Registered-Login-now .text-style-1 {
  font-weight: bold;
  line-height: normal;
  letter-spacing: normal;
  color: #467bf5;
  text-decoration: none;
}

.Pagination-Dots {
  width: 40px;
  height: 8px;
  flex-grow: 0;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 8px;
  padding: 0;
}

.Dot {
  width: 8px;
  height: 8px;
  flex-grow: 0;
  border-radius: 24px;
  background-color: #467bf5;
}

/* .Fill {
  width: 32px;
  height: 26.7px;
  background-color: #b5cafb;
} */

#logo {
  width: 100%;
  height: auto;
}

#cast-gif {
  border-top-right-radius: 12px;
  border-top-left-radius: 12px;
}



</style>